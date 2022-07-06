package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.domain.Result;

public class ResultDto {

  private String[][] board;

  public ResultDto(String[][] board) {
    this.board = board;
  }

  public static ResultDto from(Result board) {
    return new ResultDto(board.board());
  }

  public String[][] getBoard() {
    return board;
  }
}
