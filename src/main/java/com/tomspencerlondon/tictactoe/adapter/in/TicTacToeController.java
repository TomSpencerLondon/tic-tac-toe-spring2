package com.tomspencerlondon.tictactoe.adapter.in;

import org.springframework.web.bind.annotation.GetMapping;

public class TicTacToeController {

  @GetMapping("/")
  public String index() {
    return "index";
  }
}
