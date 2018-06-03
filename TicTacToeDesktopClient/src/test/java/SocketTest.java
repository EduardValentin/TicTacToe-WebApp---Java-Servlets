/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.eduard.tictactoedesktopclient.game.socket.TestEndpoint;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.Session;
import javax.websocket.WebSocketContainer;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Eduard
 */
public class SocketTest {

    private WebSocketContainer container;
    private TestEndpoint endpoint;
    
    public SocketTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.container = ContainerProvider.getWebSocketContainer();
        this.endpoint = new TestEndpoint();
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //ws://localhost:9999
     @Test
     public void hello() {
        try {
            try {
                Session connection = this.container.connectToServer(this.endpoint,new URI("ws://localhost:9999/TicTacToeWeb/websocketendpoint"));
                this.endpoint.sendMessage("Hi server sup ? ");
            } catch (DeploymentException | IOException ex ) {
                Logger.getLogger(SocketTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (URISyntaxException ex) {
            Logger.getLogger(SocketTest.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
}
