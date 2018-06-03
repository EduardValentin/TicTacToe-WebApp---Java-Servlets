<%-- 
    Document   : login
    Created on : May 11, 2018, 8:36:10 AM
    Author     : Eduard
--%>


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
        
        
        <% 
            /****** When client sends a request to login first we check if he has already logged in and if yes redirect him to index page *******/
            if(session != null && session.getAttribute("loggedWithUser") != null) {
                session.setAttribute("message","<center><h1>You are already logged in.</h1></center>");
                response.sendRedirect(request.getHeader("referer")); // return back to caller
                return;
            }
        %>
        
        <% 
            if(session.getAttribute("message") != null) {
                out.println("<div class=\"message-popup collumn-flex-container\">" + session.getAttribute("message") + "</div>");
                session.removeAttribute("message");
            }
        %>
        
        <form action="Login" method="POST" class="user-form collumn-flex-container">
            <div class="label-wrap">
                <label for="username">Username:</label>
                <input type ="text" placeholder="Username" id="username" name="username"/>
            </div>
            <div class="label-wrap">
                <label for="password">Password:</label>
                <input type ="password" placeholder="Password" id="password" name="password"/>
            </div>
            <input type="submit" class="custom-button" value="Send" /> 
        </form>
    </body>
</html>
