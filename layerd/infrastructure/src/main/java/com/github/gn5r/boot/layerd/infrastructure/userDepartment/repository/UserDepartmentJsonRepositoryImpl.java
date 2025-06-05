package com.github.gn5r.boot.layerd.infrastructure.userDepartment.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.gn5r.boot.layerd.infrastructure.json.JsonFileLoader;
import com.github.gn5r.boot.layerd.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;

@Repository
public class UserDepartmentJsonRepositoryImpl implements UserDepartmentJsonRepository {

  private static final String USER_DEPARTMENT_JSON_FILE = "user_departments.json";

  @Override
  public Optional<UserDepartmentJsonEntity> selectByUserId(Integer userId) {
    List<UserDepartmentJsonEntity> userDepartments = selectAll();
    Optional<UserDepartmentJsonEntity> userDepartment = userDepartments.stream()
        .filter(ud -> ud.getUserId().equals(userId))
        .findFirst();
    return userDepartment;
  }

  public List<UserDepartmentJsonEntity> selectAll() {
    return JsonFileLoader.loadListFromJson(USER_DEPARTMENT_JSON_FILE,
        new TypeReference<List<UserDepartmentJsonEntity>>() {
        });
  }
}
