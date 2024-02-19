package org.rcbg.afku.clientservergame;
import java.io.IOException;
import java.net.*;

public class TcpServer {
    private ServerSocket serverSocket;
    private Socket clientSocket;

    public void start(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        this.clientSocket = serverSocket.accept();

    }
}
