/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import servlets.MatchMaking;

/**
 *
 * @author Eduard
 */
public class ConnectionHelper {
    private static ConnectionHelper _instance;
    private Connection _dbConnection;
    
    private final String _url = "jdbc:mysql://localhost/tictactoedb";
    private final String _pass = "superduperpwd";
    private final String _user = "admin";
    
    static {
        try {
          Class.forName("com.mysql.jdbc.Driver");
          System.out.println("Successfuly loaded MySQL Driver");
        } catch(ClassNotFoundException ex) {
          System.err.println("Unable to load MySQL Driver");
        }
    }
    
    private ConnectionHelper(){
        try {
            _dbConnection = (com.mysql.jdbc.Connection) DriverManager.getConnection(_url,_user,_pass);
            System.out.println("We are connected to sample database!");
        } catch (SQLException ex) {
            Logger.getLogger(MatchMaking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static ConnectionHelper getInstance(){
        if (_instance == null) {
            _instance = new ConnectionHelper();
        }
        return _instance;
    }
    
    public void openConnection(){
        try {
            _dbConnection = (com.mysql.jdbc.Connection) DriverManager.getConnection(_url,_user,_pass);
            System.out.println("We are connected to sample database!");
        } catch (SQLException ex) {
            Logger.getLogger(MatchMaking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Connection getConnectionToDB() throws SQLException {
        if(_dbConnection.isClosed() || _dbConnection == null) {
            // If connection was closed we open a new one / we didnt open a connection
            try {
                _dbConnection = (com.mysql.jdbc.Connection) DriverManager.getConnection(_url,_user,_pass);
                System.out.println("We are connected to sample database!");
            } catch (SQLException ex) {
                Logger.getLogger(MatchMaking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return _dbConnection;
    }
    
    public void closeConnection(){
       try{
           _dbConnection.close();
       } catch(SQLException ex) {
           Logger.getLogger(MatchMaking.class.getName()).log(Level.SEVERE, null, ex);
       }
    }
    
}
