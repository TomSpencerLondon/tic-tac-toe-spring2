package com.tomspencerlondon.tictactoe.hexagon.domain;

/**
 * This class represents a board in the game of tic-tac-toe
 */
public class Board {
    private final Square[][] squares;

    public Board() {
        squares = new Square[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                squares[x][y] = new Square(new BoardPosition(x, y));
            }
        }
    }

    public void makeMove(Player player, BoardPosition position) {
        squares[position.x()][position.y()].setPlayer(player);
    }

    public Square[][] getSquares() {
        return squares;
    }
}
