package com.challenge.conta_azul.domain.exceptions;

public class InvalidCommandException extends IllegalArgumentException {

  public InvalidCommandException() {
    super("Invalid command");
  }

  public InvalidCommandException(String message) {
    super(message);
  }

}
