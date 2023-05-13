package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1";
        int PORT = 2500;

        try {

            Socket socket = new Socket(serverAddress, PORT);
            //trimite info catre server
            PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
            //primim de la server mesaje
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            while (true) {
                // Trimite cereri catre server
                BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                String request = console.readLine();

                out.println(request);

                if(request.equals("exit"))
                {
                    break;
                }

                String response = in.readLine ();
                System.out.println(response);

                if(response.equals("Server stopped"))
                {
                    break;
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}