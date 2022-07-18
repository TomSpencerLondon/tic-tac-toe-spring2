package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe.hexagon.domain.Square;

public class BoardDto {
    private final SquareDto[][] squares;

    public BoardDto(SquareDto[][] squares) {
        this.squares = squares;
    }

    public static BoardDto fromBoard(Board board) {
        Square[][] boardSquares = board.getSquares();
        SquareDto[][] squareDtos = new SquareDto[3][3];
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                Square square = boardSquares[x][y];
                squareDtos[x][y] = SquareDto.fromSquare(square);
            }
        }
        return new BoardDto(squareDtos);
    }

    public SquareDto[][] getSquares() {
        return squares;
    }
}
