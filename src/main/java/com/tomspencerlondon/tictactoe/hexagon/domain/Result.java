package com.tomspencerlondon.tictactoe.hexagon.domain;

import static com.tomspencerlondon.tictactoe.hexagon.domain.State.COMPUTER_WINS;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.DRAW;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.GAME_ON;
import static com.tomspencerlondon.tictactoe.hexagon.domain.State.PLAYER_WINS;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Stream;

public class Result {

  private State state;
  private String[][] board;
  private List<Square> takenSquares;

  public Result(String[][] board, List<Square> takenSquares) {
    this.takenSquares = takenSquares;
    this.board = playComputerMove(board);
    if (isPlayerWinner()) {
      this.state = PLAYER_WINS;
    } else if (isComputerWinner()) {
      this.state = COMPUTER_WINS;
    } else if (isDraw()) {
      this.state = DRAW;
    } else {
      this.state = GAME_ON;
    }
  }

  private String[][] playComputerMove(String[][] board) {
    if (takenSquares.size() == 9) {
      return board;
    }
    while (true) {
      Random random = new Random();
      int x = random.nextInt(3);
      int y = random.nextInt(3);
      Square square = new Square(board[x][y], x, y);
      if (!takenSquares.contains(square)) {
        board[x][y] = "O";
        break;
      }
    }

    return board;
  }

  public String[][] board() {
    return this.board;
  }

  public State state() {
    return this.state;
  }

  private boolean isPlayerWinner() {
    return winningCombinations("X")
        .anyMatch(combination ->
            combination.allMatch(squaresTakenBy("X")::contains));
  }

  private boolean isComputerWinner() {
    return winningCombinations("O")
        .anyMatch(combination ->
            combination.allMatch(squaresTakenBy("O")::contains));
  }

  private Stream<Stream<Square>> winningCombinations(String player) {
    return Stream.of(
        Stream.of(new Square(player, 0, 0), new Square(player, 0, 1), new Square(player, 0, 2)),
        Stream.of(new Square(player, 1, 0), new Square(player, 1, 1), new Square(player, 1, 2)),
        Stream.of(new Square(player, 2, 0), new Square(player, 2, 1), new Square(player, 2, 2)),
        Stream.of(new Square(player, 0, 0), new Square(player, 1, 0), new Square(player, 2, 0)),
        Stream.of(new Square(player, 0, 1), new Square(player, 1, 1), new Square(player, 2, 1)),
        Stream.of(new Square(player, 0, 2), new Square(player, 1, 2), new Square(player, 2, 2)),
        Stream.of(new Square(player, 0, 0), new Square(player, 1, 1), new Square(player, 2, 2)),
        Stream.of(new Square(player, 0, 2), new Square(player, 1, 1), new Square(player, 2, 0))
    );
  }

  private Set<Square> squaresTakenBy(String player) {
    return takenSquares.stream()
        .filter(s -> s.player().equals(player))
        .collect(toSet());
  }

  private boolean isDraw() {
    for (String[] line : board) {
      for (String square : line) {
        if (square.isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }
}
