package com.tomspencerlondon.tictactoe.hexagon.domain;

import static com.tomspencerlondon.tictactoe.hexagon.domain.State.DRAW;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.GAME_ON;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultTest {

  @Test
  void givenEmptyBoardStateIsGameOn() {
    String[][] board = new String[][]{
        {"", "", ""},
        {"", "", ""},
        {"", "", ""}
    };
    Result result = new Result(board);

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
    Result result = new Result(board);

    assertThat(result.state())
        .isEqualTo(DRAW);
  }
}