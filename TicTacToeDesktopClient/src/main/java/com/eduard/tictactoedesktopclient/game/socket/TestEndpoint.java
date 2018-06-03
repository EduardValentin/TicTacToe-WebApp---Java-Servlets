/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eduard.tictactoedesktopclient.game.socket;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;

/**
 *
 * @author Eduard
 */
public class TestEndpoint extends Endpoint {

    private Session session;

    @Override
    public void onOpen(Session sn, EndpointConfig ec) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        this.session = sn;
        this.session.addMessageHandler(new MessageHandler.Whole<String>(){
            @Override
            public void onMessage(String message) {
                System.out.println("RECIEVED FROM SERVER: " + message);
            }
        
        });
    }
    
    public void sendMessage(String message){
        try {
            this.session.getBasicRemote().sendText(message);
        } catch (IOException ex) {
            Logger.getLogger(TestEndpoint.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
