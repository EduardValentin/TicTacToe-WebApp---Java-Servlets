<%-- 
    Document   : draw
    Created on : Jun 2, 2018, 1:41:47 PM
    Author     : Eduard
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">    
        <title>Super TicTacToe - Draw</title>
    </head>
    <body>
        <div id="gameover-content-wrapper" class="collumn-flex-container">
            <h1>Draw! Try again!</h1>
            <img src="Assets/drawGame.png" id="draw-img" alt="drawr-img" />
            <form action="ingame.jsp" method="POST">
                <input type="submit" class="custom-button" value="Restart">
            </form>
        </div>
    </body>
</html>
