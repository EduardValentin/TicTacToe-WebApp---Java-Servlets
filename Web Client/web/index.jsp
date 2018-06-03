<%-- 
    Document   : index
    Created on : May 7, 2018, 10:19:24 PM
    Author     : Eduard
--%>
<%
    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
    response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
    response.setHeader("Expires", "0"); // Proxies.
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>       
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <title>Tic Tac Toe App</title>
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">    
    </head>
    <body>
        <%@ include file="header.jsp" %>
        <img src="Assets/xo.jpg" id="banner" alt="banner"/>
        <% 
            if(session.getAttribute("message") != null) {
                 
                out.println("<div class=\"message-popup collumn-flex-container\">" + session.getAttribute("message") + "</div>");
                session.removeAttribute("message");
            }
        %>
        <form action="ingame.jsp" method="POST">
            <input type="submit" id="play-button" class="custom-button" value="Play"/>
        </form>
        
    </body>
</html>
