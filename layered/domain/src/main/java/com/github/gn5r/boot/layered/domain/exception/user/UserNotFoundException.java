package com.github.gn5r.boot.layered.domain.exception.user;

import com.github.gn5r.boot.layered.domain.exception.BuisnessException;

public class UserNotFoundException extends BuisnessException {

  public UserNotFoundException(String message) {
    super(message);
  }

  public UserNotFoundException(String message, Throwable cause) {
    super(message, cause);
  }
}
