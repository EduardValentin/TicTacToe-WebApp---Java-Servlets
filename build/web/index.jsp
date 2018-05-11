<%-- 
    Document   : index
    Created on : May 7, 2018, 10:19:24 PM
    Author     : Eduard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tic Tac Toe App</title>
    </head>
    <body>
        <% 
            /*if(request.getAttribute("message") != null) {
                out.println(request.getAttribute("message"));
                request.removeAttribute("message");
            }*/
            
            if(session.getAttribute("message") != null) {
                out.println(session.getAttribute("message"));
                session.removeAttribute("message");
            }
        %>

        <h1>Wellcome to the super TicTacToe App!</h1>
        <a href="login.jsp">Login here</a>
        
        <% out.println("Your IP address is " + request.getRemoteAddr()); %>
    </body>
</html>
