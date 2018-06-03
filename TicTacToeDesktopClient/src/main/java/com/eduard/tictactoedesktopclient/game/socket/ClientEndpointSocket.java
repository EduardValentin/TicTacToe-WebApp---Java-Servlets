/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game.socket;

import com.eduard.tictactoedesktopclient.game.GameController;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author Eduard
 */
public class ClientEndpointSocket extends Endpoint {

    private Session session;

    @Override
    public void onOpen(Session sn, EndpointConfig ec) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.session = sn;
        this.session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String message) {
                GameController gameController = GameController.getInstance();
                // TODO: Handle recieved messages here
                System.out.println("Recieved: " + message + " from server");
                String[] messageParts = message.split("[| ]+");
                String messageType = messageParts[0];
                System.out.println(messageType);
                switch(messageType){
                    case "PLAYING":
                        String opponentUname = messageParts[1];
                        String firstPlayer = messageParts[2];
                        // TODO: remove waiting gif
                        gameController.setOpponentUsername(opponentUname);
                        
                        //display the ingame panel
                        JPanel rootPanel = (JPanel) gameController.getRootContainer();
                        CardLayout cl = (CardLayout) rootPanel.getLayout();
                        cl.show(rootPanel, "gameplayCard");
                        System.out.println(rootPanel.getAccessibleContext().getAccessibleName());
                        
                        if(firstPlayer.equals(gameController.getMyUsername())){
                            gameController.setPlayerTurn(true);
                            gameController.setMyIcon(gameController.X_ICON_LOCATION);
                            gameController.setOpponentIcon(gameController.O_ICON_LOCATION);
                        }else{
                            gameController.setPlayerTurn(false);
                            gameController.setMyIcon(gameController.O_ICON_LOCATION);
                            gameController.setOpponentIcon(gameController.X_ICON_LOCATION);
                        }
                        
                    break;
                    
                    case "MOVE":
                        // MOVE|from|to|square_nr
                        int squareNr = Integer.parseInt(messageParts[1]);
                        gameController.update(squareNr, 0);
                        gameController.setPlayerTurn(true);
                        Component square = GameController.getComponent(Integer.toString(squareNr), gameController.getRootContainer());
                        ((JButton)square).setIcon(gameController.getOpponentIcon());
                        
                    break;
                }
            }
        
        });
        
        try {
            this.session.getBasicRemote().sendText("JOIN|" + GameController.getInstance().getMyUsername());
        } catch (IOException ex) {
            Logger.getLogger(ClientEndpointSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(TestEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
