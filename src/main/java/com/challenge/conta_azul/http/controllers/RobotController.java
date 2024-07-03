package com.challenge.conta_azul.http.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.challenge.conta_azul.domain.services.MarsService;

@RestController
@RequestMapping("/rest")
public class RobotController {

  // private final MarsService marsService = new MarsService();

  @PostMapping("/mars/{commands}")
  public ResponseEntity<String> moveRobot(@PathVariable String commands) {
    try {
      MarsService marsService = new MarsService();
      String response = marsService.executeCommands(commands);
      return ResponseEntity.ok(response);
    } catch (IllegalArgumentException e) {
      return ResponseEntity.badRequest().body(e.getMessage());
    }
  }

}
