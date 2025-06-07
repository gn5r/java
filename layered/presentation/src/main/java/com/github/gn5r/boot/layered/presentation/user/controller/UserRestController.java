package com.github.gn5r.boot.layered.presentation.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.gn5r.boot.layered.application.usecase.user.GetUserUseCase;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserRestController {

  private final GetUserUseCase getUserUseCase;

  @GetMapping("/{id}")
  public ResponseEntity<?> getUserById(@PathVariable("id") Integer id) {
    return ResponseEntity.ok(getUserUseCase.getUserById(id));
  }

}
