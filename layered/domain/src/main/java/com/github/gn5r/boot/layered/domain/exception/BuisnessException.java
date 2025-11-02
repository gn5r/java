package com.github.gn5r.boot.layered.domain.exception;

public abstract class BuisnessException extends RuntimeException {

  public BuisnessException(String message) {
    super(message);
  }

  public BuisnessException(String message, Throwable cause) {
    super(message, cause);
  }
}
