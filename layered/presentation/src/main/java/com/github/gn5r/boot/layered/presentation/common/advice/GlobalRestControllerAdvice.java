package com.github.gn5r.boot.layered.presentation.common.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.github.gn5r.boot.layered.domain.exception.user.UserNotFoundException;
import com.github.gn5r.boot.layered.presentation.common.model.response.ErrorResponse;

@RestControllerAdvice
public class GlobalRestControllerAdvice {

  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ErrorResponse> handleApplicationException(UserNotFoundException e) {
    ErrorResponse response = ErrorResponse.builder()
        .message(e.getMessage())
        .build();
    return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
  }
}
