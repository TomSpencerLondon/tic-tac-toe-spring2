package com.tomspencerlondon.tictactoe.hexagon.application;

import com.tomspencerlondon.tictactoe.adapter.in.api.CreateSquareParameters;
import com.tomspencerlondon.tictactoe.hexagon.domain.Board;
import com.tomspencerlondon.tictactoe.hexagon.domain.BoardPosition;
import com.tomspencerlondon.tictactoe.hexagon.domain.Player;
import com.tomspencerlondon.tictactoe.hexagon.domain.State;

public class GameService {
    private final Board board = new Board();
    private State currentState = State.GAME_ON;

   /* public Result createBoard(String[][] board) {
        List<Square> takenSquares = getTakenSquares(board);

        return new Result(board, takenSquares);
    }

    private List<Square> getTakenSquares(String[][] board) {
        List<Square> takenSquares = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!board[i][j].equals("")) {
                    //takenSquares.add(new Square(board[i][j], i, j));
                }
            }
        }
        return takenSquares;
    }*/

    public Board getBoard() {
        return board;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void playMove(Player player,
                         CreateSquareParameters parameters) {
        board.makeMove(player, new BoardPosition(parameters.getX(), parameters.getY()));

        updateState();
    }

    private void updateState() {
        // TODO calculate if somebody won and update the state accordingly
    }
}
