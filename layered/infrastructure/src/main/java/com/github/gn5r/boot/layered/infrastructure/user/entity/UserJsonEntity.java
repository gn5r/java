package com.github.gn5r.boot.layered.infrastructure.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserJsonEntity {

  private Integer id;
  private String name;
  private String email;

}
