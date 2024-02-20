package org.rcbg.afku.clientservergame;
import java.io.IOException;
import java.net.*;

public class Server {
    private ServerSocket serverSocket;
    private ThreadManager threadManager = new ThreadManager();

    public void start(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        while (true){
            threadManager.createMenuThread(serverSocket.accept());
        }
    }

    public void stop() throws IOException {
        threadManager.killAllThreads();
        serverSocket.close();
    }

}
