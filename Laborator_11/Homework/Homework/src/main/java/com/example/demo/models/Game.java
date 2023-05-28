package com.example.demo.models;


public class Game {
    int id;
    int numberGame;
    private Player player1;
    private Player player2;

    public Game(Player player1,int numberGame) {
        this.numberGame=numberGame;
        this.player1 = player1;
        player2 = null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumberGame() {
        return numberGame;
    }

    public void setNumberGame(int numberGame) {
        this.numberGame = numberGame;
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
