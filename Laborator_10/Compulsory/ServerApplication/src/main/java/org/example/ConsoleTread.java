package org.example;

import java.io.IOException;
import java.util.Scanner;

public class ConsoleTread extends Thread{
    boolean running=true;
    private Scanner scanner=new Scanner(System.in);

    GameServer server;

    public ConsoleTread(GameServer server)
    {
        this.server=server;
    }

    public void run()
    {
        String input= "";

        while (running)
        {
            System.out.print("Enter a command: \n");
            input = scanner.nextLine();

            System.out.println(input);

            if (input.equals("stop"))
            {
                running=false;
                server.serverRunning=false;

                try {
                    server.serverSocket.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }

    }


}
