package com.github.gn5r.boot.layered.infrastructure.department.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.gn5r.boot.layered.infrastructure.department.entity.DepartmentJsonEntity;
import com.github.gn5r.boot.layered.infrastructure.json.JsonFileLoader;

@Repository
public class DepartmentJsonRepositoryImpl implements DepartmentJsonRepository {

  @Value("classpath:departments.json")
  private Resource DEPARTMENT_JSON_FILE;

  @Override
  public Optional<DepartmentJsonEntity> selectById(Integer id) {
    List<DepartmentJsonEntity> departments = selectAll();
    Optional<DepartmentJsonEntity> department = departments.stream()
        .filter(d -> d.getId().equals(id))
        .findFirst();
    return department;
  }

  public List<DepartmentJsonEntity> selectAll() {
    return JsonFileLoader.loadListFromJson(DEPARTMENT_JSON_FILE, new TypeReference<List<DepartmentJsonEntity>>() {
    });
  }
}
