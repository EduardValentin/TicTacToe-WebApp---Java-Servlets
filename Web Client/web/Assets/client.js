/* global playerUsername */
var loadingGifHtml;
var gameContainerHtml;
var endGameMessageHtml;
var turn; // turn = 1 daca e randul playerului sau 0 daca e randul oponentului
var opponentUsername = null;
var opponentMark = "-";
var playerMark = "-";
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

socket.onmessage = function(event) {
    var message = event.data;
    var messageParts = message.split("|");
    console.log(messageParts);
    switch (messageParts[0]) {
        case "LOST":
            endGameMessageHtml.innerHTML = "YOU LOST";
            break;
        case "MOVE":
            let squareNr = parseInt(messageParts[1]);
            doOpponentMove(squareNr);
            turn = 1;
            gameStatusDiv = "Your turn."
            break;
        case "WAIT":
            gameStatusDiv.innerHTML = "Searching for opponent...";
            gameContainerHtml.classList.add("hidden");
            loadingGifHtml.classList.add("show");
            console.log(messageParts[1]);
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
        table[parseInt(onSquareNr / 3)][onSquareNr % 3] = 0;
        for (var i = 0; i < squares.length; i++) {
            let data = parseInt(squares[i].getAttribute('data-index'));
            if (data == onSquareNr) {
                squares[i].style.background = "url('" + opponentMark + "') no-repeat center center";
            }
        }
        gameStatusDiv.innerHTML="Your turn.";

        turn = 1;
    }
}

function doPlayerMove() {
    let onSquareNr = this.getAttribute('data-index');
    if (turn == 1 && table[parseInt(onSquareNr / 3)][onSquareNr % 3] == -1) {

        table[parseInt(onSquareNr / 3)][onSquareNr % 3] = 1;
        let packet = "MOVE|" + playerUsername + "|" + opponentUsername + "|" + onSquareNr;
        //this.innerHTML = window.playerMark;
        this.style.background = "url('" + playerMark + "') no-repeat center center";
        turn = 0;
        gameStatusDiv.innerHTML="Opponent turn.";
        socket.send(packet);
    }
}