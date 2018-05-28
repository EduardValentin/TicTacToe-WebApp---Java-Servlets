/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.sql.DataSource;

/**
 *
 * @author eduar
 */
public class DatabaseConnection {
    @Resource(name = "jdbc/TicTacToeDb")
    private DataSource dbResource;
    
    private DatabaseConnection() {
    }
    public Connection getConnection() throws SQLException{
  
        return dbResource.getConnection();
       
    }
    public static DatabaseConnection getInstance() {
        return DatabaseConnectionHolder.INSTANCE;
    }
    
    private static class DatabaseConnectionHolder {

        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }
}
