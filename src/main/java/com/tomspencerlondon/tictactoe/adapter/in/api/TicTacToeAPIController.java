package com.tomspencerlondon.tictactoe.adapter.in.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicTacToeAPIController {

  @PostMapping("/api/add-square")
  @ResponseStatus(HttpStatus.CREATED)
  public SquareDto addSquare(@RequestBody CreateSquareParameters parameters) {
    return SquareDto.from(parameters.getBoard());
  }
}
