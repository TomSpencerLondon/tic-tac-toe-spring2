package com.tomspencerlondon.tictactoe;

import com.tomspencerlondon.tictactoe.hexagon.application.GameService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GameConfiguration {

  @Bean
  public GameService gameService() {
    return new GameService();
  }
}
