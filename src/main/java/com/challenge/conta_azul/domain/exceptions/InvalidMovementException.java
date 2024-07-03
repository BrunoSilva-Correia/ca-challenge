package com.challenge.conta_azul.domain.exceptions;

public class InvalidMovementException extends IllegalArgumentException {

  public InvalidMovementException() {
    super("Invalid movement");
  }

  public InvalidMovementException(String message) {
    super(message);
  }

}
