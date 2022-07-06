package com.tomspencerlondon.tictactoe.hexagon.domain;

public class Square {
  private final int x;
  private final int y;

  public Square(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }

    Square square = (Square) o;

    if (x != square.x) {
      return false;
    }
    return y == square.y;
  }

  @Override
  public int hashCode() {
    int result = x;
    result = 31 * result + y;
    return result;
  }
}
