package com.github.gn5r.boot.layerd.infrastructure.department.repository;

import java.util.Optional;

import com.github.gn5r.boot.layerd.infrastructure.department.entity.DepartmentJsonEntity;

public interface DepartmentJsonRepository {

  Optional<DepartmentJsonEntity> selectById(Integer id);

}
