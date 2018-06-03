/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game;

import com.eduard.tictactoedesktopclient.game.socket.ClientEndpointSocket;
import com.eduard.tictactoedesktopclient.game.ui.GameWindowFrame;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;

/**
 *
 * @author Eduard
 */
public class GameController {
    private final WebSocketContainer container;
    private final ClientEndpointSocket endpoint;
    private boolean isLoggedIn = false;
    private static GameController instance = null;
    private Session connection;
    private final GameWindowFrame window;
    private final Container rootContainer ;
    /* ============ GameController Variables ============ */
    
    private Integer count = 0;
    private final int[][] buttonsMap;
    private Icon myIcon;
    private Icon opponentIcon;
    private Character tokenType; // X sau O(not zero)
    private boolean isPlayerTurn;
    private String myUsername;
    private String opponentUsername;
    private final String SERVER_URI = "ws://localhost:9999/TicTacToeWeb/websocketendpoint";
    public final String X_ICON_LOCATION = "C:\\Users\\Eduard\\Documents\\Developer\\TicTacToe-WebApp---Java-Servlets\\TicTacToeDesktopClient\\src\\main\\java\\com\\eduard\\tictactoedesktopclient\\game\\ui\\X.png";
    public final String O_ICON_LOCATION = "C:\\Users\\Eduard\\Documents\\Developer\\TicTacToe-WebApp---Java-Servlets\\TicTacToeDesktopClient\\src\\main\\java\\com\\eduard\\tictactoedesktopclient\\game\\ui\\O.png";

    private GameController(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        window = new GameWindowFrame();
        window.setVisible(true);
        this.container = ContainerProvider.getWebSocketContainer();
        this.endpoint = new ClientEndpointSocket();
        List<Component> comps = GameController.getAllComponents(window);
        Container found = null;
        for(Component c : comps){
            String compName = c.getAccessibleContext().getAccessibleName();
            if(compName != null)
            if( compName != null && compName.equals("windowContentPanel")==true){
                found = (Container) c;
            }
        }
        if(found != null)
            this.rootContainer = found;
        else{
                this.rootContainer =  null;
                System.err.println("ERROR: ROOT CONTAINER NOT FOUND");  
            }
        this.isPlayerTurn = true;
        this.buttonsMap = new int[3][3];
        for(int i=0; i<3; i++)
            for(int j=0;j<3;j++)
                this.buttonsMap[i][j] = -1;
    }
    
    public void connectSocketToServer() throws URISyntaxException, DeploymentException, IOException{
        connection = this.container.connectToServer(this.endpoint,new URI(this.SERVER_URI));
    }
    public void closeConnectionToServer() throws IOException{
        connection.close();
    }
    
    public boolean isPlayerTurn(){
        return isPlayerTurn;
    }
    
