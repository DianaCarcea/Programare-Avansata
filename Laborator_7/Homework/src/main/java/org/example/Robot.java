package org.example;

import java.util.List;

import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    private int row,col;
    private Exploration explore;

    private int numberOfTokensPlaced;



    public Robot(String name, int row, int col, Exploration explore) {
        this.name = name;
        this.row=row;
        this.col=col;
        this.explore=explore;
        running=true;
        numberOfTokensPlaced=0;
    }

    public void run() {
        while (running) {


            if(col<explore.n && explore.getMap().occupiedCell(row, col+1)) {//dreapta
                col = col + 1;
                explore.getMap().visit(row, col, this);
            }
            else
            if(row< explore.n && explore.getMap().occupiedCell(row+1, col )) {//jos
                row = row + 1;
                explore.getMap().visit(row, col, this);
            }
            else
            if(col>1 && explore.getMap().occupiedCell(row, col-1)) {//stanga
                col = col - 1;
                explore.getMap().visit(row, col, this);
            }
            else
            if(row>1 && explore.getMap().occupiedCell(row-1, col)) {//sus
                {
                    row = row - 1;
                    explore.getMap().visit(row, col, this);
                }
            }
            else{
                List<Integer> position= explore.getMap().getEmptyCell();

                if(position==null) {//totul este vizitat
                    running = false;
                }
                else
                {
                    row=position.get(0);
                    col=position.get(1);
                    explore.getMap().visit(row, col, this);
                }
            }

            try {
                sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getName() {
        return name;
    }
    public int getNumberOfTokensPlaced() {
        return numberOfTokensPlaced;
    }

    public void updateNumberOfTokensPlaced(int n) {
        this.numberOfTokensPlaced = numberOfTokensPlaced+n;
    }
}