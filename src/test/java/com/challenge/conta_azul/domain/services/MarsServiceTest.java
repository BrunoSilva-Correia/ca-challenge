package com.challenge.conta_azul.domain.services;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MarsServiceTest {

  private MarsService marsService;

  @Before
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

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidCommand() {
    marsService.executeCommands("AAA");
  }

  @Test(expected = IllegalArgumentException.class)
  public void testInvalidMovementOutsideGrid() {
    marsService.executeCommands("MMMMMMMMMM");
  }

}