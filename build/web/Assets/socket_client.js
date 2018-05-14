window.onload = function(){
    var socket = new WebSocket("http://localhost:8080/TicTacToeWeb/");
    socket.onopen = function() {
        socket.send("CONNECTION OK");
        console.log("Socket open - Connection ok");
    };
    
};