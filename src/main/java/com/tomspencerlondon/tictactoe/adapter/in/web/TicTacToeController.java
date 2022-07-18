package com.tomspencerlondon.tictactoe.adapter.in.web;

import com.tomspencerlondon.tictactoe.hexagon.application.GameService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TicTacToeController {

  private final GameService gameService;

  public TicTacToeController(GameService gameService) {
    this.gameService = gameService;
  }

  @GetMapping("/")
  public String index(Model model) {
    model.addAttribute("board", gameService.getBoard());
    model.addAttribute("state", gameService.getCurrentState());
    return "index";
  }
}
