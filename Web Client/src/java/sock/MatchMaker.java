/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sock;

import com.mysql.jdbc.Connection;
import data.DatabaseConnection;
import data.PlayerModel;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import javax.annotation.Resource;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import javax.inject.Inject;
import javax.enterprise.context.ApplicationScoped;
import javax.sql.DataSource;

@ApplicationScoped
@ServerEndpoint("/websocketendpoint")
public class MatchMaker {
	private SessionHandler sessionHandler = SessionHandler.getInstance();
        //private DatabaseConnection databaseCon = DatabaseConnection.getInstance();
        @Resource(name = "jdbc/TicTacToeDb")
        private DataSource dbResource;
	@OnOpen
	public void onOpen(Session session,EndpointConfig config) throws IOException{
            System.out.println("Open Connection ...");
            
	}
	
	@OnClose
	public void onClose(){
            System.out.println("Close Connection ...");
	}
	
	@OnMessage
	public void onMessage(String message,Session session) throws IOException, SQLException{
            System.out.println("Message from the client: " + message);
            String[] parts = message.split("\\|");
            String typeOfOperation = parts[0];
            String from = null;
            System.out.println(typeOfOperation);
            switch(typeOfOperation) {
                case "JOIN":
                    String playerUsername = parts[1];
                    System.out.println(playerUsername + " yayaya");
                    PlayerModel newPlayer = new PlayerModel(playerUsername,session);
                    if(sessionHandler.playersInQueue() == false){
                        // Nu sunt jucatori care asteapta in coada ,deci nu are cu cine sa joace
                        sessionHandler.addInQueue(newPlayer);
                    } else {
                        PlayerModel opponent = sessionHandler.removeFromQueue();    // Ia cel mai vechi jucator ce asteapta la coada
                        opponent.setOpponent(playerUsername);
                        newPlayer.setOpponent(opponent.getUsername());
                        sessionHandler.addPlaying(newPlayer, opponent);
                        String first;
                        if(Math.random() >= 0.5) {
                            first = newPlayer.getUsername();
                        } else {
                            first = opponent.getUsername();
                        }
                        /*** Mesajul trimis e de tipul: PLAYING|cu_cine|cine_incepe_primul ***/

                        sessionHandler.sendMessageTo(playerUsername,"PLAYING|"+opponent.getUsername()+"|"+first);
                        sessionHandler.sendMessageTo(opponent.getUsername(),"PLAYING|"+newPlayer.getUsername()+"|"+first);
                    }
                    break;
                case "MOVE" :
                   from = parts[1];
                   String to = parts[2];
                   String squareNr = parts[3];
                   System.out.println("From:" + from + " | To: " + to + " | Move: " + squareNr); 
                   sessionHandler.sendMessageTo(to, "MOVE|"+squareNr);
                   break;
                case "WON" :
                   from = parts[1];
                   to = parts[2];
                   System.out.println(from + " won the game.");                 
                   // we need to save the game to database
                   String insertQuery = "INSERT INTO games(won,lost,game_date) VALUES (?,?,TO_DATE(?,'day-mon-yyyy hh24:mi:ss'))";
                   try(Connection con = (Connection) dbResource.getConnection();
                       PreparedStatement ps = con.prepareStatement(insertQuery);
                    ){
                       ps.setString(1, from);
                       ps.setString(2, to);
                       Date d= new Date();
                       ps.setString(0,d.toString());
                       ps.executeUpdate();
                   }
                   
                   sessionHandler.removeFromPlaying(to);
                   sessionHandler.removeFromPlaying(from);
                   break;
                default :
                   System.out.println("Invalid message");
             }
	}

	@OnError
	public void onError(Throwable e){
		e.printStackTrace();
	}

}