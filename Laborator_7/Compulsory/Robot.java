package org.example;
import java.util.List;
import static java.lang.Thread.sleep;

public class Robot implements Runnable {
    private String name;
    private boolean running;
    int row,col;
    Exploration explore;
    public Robot(String name,int row,int col,Exploration explore) {
        this.name = name;
        this.row=row;
        this.col=col;
        this.explore=explore;
        running=true;
    }

    public void run() {
        while (running) {

            //dreapta
            if(col<explore.n && explore.getMap().occupiedCell(row, col+1)) {
                col = col + 1;
                explore.getMap().visit(row, col, this);
            }
            else
            //jos
            if(row< explore.n && explore.getMap().occupiedCell(row+1, col )) {
                row = row + 1;
                explore.getMap().visit(row, col, this);
            }
            else
            //stanga
            if(col>1 && explore.getMap().occupiedCell(row, col-1)) {
                col = col - 1;
                explore.getMap().visit(row, col, this);
            }
            else
            //sus
            if(row>1 && explore.getMap().occupiedCell(row-1, col)) {
                {
                    row = row - 1;
                    explore.getMap().visit(row, col, this);
                }
            }
            else{
                List<Integer> position= explore.getMap().getEmptyCell();

                if(position==null) {
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
}