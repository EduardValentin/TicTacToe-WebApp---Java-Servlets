/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import sock.ClientEndpointSocket;

/**
 *
 * @author Eduard
 */
public class Game {
    private ClientEndpointSocket clientEndPoint = null;
    private String username;
    private boolean isLoggedIn = false;
    private static Game instance = null;
    private Integer count = 0;
    private int[][] buttonsMap = new int[3][3];
    private Icon icon;
    private Character tokenType; // X sau O(not zero)
    private ClientEndpointSocket clientEndpoint = null;
    private boolean isPlayerTurn;
    private String playerUsername;
    private String opponentUsername;
    
    private Game(){
        //final ClientEndpointSocket clientEndPoint = new ClientEndpointSocket(new URI("ws://localhost:9999/TicTacToeWeb/websocketendpoint"));
        GameWindowFrame window = new GameWindowFrame();
        window.setVisible(true);
        isPlayerTurn = true;
        icon = new ImageIcon("src/game/X.png");
        // initializeaza matricea butoanelor
            for(int i=0; i<3; i++)
                for(int j=0; j<3; j++)
                    buttonsMap[i][j] = -1;
        try{
            clientEndpoint = new ClientEndpointSocket(new URI("ws://localhost:9999/TicTacToeWeb/websocketendpoint"));
            
        }catch(URISyntaxException e){
            e.printStackTrace();
        }
    }
    public boolean isPlayerTurn(){
        return isPlayerTurn;
    }
    public Icon getIcon() {
        return icon;
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
            clientEndpoint.sendMessage("WON|" + playerUsername + "|" + opponentUsername);
        }
        
        if(buttonsMap[0][0] == 0 && buttonsMap[0][1] == 0 && buttonsMap[0][2] == 0 ||
           buttonsMap[1][0] == 0 && buttonsMap[1][1] == 0 && buttonsMap[1][2] == 0 ||
           buttonsMap[2][0] == 0 && buttonsMap[2][1] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][0] == 0 && buttonsMap[1][0] == 0 && buttonsMap[2][0] == 0 ||
           buttonsMap[0][1] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][1] == 0 ||
           buttonsMap[0][2] == 0 && buttonsMap[1][2] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][0] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][2] == 0 ||
           buttonsMap[0][2] == 0 && buttonsMap[1][1] == 0 && buttonsMap[2][0] == 0 ){
            clientEndpoint.sendMessage("WON|" + opponentUsername + "|" + playerUsername);
        }
        
        if(count == 9){
            clientEndpoint.sendMessage("WON|DRAW|DRAW");
        }  
    }

    public int[][] getButtonsMap() {
        return buttonsMap;
    }

    public void setButtonsMap(int[][] buttonsMap) {
        this.buttonsMap = buttonsMap;
    }
    
    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    
    public ClientEndpointSocket getClientEndPoint() {
        return clientEndPoint;
    }
    
    public char getTokenType() {
        return tokenType;
    }

    public String getPlayerUsername() {
        return playerUsername;
    }

    public String getOpponentUsername() {
        return opponentUsername;
    }
    
    public static Game getInstance(){
        if(instance == null)
            instance = new Game();
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