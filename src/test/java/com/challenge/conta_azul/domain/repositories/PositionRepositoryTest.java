package com.challenge.conta_azul.domain.repositories;

import com.challenge.conta_azul.domain.entities.PositionEntity;
import com.challenge.conta_azul.domain.enums.DirectionEnum;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PositionRepositoryTest {

  private PositionRepository positionRepository;

  @Before
  public void setUp() {
    positionRepository = new PositionRepository();
  }

  @Test
  public void testInitialPosition() {
    PositionEntity initialPosition = new PositionEntity(0, 0, DirectionEnum.N);
    assertEquals(initialPosition, positionRepository.position);
  }

  @Test
  public void testMoveNorth() {
    positionRepository.move();
    PositionEntity expected = new PositionEntity(0, 1, DirectionEnum.N);
    assertEquals(expected, positionRepository.position);
  }

  @Test
  public void testMoveWest() {
    positionRepository.turnLeft();
    positionRepository.move();
    PositionEntity expected = new PositionEntity(-1, 0, DirectionEnum.W);
    assertEquals(expected, positionRepository.position);
  }

  @Test
  public void testTurnLeftFromNorth() {
    positionRepository.turnLeft();
    assertEquals(DirectionEnum.W, positionRepository.position.getDirection());
  }

  @Test
  public void testTurnRightFromEast() {
    positionRepository.turnRight();
    assertEquals(DirectionEnum.E, positionRepository.position.getDirection());
  }
}
