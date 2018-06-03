/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game.socket;

import com.eduard.tictactoedesktopclient.game.GameController;
import java.awt.Component;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
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
        
        // Add a message handler that handles the messages recieved from the server
        this.session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String message) {
                GameController gameController = GameController.getInstance();
                String[] messageParts = message.split("[| ]+");
                String messageType = messageParts[0];
                switch(messageType){
                    case "PLAYING":
                        String opponentUname = messageParts[1];
                        String firstPlayer = messageParts[2];
                        
                        gameController.setOpponentUsername(opponentUname);
                        GameController.setLabel("versusLabel", "Versus: " + gameController.getOpponentUsername(), gameController.getRootContainer());
                        gameController.switchToCard("gameplayCard");
                        //Decide who's first
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
                        // MOVE|square_nr
                        int squareNr = Integer.parseInt(messageParts[1]);
                        gameController.update(squareNr, 0);
                        gameController.setPlayerTurn(true);
                        Component square = GameController.getComponent(Integer.toString(squareNr), gameController.getRootContainer());
                        ((JButton)square).setIcon(gameController.getOpponentIcon());
                        
                    break;
                }
            }
        
        });
        
        // Send a join message to server to put us in queue for playing
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
            Logger.getLogger(ClientEndpointSocket.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
