package org.rcbg.afku.clientservergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MenuThread extends Thread{

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public MenuThread(Socket socket){
        this.clientSocket = socket;
    }

    @Override
    public void run(){
        try {
            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));

            String inputLine;
            while((inputLine = in.readLine()) != null){
                if("0".equals(inputLine)){
                    System.out.println("Menu called"); // Debug
                    out.println(getMenu());
                }
                if("9".equals(inputLine)){
                    break;
                }
            }

            out.close();
            in.close();
            clientSocket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    private String getMenu(){
        return """
                1 - List lobbies
                2 - Join lobby
                3 - Create lobby
                """;
    }
}
