package com.github.gn5r.boot.layered.infrastructure.userDepartment.repository;

import java.util.Optional;

import com.github.gn5r.boot.layered.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;

public interface UserDepartmentJsonRepository {

  Optional<UserDepartmentJsonEntity> selectByUserId(Integer userId);

}
