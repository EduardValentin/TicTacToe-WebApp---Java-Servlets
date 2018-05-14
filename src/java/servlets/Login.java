/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import utility.AuthUser;
import utility.ConnectionHelper;

/**
 *
 * @author Eduard
 */
public class Login extends HttpServlet {
    private ConnectionHelper connectionHelper;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException, SQLException {
        //try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession(true);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (AuthUser.userIsLoggedIn(request)) {
            session.setAttribute("message", "<center><h1>You are already logged in.</h1></center>");
            response.sendRedirect("index.jsp"); // return back to caller
            return;
        }
        else if (AuthUser.checkUser(username, password)) {
            //Cookie loginCookie = new Cookie("loggedWithUsername", username);
            //loginCookie.setMaxAge(60 * 60 * 24);
            //response.addCookie(loginCookie);
            session.setAttribute("loggedWithUser", username);
            session.setAttribute("message", "<center><h1>You logged in.</h1></center>");
            response.sendRedirect("index.jsp"); // return back to caller
            return;

        } else {
            session.setAttribute("message", "<center><h1>Username or password are incorect, try again and make sure you have an accout.</h1></center>");
            response.sendRedirect(request.getHeader("referer")); // return back to caller
            return;
        }

        //}

    }

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    } // </editor-fold>

    @Override
    public void init() throws ServletException {
        super.init();
        connectionHelper = ConnectionHelper.getInstance();
        connectionHelper.openConnection();
    }

    @Override
    public void destroy() {
        super.destroy();
        connectionHelper.closeConnection();
    }



}