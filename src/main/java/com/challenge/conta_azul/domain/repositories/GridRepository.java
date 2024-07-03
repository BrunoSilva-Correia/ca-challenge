package com.challenge.conta_azul.domain.repositories;

import com.challenge.conta_azul.domain.entities.GridEntity;

public class GridRepository {

  private GridEntity grid;

  public GridRepository(int length, int height) {
    this.grid = new GridEntity(length, height);
  }

  public boolean isValidMovement(int positionX, int positionY) {
    return positionX >= 0 && positionX <= grid.getLength() &&
        positionY >= 0 && positionY <= grid.getHeight();
  }

}
