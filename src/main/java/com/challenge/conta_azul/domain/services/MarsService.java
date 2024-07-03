package com.challenge.conta_azul.domain.services;

import com.challenge.conta_azul.domain.exceptions.InvalidCommandException;
import com.challenge.conta_azul.domain.exceptions.InvalidMovementException;
import com.challenge.conta_azul.domain.repositories.GridRepository;
import com.challenge.conta_azul.domain.repositories.PositionRepository;

public class MarsService {

  private static final Integer GRID_LENGTH = 5;
  private static final Integer GRID_HEIGHT = 5;
  private PositionRepository positionRepository;
  private GridRepository gridRepository;

  public MarsService() {
    this.positionRepository = new PositionRepository();
    this.gridRepository = new GridRepository(GRID_LENGTH, GRID_HEIGHT);
  }

  public String executeCommands(String commands) {
    for (char command : commands.toCharArray()) {
      switch (command) {
        case 'L':
          positionRepository.turnLeft();
          break;
        case 'R':
          positionRepository.turnRight();
          break;
        case 'M':
          move();
          break;
        default:
          throw new InvalidCommandException();
      }
    }
    return positionRepository.position.toString();
  }

  private void move() {
    PositionRepository newPosition = new PositionRepository(positionRepository.position.getPositionX(),
        positionRepository.position.getPositionY(), positionRepository.position.getDirection());

    newPosition.move();

    Boolean isValidMovement = gridRepository.isValidMovement(newPosition.position.getPositionX(),
        newPosition.position.getPositionY());

    if (!isValidMovement) {
      throw new InvalidMovementException();
    }
    positionRepository.move();
  }
}
