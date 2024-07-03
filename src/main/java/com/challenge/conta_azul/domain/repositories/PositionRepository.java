package com.challenge.conta_azul.domain.repositories;

import com.challenge.conta_azul.domain.entities.PositionEntity;
import com.challenge.conta_azul.domain.enums.DirectionEnum;
import com.challenge.conta_azul.domain.exceptions.InvalidCommandException;

public class PositionRepository {

  public PositionEntity position;

  public PositionRepository() {
    this.position = new PositionEntity(0, 0, DirectionEnum.N);
  }

  public PositionRepository(int positionX, int positionY, DirectionEnum direction) {
    this.position = new PositionEntity(positionX, positionY, direction);
  }

  public void move() {
    switch (position.getDirection()) {
      case N:
        position.incrementPositionY();
        break;
      case E:
        position.incrementPositionX();
        break;
      case S:
        position.decrementPositionY();
        break;
      case W:
        position.decrementPositionX();
        break;
      default:
        throw new InvalidCommandException();
    }
  }

  public void turnLeft() {
    switch (position.getDirection()) {
      case N:
        position.setDirection(DirectionEnum.W);
        break;
      case E:
        position.setDirection(DirectionEnum.N);
        break;
      case S:
        position.setDirection(DirectionEnum.E);
        break;
      case W:
        position.setDirection(DirectionEnum.S);
        break;
      default:
        throw new InvalidCommandException();
    }
  }

  public void turnRight() {
    switch (position.getDirection()) {
      case W:
        position.setDirection(DirectionEnum.N);
        break;
      case N:
        position.setDirection(DirectionEnum.E);
        break;
      case E:
        position.setDirection(DirectionEnum.S);
        break;
      case S:
        position.setDirection(DirectionEnum.W);
        break;
      default:
        throw new InvalidCommandException();
    }
  }

}
