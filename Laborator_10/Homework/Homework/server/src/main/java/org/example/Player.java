package org.example;

public class Player {
    boolean turn=false;
    String move="";

    public Player( ) {
    }

    public boolean isTurn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }
}
