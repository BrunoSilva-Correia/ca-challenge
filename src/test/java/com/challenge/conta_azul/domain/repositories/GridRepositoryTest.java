package com.challenge.conta_azul.domain.repositories;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GridRepositoryTest {

  private GridRepository gridRepository;

  @BeforeEach
  public void setUp() {
    gridRepository = new GridRepository(5, 5);
  }

  @Test
  public void testValidMovementInsideGrid() {
    assertTrue(gridRepository.isValidMovement(3, 3));
  }

  @Test
  public void testInvalidMovementOutsideGrid() {
    assertFalse(gridRepository.isValidMovement(6, 5));
  }

  @Test
  public void testEdgeCaseMovementOnGrid() {
    assertTrue(gridRepository.isValidMovement(0, 0));
    assertTrue(gridRepository.isValidMovement(5, 5));
    assertFalse(gridRepository.isValidMovement(-1, 2));
  }
}
