package com.github.gn5r.boot.layered.application.usecase.user.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDto {

  private Integer id;
  private String name;
  private String email;
  private String department;

}
