package com.tomspencerlondon.tictactoe.hexagon.domain;

public final class Square {
    private Player player;
    private final BoardPosition position;

    public Square(BoardPosition position) {
        this.position = position;
    }

    public Player player() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public BoardPosition position() {
        return position;
    }

}
