package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Exploration {

    public int n;
    private  final SharedMemory memory;
    private final ExplorationMap map;
    private final List<Robot> robots = new ArrayList<>();
    private List<Thread> listOfThreads=new ArrayList<>();

    public Exploration(int n) {
        this.n = n;
        this.memory = new SharedMemory(n);
        this.map = new ExplorationMap(n,memory);
    }

    public ExplorationMap getMap()
    {
        return map;
    }

    public void addRobot(Robot robot)
    {
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            listOfThreads.add(new Thread(robot));
        }

        for (Thread thread : listOfThreads) {
            thread.start();
        }

        for (Thread thread : listOfThreads) {
            try {
                thread.join();
            } catch (InterruptedException exception) {
                throw new RuntimeException();
            }
        }

    }

    public static void main(String args[]) {
        int matrixDimension=7;
        Exploration explore = new Exploration(matrixDimension);
        Random randRow = new Random();
        Random randCol = new Random();

        explore.addRobot(new Robot("Wall-E",randRow.nextInt(matrixDimension)+1,randCol.nextInt(matrixDimension)+1,explore));
        explore.addRobot(new Robot("R2D2",randRow.nextInt(matrixDimension)+1,randCol.nextInt(matrixDimension)+1,explore));
        explore.addRobot(new Robot("Optimus Prime",randRow.nextInt(matrixDimension)+1,randCol.nextInt(matrixDimension)+1,explore));
        explore.start();

        System.out.println(explore.map);

        for(Robot robot : explore.robots){
            System.out.println(robot.getNumberOfTokensPlaced());
        }

    }
}