package com.github.gn5r.boot.layerd.infrastructure.userDepartment.repository;

import com.github.gn5r.boot.layerd.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;

public interface UserDepartmentJsonRepository {

  UserDepartmentJsonEntity selectByUserId(Integer userId);

}
