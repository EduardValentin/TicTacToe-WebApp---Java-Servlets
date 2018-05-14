<%-- 
    Document   : login
    Created on : May 11, 2018, 8:36:10 AM
    Author     : Eduard
--%>

<%@page import="utility.AuthUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">    
    <title>TicTacToe - Login</title>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <h1>Login Here</h1>
        
        <% 
            /****** When client sends a request to login first we check if he has already logged in and if yes redirect him to index page *******/
            if(AuthUser.userIsLoggedIn(request)) {
                session.setAttribute("message","<center><h1>You are already logged in.</h1></center>");
                response.sendRedirect(request.getHeader("referer")); // return back to caller
                return;
            }
        %>
        
        <% 
            /******* Read anny session messages if they exist *******/      
            if(session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
                session.removeAttribute("message");
            }
        %>
        
        <form action="Login" method="POST">
            <input type ="text" placeholder="Username"  name="username"/>
            <input type ="password" placeholder="Password"  name="password"/>
            <input type="submit" value="Send" /> 
        </form>
    </body>
</html>
