/* global playerUsername */
var loadingGifHtml;
var gameContainerHtml;
var endGameMessageHtml;
var turn; // turn = 1 daca e randul playerului sau 0 daca e randul oponentului
var opponentUsername = null;
var opponentMark = "-";
var playerMark = "-";
var count = 0;
var table = [
    [-1, -1, -1],
    [-1, -1, -1],
    [-1, -1, -1]
]; // In casuta se pune 1 daca e casuta ocupata de player,altfel 0 daca e ocupata de oponent, -1 daca e libera
var socket = new WebSocket('ws://localhost:9999/TicTacToeWeb/websocketendpoint');
var squares;
var playingWithDiv = document.getElementById("playing-with");
var gameStatusDiv = document.getElementById("game-status");
var goFirstDiv = document.getElementById("go-first");

window.onbeforeunload = function(){
  socket.send("CLOSE|" + playerUsername);
};

squares = document.getElementsByClassName('square');
for (var i = 0; i < squares.length; i++) {
    squares[i].addEventListener("click", doPlayerMove, true);
}

loadingGifHtml = document.getElementById("loading");
gameContainerHtml = document.getElementById("game-container");



socket.onopen = function() {
    console.log("Socket open - Connection ok");
    socket.send("JOIN|" + playerUsername);
};

socket.onclose = function(){
    socket.send("CLOSE|"+playerUsername);
};

socket.onmessage = function(event) {
    var message = event.data;
    var messageParts = message.split("|");
    console.log(messageParts);
    switch (messageParts[0]) {
        case "MOVE":
            let squareNr = parseInt(messageParts[1]);
            doOpponentMove(squareNr);
            break;
        case "PLAYING":
            /*** Mesajul primit e de tipul: PLAYING|cu_cine|cine_incepe_primul ***/
            opponentUsername = messageParts[1];
            if (messageParts[2] == playerUsername) {
                playerMark = 'Assets/X.png';
                opponentMark = 'Assets/O.png';
                gameStatusDiv.innerHTML="You go first.";
                turn = 1;
            } else {
                playerMark = 'Assets/O.png';
                opponentMark = 'Assets/X.png';
                gameStatusDiv.innerHTML="Opponent turn.";
                turn = 0;
            }
            if (loadingGifHtml.classList.contains("show")) {
                loadingGifHtml.classList.remove("show");
                loadingGifHtml.classList.add("hidden");
            }

            if (gameContainerHtml.classList.contains("hidden")) {
                gameContainerHtml.classList.remove("hidden");
                gameContainerHtml.classList.add("show");
            }
            playingWithDiv.innerHTML = "Playing with: " + opponentUsername;
            
            break;
        default:
            alert("Mesaj incorect catre server");
    }

};

socket.onerror = function(error) {
    console.log(error);
};


function doOpponentMove(onSquareNr) {
    if (table[parseInt(onSquareNr / 3)][onSquareNr % 3]) {
        count++;
        table[parseInt(onSquareNr / 3)][onSquareNr % 3] = 0;
        for (var i = 0; i < squares.length; i++) {
            let data = parseInt(squares[i].getAttribute('data-index'));
            if (data == onSquareNr) {
                squares[i].style.background = "url('" + opponentMark + "') no-repeat center center";
            }
        }
        gameStatusDiv.innerHTML="Your turn.";
        turn = 1;
        checkGameState();
    }
}

function doPlayerMove() {
    let onSquareNr = this.getAttribute('data-index');
    if (turn == 1 && table[parseInt(onSquareNr / 3)][onSquareNr % 3] == -1) {
        count++;
        table[parseInt(onSquareNr / 3)][onSquareNr % 3] = 1;
        gameStatusDiv.innerHTML = "Opponent turn"
        let packet = "MOVE|" + opponentUsername + "|" + onSquareNr;
        //this.innerHTML = window.playerMark;
        this.style.background = "url('" + playerMark + "') no-repeat center center";
        turn = 0;
        socket.send(packet);
        checkGameState();
    }
}

function checkGameState(){
    // player win conditions:
    var isSetRow1 = table[0][0] == 1 && table[0][1] == 1 && table[0][2] == 1,
        isSetRow2 = table[1][0] == 1 && table[1][1] == 1 && table[1][2] == 1,
        isSetRow3 = table[2][0] == 1 && table[2][1] == 1 && table[2][2] == 1,
        isSetCol1 = table[0][0] == 1 && table[1][0] == 1 && table[2][0] == 1,
        isSetCol2 = table[0][1] == 1 && table[1][1] == 1 && table[2][1] == 1,
        isSetCol3 = table[0][2] == 1 && table[1][2] == 1 && table[2][2] == 1,
        isSetDiagPr = table[0][0] == 1 && table[1][1] == 1 && table[2][2] == 1,
        isSetDiagSec = table[0][2] == 1 && table[1][1] == 1 && table[2][0] == 1;
    
    var isWin = isSetRow1 || isSetRow2 || isSetRow3 || isSetCol1 || isSetCol2 || isSetCol3 || isSetDiagPr || isSetDiagSec;
    if( isWin === true ){
        socket.send("WON|"+playerUsername + "|" + opponentUsername);
        window.location.replace("victory.jsp");
    }
    
        isSetRow1 = table[0][0] == 0 && table[0][1] == 0 && table[0][2] == 0;
        isSetRow2 = table[1][0] == 0 && table[1][1] == 0 && table[1][2] == 0;
        isSetRow3 = table[2][0] == 0 && table[2][1] == 0 && table[2][2] == 0;
        isSetCol1 = table[0][0] == 0 && table[1][0] == 0 && table[2][0] == 0;
        isSetCol2 = table[0][1] == 0 && table[1][1] == 0 && table[2][1] == 0;
        isSetCol3 = table[0][2] == 0 && table[1][2] == 0 && table[2][2] == 0;
        isSetDiagPr = table[0][0] == 0 && table[1][1] == 0 && table[2][2] == 0;
        isSetDiagSec = table[0][2] == 0 && table[1][1] == 0 && table[2][0] == 0;
    
    isWin = isSetRow1 || isSetRow2 || isSetRow3 || isSetCol1 || isSetCol2 || isSetCol3 || isSetDiagPr || isSetDiagSec;
    if( isWin === true ){
        window.location.replace("gameover.jsp");
    }
    
    if( count === 9) {
        socket.send("DRAW|"+playerUsername+"|"+opponentUsername);
        window.location.replace("draw.jsp");
    }
}