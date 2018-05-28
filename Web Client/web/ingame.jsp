<%-- 
    Document   : in_game
    Created on : May 14, 2018, 3:57:26 PM
    Author     : eduar
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://fonts.googleapis.com/css?family=Open+Sans" rel="stylesheet">
        <link href="Assets/styles.css" rel="stylesheet" type="text/css">    
        <title>Tic Tac Toe - In Game</title>
        <script type="text/javascript">
             var playerUsername = '<%= session.getAttribute("loggedWithUser") %>';
        </script>
    </head>
    <body>
        <%@ include file="header.jsp" %>
        
        <div id="game-info">
            <div id="game-status"></div>
            <div id="playing-with"></div>
        </div>
        <div id="loading" class="show"></div>
        
        <div id="game-container" class="hidden">
            <div class="row-flex-container grid-row">
                <div class="square" data-index="0"></div>
                <div class="square" data-index="1"></div>
                <div class="square" data-index="2"></div>
            </div>
            <div class="row-flex-container grid-row">
                <div class="square" data-index="3"></div>
                <div class="square" data-index="4"></div>
                <div class="square" data-index="5"></div>
            </div>
            <div class="row-flex-container grid-row">
                <div class="square" data-index="6"></div>
                <div class="square" data-index="7"></div>
                <div class="square" data-index="8"></div>
            </div>
        </div>
        <script type="text/javascript" src="Assets/client.js"></script>

    </body>
</html>
