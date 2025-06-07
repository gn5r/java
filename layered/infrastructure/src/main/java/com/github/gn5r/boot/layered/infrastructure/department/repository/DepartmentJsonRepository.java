package com.github.gn5r.boot.layered.infrastructure.department.repository;

import java.util.Optional;

import com.github.gn5r.boot.layered.infrastructure.department.entity.DepartmentJsonEntity;

public interface DepartmentJsonRepository {

  Optional<DepartmentJsonEntity> selectById(Integer id);

}
