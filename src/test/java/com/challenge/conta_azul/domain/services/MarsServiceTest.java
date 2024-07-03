package com.challenge.conta_azul.domain.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MarsServiceTest {

  private MarsService marsService;

  @BeforeEach
  public void setUp() {
    marsService = new MarsService();
  }

  @Test
  public void testExecuteCommands() {
    String result = marsService.executeCommands("MMRMMRMM");
    assertEquals("(2, 0, S)", result);
  }

  @Test
  public void testExecuteCommandsWithTurns() {
    String result = marsService.executeCommands("MMLLMML");
    assertEquals("(0, 0, E)", result);
  }

  @Test
  public void testInvalidCommand() {
    assertThrows(IllegalArgumentException.class, () -> {
      marsService.executeCommands("AAA");
    });
  }

  @Test
  public void testInvalidMovementOutsideGrid() {
    assertThrows(IllegalArgumentException.class, () -> {
      marsService.executeCommands("MMMMMMMMMM");
    });
  }

}