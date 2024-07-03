package com.challenge.conta_azul.domain.entities;

import com.challenge.conta_azul.domain.enums.DirectionEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@AllArgsConstructor
@Getter
@EqualsAndHashCode
public class PositionEntity {

  private int positionX;
  private int positionY;
  private DirectionEnum direction;

  public void setDirection(DirectionEnum direction) {
    this.direction = direction;
  }

  public void incrementPositionY() {
    positionY++;
  }

  public void decrementPositionY() {
    positionY--;
  }

  public void incrementPositionX() {
    positionX++;
  }

  public void decrementPositionX() {
    positionX--;
  }

  @Override
  public String toString() {
    return "(" + positionX + ", " + positionY + ", " + direction + ")";
  }

}
