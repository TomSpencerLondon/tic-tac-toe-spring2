package com.tomspencerlondon.tictactoe.adapter.in.api;

public class SquareDto {

  private String[][] board;

  public SquareDto(String[][] board) {
    this.board = board;
  }

  public static SquareDto from(String[][] board) {
    return new SquareDto(board);
  }

  public String[][] getBoard() {
    return board;
  }
}
