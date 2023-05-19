package org.example;

public class Board {
    private char board[][]=new char[17][17];

    public Board() {
        int number = 15;
        for (int i = board.length - 1; i >= 1; i--) {
            for (int j = 0; j < board[i].length; j++) {
                if (i == board.length - 1 && j > 0) {
                    board[i][j] = (char) ('A' + j - 2);
                } else if (j == 0 && i < board.length - 1) {
                    String rowLabel = String.format("%02d", number);
                    board[i][j] = rowLabel.charAt(0);
                    board[i][j + 1] = rowLabel.charAt(1);
                    j++;
                    number--;
                } else {
                    board[i][j] = '-';
                }
            }
        }
        board[16][0]=' ';
        board[16][1]=' ';
    }


    public char[][] getBoard() {
        return board;
    }

    public void setBoard(char[][] board) {
        this.board = board;
    }

    public void printBoard() {
        for (int i = 1; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(!(j==0 && i<=9))
                    System.out.print(board[i][j]);
                else
                    System.out.print(" ");
                if(j!=0)
                    System.out.print(" ");
            }
            System.out.println();
        }
    }

    public char checkWinner() {
        int size = board.length;

        // Check rows
        for (int i = 1; i < board.length-1; i++) {
            for (int j = 2; j < board[i].length - 4; j++) {
                if (board[i][j] != '-' &&
                        board[i][j] == board[i][j+1] &&
                        board[i][j] == board[i][j+2] &&
                        board[i][j] == board[i][j+3] &&
                        board[i][j] == board[i][j+4]) {
                    return board[i][j];
                }
            }
        }

        // Check columns
        for (int i = 1; i < board.length - 5; i++) {
            for (int j = 2; j < board[i].length; j++) {
                if (board[i][j] != '-' &&
                        board[i][j] == board[i+1][j] &&
                        board[i][j] == board[i+2][j] &&
                        board[i][j] == board[i+3][j] &&
                        board[i][j] == board[i+4][j]) {
                    return board[i][j];
                }
            }
        }

        // Check diagonals (top-left to bottom-right)
        for (int i = 1; i < board.length - 5; i++) {
            for (int j = 2; j < board[i].length - 4; j++) {
                if (board[i][j] != '-' &&
                        board[i][j] == board[i+1][j+1] &&
                        board[i][j] == board[i+2][j+2] &&
                        board[i][j] == board[i+3][j+3] &&
                        board[i][j] == board[i+4][j+4]) {
                    return board[i][j];
                }
            }
        }

        // Check diagonals (top-right to bottom-left)
        for (int i = 1; i < board.length - 5; i++) {
            for (int j = 6; j < board[i].length; j++) {
                if (board[i][j] != '-' &&
                        board[i][j] == board[i+1][j-1] &&
                        board[i][j] == board[i+2][j-2] &&
                        board[i][j] == board[i+3][j-3] &&
                        board[i][j] == board[i+4][j-4]) {
                    return board[i][j];
                }
            }
        }

        return '-'; // No winner found
    }


}