    public void update(int index, int from){
        count++;
        buttonsMap[index/3][index%3] = from;
        
        if(buttonsMap[0][0] == 1 && buttonsMap[0][1] == 1 && buttonsMap[0][2] == 1 ||
           buttonsMap[1][0] == 1 && buttonsMap[1][1] == 1 && buttonsMap[1][2] == 1 ||
           buttonsMap[2][0] == 1 && buttonsMap[2][1] == 1 && buttonsMap[2][2] == 1 ||
           buttonsMap[0][0] == 1 && buttonsMap[1][0] == 1 && buttonsMap[2][0] == 1 ||
           buttonsMap[0][1] == 1 && buttonsMap[1][1] == 1 && buttonsMap[2][1] == 1 ||
           buttonsMap[0][2] == 1 && buttonsMap[1][2] == 1 && buttonsMap[2][2] == 1 ||
           buttonsMap[0][0] == 1 && buttonsMap[1][1] == 1 && buttonsMap[2][2] == 1 ||
           buttonsMap[0][2] == 1 && buttonsMap[1][1] == 1 && buttonsMap[2][0] == 1 ){
            endpoint.sendMessage("WON|" + myUsername + "|" + opponentUsername);
            // I won
            this.switchToCard("victoryCard");
        }
        
        if(buttonsMap[0][0] == 0 && buttonsMap[0][1] == 0 && buttonsMap[0][2] == 0 ||
           buttonsMap[1][0] == 0 && buttonsMap[1][1] == 0 && buttonsMap[1][2] == 0 ||
           buttonsMap[2][0] == 0 && buttonsMap[2][1] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][0] == 0 && buttonsMap[1][0] == 0 && buttonsMap[2][0] == 0 ||
           buttonsMap[0][1] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][1] == 0 ||
           buttonsMap[0][2] == 0 && buttonsMap[1][2] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][0] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][2] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][0] == 0 ){
            // I lost
            this.switchToCard("gameOverCard");
        }
        
        if(count == 9){
            endpoint.sendMessage("DRAW|"+this.myUsername+"|"+this.opponentUsername);
            this.switchToCard("drawCard");
        }  
    }
    public static void setLabel(String withName,String value,Container root){
        List<Component> components = GameController.getAllComponents(root);
        for(Component c:components){
            if(c instanceof JLabel){
                String labelName = c.getAccessibleContext().getAccessibleName();
                if(labelName != null && labelName.equals(withName)){
                    JLabel source = (JLabel)c;
                    source.setText(value);
                }
            }
        }
    }

    public Icon getMyIcon() {
        return myIcon;
    }

    public void setMyIcon(String iconLocation) {
        this.myIcon = new ImageIcon(iconLocation);
    }

    public Icon getOpponentIcon() {
        return opponentIcon;
    }

    public void setOpponentIcon(String iconLocation) {
        this.opponentIcon = new ImageIcon(iconLocation);
    }
    
    public static Component getComponent(String withName,Container root){
        List<Component> components = GameController.getAllComponents(root);
        for(Component c : components ) {
            String componentName = c.getAccessibleContext().getAccessibleName();
            if(componentName != null && componentName.equals(withName)){
                return c;
            }
        }
        
        return null;
    }
    
    public static List<Component> getAllComponents(final Container c) {
        Component[] comps = c.getComponents();
        List<Component> compList = new ArrayList<>();
        for (Component comp : comps) {
            compList.add(comp);
            if (comp instanceof Container)
                compList.addAll(getAllComponents((Container) comp));
        }
        return compList;
    }
    
    public int[][] getButtonsMap() {
        return buttonsMap;
    }
    
    
    public boolean isIsPlayerTurn() {
        return isPlayerTurn;
    }

    public void setPlayerTurn(boolean val){
        this.isPlayerTurn = val;
        // update turn label
        if(val == true)
            GameController.setLabel("turnLabel","Your turn.", rootContainer);
        else
            GameController.setLabel("turnLabel","Opponent turn.", rootContainer);
    }
    public void switchToCard(String withName){
        CardLayout cl = (CardLayout) this.rootContainer.getLayout();
        cl.show(rootContainer, withName);
        GameController.setLabel("messageLabel", "", rootContainer);
    }
    public ClientEndpointSocket getClientEndPoint() {
        return endpoint;
    }
    public void sendMessageToServer(String message) throws IOException{
        if(connection.isOpen() == true){
            connection.getBasicRemote().sendText(message);
        } else {
            System.err.println("Connection was not open and a message was being sent.");
        }
    }
    
    public void restartGame(){
        count = 0;
        for(int i=0; i<3; i++)
            for(int j=0;j<3;j++)
                this.buttonsMap[i][j] = -1;
        
        List<Component> gameComponents = GameController.getAllComponents(rootContainer);
        gameComponents.forEach((c) -> {
            String compName = c.getAccessibleContext().getAccessibleName();
            if (compName != null && Pattern.matches("[0-9]", compName)) {
                JButton button = (JButton)c;
                button.setIcon(null);
            }
        });
        this.switchToCard("loadingCard");
        
        try {
            this.connection.close();
            this.connectSocketToServer();
        } catch (URISyntaxException | DeploymentException | IOException ex) {
            Logger.getLogger(GameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setOpponentUsername(String opponentUsername) {
        this.opponentUsername = opponentUsername;
    }
    
    public String getMyUsername() {
        return myUsername;
    }
    public void setMyUsername(String withValue){
        this.myUsername = withValue;
    }
    public String getOpponentUsername() {
        return opponentUsername;
    }

    public Container getRootContainer() {
        return rootContainer;
    }
    
    public static GameController getInstance(){
        if(instance == null)
            instance = new GameController();
        return instance;
    }
    public boolean userIsLogged(){
        return isLoggedIn;
    }
    public void logUserIn(){
        isLoggedIn = true;
    }
    public void logUserOut(){
        isLoggedIn = false;
    }
}