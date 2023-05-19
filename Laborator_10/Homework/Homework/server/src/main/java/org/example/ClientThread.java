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
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            while (running && server.serverRunning) {
                if (in.ready()) {
                    String request = in.readLine();
//                    System.out.println(request);

                    if (request.equals("exit")) {
                        System.out.println("The client left");
                        running = false;
                    }

                    if (request.equals("create game"))
                    {
                        int numberGame=server.allGames.size()+1;
                        Game game=new Game(numberGame);
                        Player player=new Player();
                        game.setPlayer1(player);
                        server.allGames.add(game);

                        while (true)
                        {
                            sleep(10);
                            //Asteptare adversar
                            if(server.allGames.get(numberGame-1).getPlayer2()!=null)
                            {
                                break;
                            }
                        }

                        out.println(numberGame);
                        out.flush();
                        //cel care creaza da primul
                        server.allGames.get(numberGame-1).getPlayer1().setTurn(true);


                        while (true) {
                            sleep(10);
                            if(server.allGames.get(numberGame-1).getPlayer1().isTurn()) {
                                //trimit miscarea adversarului
                                out.println(server.allGames.get(numberGame-1).getPlayer2().move);
                                out.flush();

                                request = in.readLine();
//                                System.out.println(request);

                                //verific daca jocul e gata = am un castigator
                                if (request.charAt(0)=='1' || request.charAt(0)=='2' ) {
                                    server.allGames.get(numberGame-1).getPlayer2().setTurn(true);
                                    break;
                                }

                                server.allGames.get(numberGame-1).getPlayer1().move=request;

                                server.allGames.get(numberGame-1).getPlayer1().setTurn(false);
                                server.allGames.get(numberGame-1).getPlayer2().setTurn(true);

                            }
                        }
                    }

                    if (request.equals("join game"))
                    {
                        int numberGame=server.allGames.size();
                        out.println(numberGame);
                        out.flush();

                        for (Game game : server.allGames) {
                            if(game.getPlayer2()==null) {
                                int response = game.numberGame;
                                out.println(response);
                                out.flush();
                            }
                            else {
                                String response = "full";
                                out.println(response);
                                out.flush();
                            }
                        }

                        String response=in.readLine();
//                        System.out.println(response);

                        Player player=new Player();

                        server.allGames.get(Integer.valueOf(response)-1).setPlayer2(player);

                        server.allGames.get(numberGame-1).getPlayer2().setTurn(false);

                        while (true) {
                            sleep(10);
                            if(server.allGames.get(numberGame-1).getPlayer2().turn) {

                                //trimit miscarea adversarului
                                out.println(server.allGames.get(numberGame-1).getPlayer1().move);
                                out.flush();

                                request = in.readLine();
//                                System.out.println(request);

                                //verific daca jocul e gata = am un castigator
                                if (request.charAt(0)=='1' || request.charAt(0)=='2' ) {
                                    server.allGames.get(numberGame-1).getPlayer1().setTurn(true);
                                    break;
                                }
                                server.allGames.get(numberGame-1).getPlayer2().move=request;

                                server.allGames.get(numberGame-1).getPlayer2().setTurn(false);
                                server.allGames.get(numberGame-1).getPlayer1().setTurn(true);

                            }
                        }
//                        CreateGame createGame=new CreateGame(game);
                    }



                    String raspuns = "Server received the request...";
                    out.println(raspuns);
                    out.flush();


                }else if (!server.serverRunning) {
                    String raspuns = "Server stopped";
                    out.println(raspuns);
                    out.flush();
                    running = false;
                }
            }


        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) { System.err.println (e); }
        }
    }
}