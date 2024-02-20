package org.rcbg.afku.clientservergame;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        System.out.println(sendMessage("0"));
    }

    public String sendMessage(String msg) throws IOException {
        out.println(msg);
        String resp = readMessage(in);
        return resp;
    }

    public String readMessage(BufferedReader bufferedReader) throws IOException {
        StringBuilder message = new StringBuilder();
        String line;
        while((line = bufferedReader.readLine()) != null && !line.isEmpty()){
            message.append(line);
            message.append("\n");
        }
        return message.toString();
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
