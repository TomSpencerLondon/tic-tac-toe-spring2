package com.tomspencerlondon.tictactoe.hexagon.application;

import com.tomspencerlondon.tictactoe.hexagon.domain.Result;
import com.tomspencerlondon.tictactoe.hexagon.domain.Square;
import java.util.ArrayList;
import java.util.List;

public class GameService {

  public Result createBoard(String[][] board) {
    List<Square> takenSquares = getTakenSquares(board);

    return new Result(board, takenSquares);
  }

  private List<Square> getTakenSquares(String[][] board) {
    List<Square> takenSquares = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (!board[i][j].equals("")) {
          takenSquares.add(new Square(board[i][j], i, j));
        }
      }
    }
    return takenSquares;
  }
}
