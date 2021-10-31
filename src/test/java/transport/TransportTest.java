package transport;

import transport.nettyTransport.client.ClientStart;
import transport.nettyTransport.server.ServerStart;

import javax.sound.sampled.FloatControl;

/**
 * @Author: Mercer JR
 * @Date: 2021/10/31 11:42
 */
public class TransportTest {

    public static void main(String[] args) {
        String ip = "localhost";
        int port = 7777;
        ServerStart.startServer(ip,port);
        ClientStart.initClient(ip,port);
    }

}
