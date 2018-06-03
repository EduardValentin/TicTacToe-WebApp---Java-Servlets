/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.Session;

/**
 *
 * @author Eduard
 */
public class PlayerModel {
    private final String _username;
    private String _opponent;
    private final Session _session;
    private String state;
    
    public PlayerModel(String _username, Session _session) {
        this._username = _username;
        this._session = _session;
    }

    public String getOpponent() {
        return _opponent;
    }

    public void setOpponent(String _opponent) {
        this._opponent = _opponent;
    }
    public void closeConnectionToServer(){
        try {
            this._session.close();
        } catch (IOException ex) {
            Logger.getLogger(PlayerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Session getSession() {
        return _session;
    }

    public String getUsername() {
        return _username;
    }
    
}
