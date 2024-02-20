package org.rcbg.afku.clientservergame;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameThread extends Thread{
    private ServerSocket hostServerSocket;
    private ServerSocket guestServerSocket;

    public GameThread(int hostPort, int guestPort) throws IOException {
        this.hostServerSocket = new ServerSocket(hostPort);
        this.guestServerSocket = new ServerSocket(guestPort);
    }

    @Override
    public void run(){
        Socket hostSocket;
        Socket guestSocket;

        try {
            hostSocket = hostServerSocket.accept();
            guestSocket = guestServerSocket.accept();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Game logic here
    }

}
