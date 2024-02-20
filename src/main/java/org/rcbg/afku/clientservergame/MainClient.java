package org.rcbg.afku.clientservergame;

import java.io.IOException;
import java.util.Scanner;

public class MainClient {

    public static void main(String[] args) throws IOException {
        Client client = new Client();
        Scanner scanner = new Scanner(System.in);
        client.startConnection("127.0.0.1", 29999);
        while (true) {
            System.out.println("Chose option:");
            String option = scanner.next();
            System.out.println(client.sendMessage(option));
        }
    }
}
