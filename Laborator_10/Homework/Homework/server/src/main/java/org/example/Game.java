package org.example;

public class Game {
    int numberGame;
    private Player player1;
    private Player player2;

    public Game(int numberGame) {
        this.numberGame = numberGame;
    }

    public int getNumberGame() {
        return numberGame;
    }


    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

}
