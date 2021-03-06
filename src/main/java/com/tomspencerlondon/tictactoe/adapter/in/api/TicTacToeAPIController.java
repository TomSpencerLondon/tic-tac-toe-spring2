package com.tomspencerlondon.tictactoe.adapter.in.api;

import com.tomspencerlondon.tictactoe.hexagon.application.GameService;
import com.tomspencerlondon.tictactoe.hexagon.domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeAPIController {
  private final GameService service;

  @Autowired
  public TicTacToeAPIController(GameService service) {
    this.service = service;
  }

  @PostMapping("/api/add-square")
  @ResponseStatus(HttpStatus.CREATED)
  public ResultDto addSquare(@RequestBody CreateSquareParameters parameters) {
    Result board = service.createBoard(parameters.getBoard());
    return ResultDto.from(board);
  }
}
