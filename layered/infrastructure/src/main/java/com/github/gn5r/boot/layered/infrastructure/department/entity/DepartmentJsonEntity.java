package com.github.gn5r.boot.layered.infrastructure.department.entity;

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
public class DepartmentJsonEntity {

  private Integer id;
  private String name;
}
