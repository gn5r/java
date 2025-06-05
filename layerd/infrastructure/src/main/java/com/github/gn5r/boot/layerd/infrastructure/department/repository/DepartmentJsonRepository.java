package com.github.gn5r.boot.layerd.infrastructure.department.repository;

import com.github.gn5r.boot.layerd.infrastructure.department.entity.DepartmentJsonEntity;

public interface DepartmentJsonRepository {

  DepartmentJsonEntity selectById(Integer id);

}
