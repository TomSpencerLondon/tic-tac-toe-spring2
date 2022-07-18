package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Player;
import com.tomspencerlondon.tictactoe.hexagon.domain.Square;

public class SquareDto {
    private final Player player;
    private final int x;
    private final int y;

    public SquareDto(Player player,
                     int x,
                     int y) {
        this.player = player;
        this.x = x;
        this.y = y;
    }

    public static SquareDto fromSquare(Square square) {
        return new SquareDto(square.player(),
                             square.position().x(),
                             square.position().y());
    }

    public Player getPlayer() {
        return player;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
