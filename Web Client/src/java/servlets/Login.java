/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import data.DatabaseConnection;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

/**
 *
 * @author Eduard
 */
public class Login extends HttpServlet {
    
    //DatabaseConnection databaseCon = DatabaseConnection.getInstance();
    @Resource(name = "jdbc/TicTacToeDb")
    private DataSource dbResource;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        //try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        try (Connection conn = (Connection) dbResource.getConnection()){
            boolean hasAccount = false;
            
            PreparedStatement ps = conn.prepareStatement("select * from users where username=? and password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            hasAccount = rs.next();

            if (session.getAttribute("loggedWithUser") != null) {
                session.setAttribute("message", "<div class=\"message\">You are already logged in.</div>");
                response.sendRedirect("index.jsp"); // return back to caller
            }
            else if (hasAccount == true) {
                session.setAttribute("loggedWithUser", username);
                session.setAttribute("message", "<div class=\"message\">You logged in.</div>");
                response.sendRedirect("index.jsp"); // return back to caller
            } else {
                session.setAttribute("message", "<div class=\"message\">Username or password are incorect, try again and make sure you have an accout.</div>");
                response.sendRedirect(request.getHeader("referer")); // return back to caller
            }
        }

        //}

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
   
}