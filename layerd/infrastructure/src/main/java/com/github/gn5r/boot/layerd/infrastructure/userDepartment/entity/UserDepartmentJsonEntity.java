package com.github.gn5r.boot.layerd.infrastructure.userDepartment.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDepartmentJsonEntity {

  private Integer userId;
  private Integer departmentId;
}
