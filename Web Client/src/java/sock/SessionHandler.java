/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sock;

import data.PlayerModel;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Eduard
 */
public class SessionHandler {
    private final LinkedList<PlayerModel> inQueue = new LinkedList<>();
    private final HashMap<String,PlayerModel> playing = new HashMap<>();
    private static SessionHandler instance;
    private SessionHandler() {
    }
    public static SessionHandler getInstance(){
        if(instance == null) {
            instance = new SessionHandler();
        }
        return instance;
    }
    public void addInQueue(PlayerModel p){
        inQueue.addLast(p);
    }
    public PlayerModel removeFromQueue(){
        PlayerModel playerToRemove = inQueue.pop();
        return playerToRemove;
    }
    public boolean playersInQueue(){
        return !inQueue.isEmpty();
    }
    
    public void addPlaying(PlayerModel p1,PlayerModel p2) {
        p1.setOpponent(p2.getUsername());
        p2.setOpponent(p1.getUsername());
        playing.put(p1.getUsername(), p1);
        playing.put(p2.getUsername(), p2);
    }
    public void removeFromPlaying(String username){
        PlayerModel playerToRemove = playing.get("username");
        playing.remove(username);
    }
    public void removeFromQueue(String username){
        int i = 0;
        for(PlayerModel p:inQueue){
            if(p.getUsername().equals(username)){
                inQueue.remove(i);
            } else{
                i++;
            }
        }
    }
    public void getPlayerWithUsernameInGame(String username){
        playing.get(username);
    }
    public void sendMessageTo(String user,String message) throws IOException{
        PlayerModel usr = playing.get(user);
        usr.getSession().getBasicRemote().sendText(message);
    }
    public String queueToString(){
        return inQueue.toString();
    }
}
