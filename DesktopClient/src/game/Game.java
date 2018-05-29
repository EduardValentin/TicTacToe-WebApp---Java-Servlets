/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.net.URI;
import java.net.URISyntaxException;
import socket.ClientEndpointSocket;

/**
 *
 * @author Eduard
 */
public class Game {
    final ClientEndpointSocket clientEndPoint = null;
    public static void main(String[] args) throws URISyntaxException {
        
        // open websocket
        final ClientEndpointSocket clientEndPoint = new ClientEndpointSocket(new URI("ws://localhost:9999/TicTacToeWeb/websocketendpoint"));

    }
}