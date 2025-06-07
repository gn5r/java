package com.github.gn5r.boot.layered.infrastructure.user.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.gn5r.boot.layered.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layered.domain.user.repository.UserRepository;
import com.github.gn5r.boot.layered.infrastructure.department.entity.DepartmentJsonEntity;
import com.github.gn5r.boot.layered.infrastructure.department.repository.DepartmentJsonRepository;
import com.github.gn5r.boot.layered.infrastructure.user.entity.UserJsonEntity;
import com.github.gn5r.boot.layered.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;
import com.github.gn5r.boot.layered.infrastructure.userDepartment.repository.UserDepartmentJsonRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJsonRepository userJsonRepository;
  private final UserDepartmentJsonRepository userDepartmentJsonRepository;
  private final DepartmentJsonRepository departmentJsonRepository;

  @Override
  public Optional<UserEntity> findById(Integer id) {
    return userJsonRepository.selectById(id)
        .map(userJsonEntity -> {
          Optional<UserDepartmentJsonEntity> userDeptOpt = userDepartmentJsonRepository.selectByUserId(id);

          String departmentName = userDeptOpt
              .flatMap(dept -> departmentJsonRepository.selectById(dept.getDepartmentId()))
              .map(DepartmentJsonEntity::getName)
              .orElse(null);

          return toUserEntity(userJsonEntity, departmentName);
        });
  }

  private UserEntity toUserEntity(UserJsonEntity userJsonEntity, String departmentName) {
    return UserEntity.builder()
        .id(userJsonEntity.getId())
        .name(userJsonEntity.getName())
        .email(userJsonEntity.getEmail())
        .department(departmentName)
        .build();
  }

}
