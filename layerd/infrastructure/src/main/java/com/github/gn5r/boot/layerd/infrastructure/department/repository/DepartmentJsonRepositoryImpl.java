package com.github.gn5r.boot.layerd.infrastructure.department.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.gn5r.boot.layerd.infrastructure.department.entity.DepartmentJsonEntity;
import com.github.gn5r.boot.layerd.infrastructure.json.JsonFileLoader;

@Repository
public class DepartmentJsonRepositoryImpl implements DepartmentJsonRepository {

  private static final String DEPARTMENT_JSON_FILE = "departments.json";

  @Override
  public DepartmentJsonEntity selectById(Integer id) {
    List<DepartmentJsonEntity> departments = selectAll();
    Optional<DepartmentJsonEntity> department = departments.stream()
        .filter(d -> d.getId().equals(id))
        .findFirst();
    return department.orElse(null);
  }

  public List<DepartmentJsonEntity> selectAll() {
    return JsonFileLoader.loadListFromJson(DEPARTMENT_JSON_FILE, new TypeReference<List<DepartmentJsonEntity>>() {
    });
  }
}
