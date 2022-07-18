package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe.hexagon.domain.State;

public class GameDto {
    private final BoardDto board;
    private final State status;

    public GameDto(BoardDto board,
                   State status) {
        this.board = board;
        this.status = status;
    }

    public static GameDto from(Board board,
                               State status) {
        return new GameDto(BoardDto.fromBoard(board), status);
    }

    public BoardDto getBoard() {
        return board;
    }

    public State getStatus() {
        return status;
    }
}
