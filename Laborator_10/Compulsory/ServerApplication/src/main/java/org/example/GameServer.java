package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class GameServer {
    public static final int PORT = 2500;

    public boolean serverRunning=true;
    ConsoleTread consoleTread;
    ServerSocket serverSocket = null;

    public GameServer() throws IOException {

        consoleTread =new ConsoleTread(this);//thread care asteapta cereri consola

        try {
            consoleTread.start();
            serverSocket = new ServerSocket(PORT);

            while (serverRunning) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();

                new ClientThread(socket,this).start();//thread: executare cereri de la clienti
            }


        }catch (SocketException e) {
            System.out. println ("Server closed");


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