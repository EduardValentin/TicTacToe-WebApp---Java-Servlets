/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import com.mysql.jdbc.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Eduard
 */
public class AuthUser {

    public static boolean checkUser(String user, String pass) {
        boolean st = false;
        try {
            ConnectionHelper  connectionHelper = ConnectionHelper.getInstance();
            Connection conn = (Connection) connectionHelper.getConnectionToDB();
            PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, user);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();
         } catch (SQLException ex) {
            Logger.getLogger(AuthUser.class.getName()).log(Level.SEVERE, null, ex);
        }
        return st;
    }
}