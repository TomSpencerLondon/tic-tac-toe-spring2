package com.tomspencerlondon.tictactoe.hexagon.domain;

import static com.tomspencerlondon.tictactoe.hexagon.domain.State.DRAW;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.GAME_ON;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Result {

  private State state;
  private String[][] board;

  public Result(String[][] board) {
    this.board = board;
    this.state = GAME_ON;

    if (isDraw()) {
      this.state = DRAW;
    }
  }

  public String[][] board() {
    return this.board;
  }

  public State state() {
    return this.state;
  }

  private boolean isDraw() {
    return Arrays.stream(board)
        .flatMap(Arrays::stream)
        .anyMatch(Predicate.not(String::isEmpty));

  }
}
