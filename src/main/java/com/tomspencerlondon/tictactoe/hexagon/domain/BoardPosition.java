package com.tomspencerlondon.tictactoe.hexagon.domain;

import org.springframework.util.Assert;

public record BoardPosition(int x, int y) {
    public BoardPosition {
        Assert.isTrue(x >= 0 && x < 3, "x can only be 0, 1 or 2");
        Assert.isTrue(y >= 0 && y < 3, "y can only be 0, 1 or 2");
    }
}
