package org.example;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    // Define the port on which the server is listening
    public static final int PORT = 2500;
    public boolean serverRunning=true;
    InputTread inputTread;
    ServerSocket serverSocket = null;
    List<Game> allGames=new ArrayList<>();

    private ClientThread[] threadPool;
    private int poolSize = 20;

    public GameServer() throws IOException {


        inputTread=new InputTread(this);

        try {
            inputTread.start();
            serverSocket = new ServerSocket(PORT);
            threadPool = new ClientThread[poolSize];

            while (serverRunning) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                boolean full=true;
                for (int i = 0; i < poolSize; i++) {
                    if (threadPool[i] == null) {
                        full=false;
                        threadPool[i] = new ClientThread(socket, this);
                        threadPool[i].start();
                        break;
                    } else if (!threadPool[i].isAlive()) {
                        full=false;
                        threadPool[i] = new ClientThread(socket, this);
                        threadPool[i].start();
                        break;
                    }
                }
                if (full) {
                    System.err.println("Serverul este plin!");

                    PrintWriter out = new PrintWriter(socket.getOutputStream());
                    String raspuns = "Server plin!";
                    out.println(raspuns);
                    out.flush();
                }


            }


        }catch (SocketException e) {
            System.out. println ("Server inchis!");


        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            serverSocket.close();
        }
    }
    public static void main ( String [] args ) throws IOException {
        GameServer server = new GameServer();
    }
}