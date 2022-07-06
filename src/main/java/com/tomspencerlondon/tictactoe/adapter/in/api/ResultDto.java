package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Result;
import com.tomspencerlondon.tictactoe.hexagon.domain.State;

public class ResultDto {

  private String[][] board;
  private String state;
  private boolean gameOn;

  public ResultDto(String[][] board, State state, boolean gameOn) {
    this.board = board;
    this.gameOn = gameOn;

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
        this.gameOn = true;
      }
    }
  }

  public static ResultDto from(Result result) {
    return new ResultDto(result.board(), result.state(), false);
  }

  public String[][] getBoard() {
    return board;
  }

  public String getState() {
    return state;
  }

  public boolean isGameOn() {
    return gameOn;
  }
}
