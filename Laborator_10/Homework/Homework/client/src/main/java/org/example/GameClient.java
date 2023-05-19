package org.example;

import jdk.dynalink.linker.LinkerServices;
import sun.misc.Signal;
import sun.misc.SignalHandler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;

public class GameClient {
    public static void main (String[] args) throws IOException {
        String serverAddress = "127.0.0.1"; // The server's IP address
        int PORT = 2500; // The server's port

        try {

            Socket socket = new Socket(serverAddress, PORT);
            PrintWriter out =new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()));

            Signal.handle(new Signal("INT"), new SignalHandler() {
                public void handle(Signal sig) {
                    System.out.println("Caught signal " + sig);
                    out.println("exit");
                    out.flush();
                    System.exit(0);
                }
            });


            if(in.ready())
            {
                String response = in.readLine();
                System.out.println(response);
            }
            else {
                System.out.println("Toate comenzile sunt:");
                System.out.println("create game");
                System.out.println("join game");
                System.out.println("exit");
                while (true) {
                    // Send a request to the server
                    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
                    String request = console.readLine();

                    out.println(request);
                    out.flush();

                    if (request.equals("exit")) {
                        break;
                    }

                    if (request.equals("create game")) {
                        Board board = new Board();
                        char[][] boardChars = board.getBoard();

                        System.out.println("Asteptam adversarul...");
                        String response = in.readLine();
                        System.out.println("Adeversarul a venit, ai creat jocul cu numarul " + response);
                        System.out.println("Jocul a inceput!");
                        //pana se termina jocul
                        while (true) {
                            request = in.readLine();


                            if (request.length() == 2)
                                boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] = '2';
                            else if (request.length() == 3)
                                boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] = '2';

                            board.setBoard(boardChars);
                            char winner = board.checkWinner();

                            if (winner == '1') {
                                out.println("1");
                                out.flush();
                                System.out.println("Ai castigat!");
                                break;
                            }
                            if (winner == '2') {
                                out.println("2");
                                out.flush();
                                System.out.println("Ai pierdut!");
                                break;
                            }

                            board.printBoard();
                            System.out.println("Trimite mutarea ta:");
                            //citesc mutarea de la tastatura pana primesc una corecta
                            while (true) {

                                request = console.readLine();
                                if (request.charAt(0) >= 'A' && request.charAt(0) <= 'O') {
                                    if (request.length() == 2) {
                                        if (request.charAt(1) >= '1' && request.charAt(1) <= '9') {
                                            if (boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] == '-') {
                                                boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] = '1';
                                                break;
                                            }
                                        }
                                    } else if (request.length() == 3) {
                                        if (request.charAt(1) == '1' && request.charAt(2) >= '0' && request.charAt(2) <= '5') {
                                            if (boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] == '-') {
                                                boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] = '1';
                                                break;
                                            }
                                        }
                                    }
                                }
                                System.out.println("Mutare gresita!");

                            }
                            out.println(request);
                            out.flush();
                            System.out.println("Asteptam mutarea adversarului...");

                        }

                    }
                    if (request.equals("join game")) {
                        Board board = new Board();
                        char[][] boardChars = board.getBoard();

                        List<Integer> games = new ArrayList<>();


                        System.out.println("Alege un numar din cele de mai jos:");
                        String response = in.readLine();
                        int numberOfGames = Integer.parseInt(response);
                        for (int i = 0; i < numberOfGames; i++) {
                            response = in.readLine();
                            if (!response.equals("full")) {
                                System.out.println(response);
                                games.add(Integer.valueOf(response));
                            }
                        }
                        int ok = 0;
                        while (true) {
                            request = console.readLine();
                            for (int i : games) {
                                if (i == Integer.valueOf(request)) {
                                    ok = 1;
                                    break;
                                }
                            }
                            if (ok == 1)
                                break;
                            else System.out.println("Ai introdus un numar gresit");
                        }
                        //trimit numarul corect
                        out.println(request);
                        out.flush();

                        System.out.println("Ai intrat in jocul " + request + "!");
                        System.out.println("Jocul a inceput!");
                        while (true) {
                            System.out.println("Asteptam mutarea adversarului...");
                            request = in.readLine();
                            if (request.length() == 2) {
                                boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] = '1';
                            } else if (request.length() == 3)
                                boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] = '1';


                            board.setBoard(boardChars);
                            char winner = board.checkWinner();

                            if (winner == '2') {
                                out.println("2");
                                out.flush();
                                System.out.println("Ai castigat!");
                                break;
                            }
                            if (winner == '1') {
                                out.println("1");
                                out.flush();
                                System.out.println("Ai pierdut!");
                                break;
                            }
                            board.printBoard();
                            System.out.println("Trimite mutarea ta:");

                            //citesc mutarea de la tastatura pana primesc una corecta
                            while (true) {

                                request = console.readLine();
                                if (request.charAt(0) >= 'A' && request.charAt(0) <= 'O') {
                                    if (request.length() == 2) {
                                        if (request.charAt(1) >= '1' && request.charAt(1) <= '9') {
                                            if (boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] == '-') {
                                                boardChars[request.charAt(1) - 48][request.charAt(0) - 'A' + 2] = '2';
                                                break;
                                            }
                                        }
                                    } else if (request.length() == 3) {
                                        if (request.charAt(1) == '1' && request.charAt(2) >= '0' && request.charAt(2) <= '5') {
                                            if (boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] == '-') {
                                                boardChars[(request.charAt(1) - 48) * 10 + (request.charAt(2) - 48)][request.charAt(0) - 'A' + 2] = '2';
                                                break;
                                            }
                                        }
                                    }
                                }
                                System.out.println("Wrong move");

                            }
                            out.println(request);
                            out.flush();
                        }

                    }

                    String response = in.readLine();
//                    System.out.println(response);

                    if (response.equals("Server stopped")) {
                        break;
                    }

                    if (response.equals("Server full")) {
                        break;
                    }


                }

            }
        } catch (UnknownHostException e) {
            System.err.println("No server listening... " + e);
        }
    }
}