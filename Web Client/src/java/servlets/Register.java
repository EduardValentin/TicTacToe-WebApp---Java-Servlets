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
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

public class Register extends HttpServlet {

    public static final Pattern EMAIL_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
    
    //DatabaseConnection databaseCon = DatabaseConnection.getInstance();
    @Resource(name = "jdbc/TicTacToeDb")
    private DataSource dbResource;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession(true);
        String messageForUser = new String("");
        try(Connection dbConnection = dbResource.getConnection()) {
        
            String first_name = request.getParameter("first_name");
            String last_name = request.getParameter("last_name");
            String email = request.getParameter("email");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            boolean error = false;
            /**** Perform input validation ****/
            
            if(!EMAIL_REGEX.matcher(email).matches()) {
                messageForUser += "<div class=\"error-popup\"> Email is not valid.</div> </br>";
                //session.setAttribute("email-error-popup","<div class=\"error-popup\"> Email is not valid.</div>");
                //response.sendRedirect("register.jsp");
                error = true;
            }
            if(!first_name.matches("[a-zA-Z]+")) {
                //session.setAttribute("first-name-error-popup","<div class=\"error-popup\"> First name not valid.</div>");
                messageForUser += "<div class=\"error-popup\"> First name not valid.</div></br>";
                error=true;
                //response.sendRedirect("register.jsp");
            } 
            if(!last_name.matches("[a-zA-Z]+")) {
                //session.setAttribute("last-name-error-popup","<div class=\"error-popup\"> Last name not valid.</div>");
                messageForUser+= "<div class=\"error-popup\"> Last name not valid.</div></br>";
                error = true;
                //response.sendRedirect("register.jsp");
            } 
            if(error == false){
                /**** Everything is okay ****/
                PreparedStatement statement = dbConnection.prepareStatement("INSERT INTO users(first_name,last_name,email,username,password) VALUES(?,?,?,?,?)");
                statement.setString(1, first_name);
                statement.setString(2, last_name);
                statement.setString(3, email);
                statement.setString(4, username);
                statement.setString(5, password);
                statement.execute();
                session.setAttribute("message","<div class=\"message\">Your account was created with succes, you can log in now.</div>");
                response.sendRedirect("index.jsp");
            } else{
                session.setAttribute("message",messageForUser);
                response.sendRedirect("register.jsp");

            }
        }
    }

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
