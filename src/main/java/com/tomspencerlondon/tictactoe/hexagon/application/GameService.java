package com.tomspencerlondon.tictactoe.hexagon.application;

import com.tomspencerlondon.tictactoe.hexagon.domain.Result;
import com.tomspencerlondon.tictactoe.hexagon.domain.Square;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameService {

  public Result createBoard(String[][] board) {
    List<Square> takenSquares = getTakenSquares(board);

    if (takenSquares.size() == 9) {
      return new Result(board);
    }

    return new Result(playComputerMove(board, takenSquares));
  }

  private String[][] playComputerMove(String[][] board, List<Square> takenSquares) {
    while (true) {
      Random random = new Random();
      int x = random.nextInt(3);
      int y = random.nextInt(3);
      Square square = new Square(x, y);
      if (!takenSquares.contains(square)) {
        board[x][y] = "O";
        break;
      }
    }

    return board;
  }

  private List<Square> getTakenSquares(String[][] board) {
    List<Square> takenSquares = new ArrayList<>();
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (!board[i][j].equals("")) {
          takenSquares.add(new Square(i, j));
        }
      }
    }
    return takenSquares;
  }
}
