package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Result;
import com.tomspencerlondon.tictactoe.hexagon.domain.State;

public class ResultDto {

  private String[][] board;
  private String state;

  public ResultDto(String[][] board, State state) {
    this.board = board;

    switch (state) {
      case DRAW -> {
        this.state = "Draw!";
      }
      case PLAYER_WINS -> {
        this.state = "Player X wins!";
      }
      case COMPUTER_WINS -> {
        this.state = "Computer wins!";
      }
      default -> {
        this.state = "Game On!";
      }
    }
  }

  public static ResultDto from(Result result) {
    return new ResultDto(result.board(), result.state());
  }

  public String[][] getBoard() {
    return board;
  }

  public String getState() {
    return state;
  }
}
