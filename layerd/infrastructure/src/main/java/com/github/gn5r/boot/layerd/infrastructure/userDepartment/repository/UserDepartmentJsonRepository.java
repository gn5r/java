package com.github.gn5r.boot.layerd.infrastructure.userDepartment.repository;

import java.util.Optional;

import com.github.gn5r.boot.layerd.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;

public interface UserDepartmentJsonRepository {

  Optional<UserDepartmentJsonEntity> selectByUserId(Integer userId);

}
