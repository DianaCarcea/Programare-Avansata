package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {
    private Socket socket = null ;
    private boolean running=true;
    GameServer server;
    public ClientThread (Socket socket, GameServer server) {
        this.socket = socket ;
        this.server=server;

    }

    public void run () {
        try {
            //primeste info de la client
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //trimit info spre client
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (running) {

                String request = in.readLine();
                System.out.println(request);

                if (request.equals("exit"))
                {
                    System.out.println("The client left");
                    running=false;
                }
                if(!server.serverRunning)
                {
                    String raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    running=false;
                }
                else {
                    String raspuns = "Server received the request...";
                    out.println(raspuns);
                    out.flush();
                }

            }


        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}