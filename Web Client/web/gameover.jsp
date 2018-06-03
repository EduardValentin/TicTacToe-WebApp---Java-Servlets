<%-- 
    Document   : gameover
    Created on : Jun 2, 2018, 1:21:12 PM
    Author     : Eduard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Super TicTacToe - GameOver</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">    
    </head>
    <body>
        <%@ include file="header.jsp" %>

        <div id="gameover-content-wrapper" class="collumn-flex-container">
            <h1>You lost! Good luck next time!</h1>
            <img src="Assets/gameOver.png" id="game-over-img" alt="gameover-img" />
            <form action="ingame.jsp" method="POST">
                <input type="submit" class="custom-button" value="Restart">
            </form>
        </div>
        
        
    </body>
</html>
