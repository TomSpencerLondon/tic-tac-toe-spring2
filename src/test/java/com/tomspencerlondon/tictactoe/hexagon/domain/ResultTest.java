package com.tomspencerlondon.tictactoe.hexagon.domain;

import static com.tomspencerlondon.tictactoe.hexagon.domain.State.COMPUTER_WINS;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.DRAW;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.GAME_ON;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.PLAYER_WINS;
import static org.assertj.core.api.Assertions.*;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

class ResultTest {

  @Test
  void givenEmptyBoardStateIsGameOn() {
    String[][] board = new String[][]{
        {"", "", ""},
        {"", "", ""},
        {"", "", ""}
    };

    Result result = new Result(board, Collections.emptyList());

    assertThat(result.state())
        .isEqualTo(GAME_ON);
  }

  @Test
  void givenFullBoardWithNoWinnerStateIsDraw() {
    String[][] board = new String[][]{
        {"X", "O", "X"},
        {"O", "O", "X"},
        {"X", "X", "O"}
    };

    List<Square> squares = List.of(
        new Square(board[0][0], 0, 0), new Square(board[0][1], 0, 1), new Square(board[0][2], 0, 2),
        new Square(board[1][0], 1, 0), new Square(board[1][1], 1, 1), new Square(board[1][2], 1, 2),
        new Square(board[2][0], 2, 0), new Square(board[2][1], 2, 1), new Square(board[2][2], 2, 2));
    Result result = new Result(board, squares);

    assertThat(result.state())
        .isEqualTo(DRAW);
  }

  @Test
  void givenXWinningCombinationStateIsPlayerWins() {
    String[][] board = new String[][]{
        {"X", "X", "X"},
        {"O", "O", "X"},
        {"O", "X", "O"}
    };

    List<Square> squares = List.of(
        new Square(board[0][0], 0, 0), new Square(board[0][1], 0, 1), new Square(board[0][2], 0, 2),
        new Square(board[1][0], 1, 0), new Square(board[1][1], 1, 1), new Square(board[1][2], 1, 2),
        new Square(board[2][0], 2, 0), new Square(board[2][1], 2, 1), new Square(board[2][2], 2, 2));
    Result result = new Result(board, squares);

    assertThat(result.state())
        .isEqualTo(PLAYER_WINS);
  }

  @Test
  void givenOWinningCombinationsStateIsPlayerWins() {
    String[][] board = new String[][]{
        {"X", "X", "O"},
        {"O", "O", "O"},
        {"X", "X", "O"}
    };

    List<Square> squares = List.of(
        new Square(board[0][0], 0, 0), new Square(board[0][1], 0, 1), new Square(board[0][2], 0, 2),
        new Square(board[1][0], 1, 0), new Square(board[1][1], 1, 1), new Square(board[1][2], 1, 2),
        new Square(board[2][0], 2, 0), new Square(board[2][1], 2, 1), new Square(board[2][2], 2, 2));
    Result result = new Result(board, squares);

    assertThat(result.state())
        .isEqualTo(COMPUTER_WINS);
  }
}