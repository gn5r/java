package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.gn5r.boot.layerd.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layerd.domain.user.repository.UserRepository;
import com.github.gn5r.boot.layerd.infrastructure.department.entity.DepartmentJsonEntity;
import com.github.gn5r.boot.layerd.infrastructure.department.repository.DepartmentJsonRepository;
import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;
import com.github.gn5r.boot.layerd.infrastructure.userDepartment.entity.UserDepartmentJsonEntity;
import com.github.gn5r.boot.layerd.infrastructure.userDepartment.repository.UserDepartmentJsonRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJsonRepository userJsonRepository;
  private final UserDepartmentJsonRepository userDepartmentJsonRepository;
  private final DepartmentJsonRepository departmentJsonRepository;

  @Override
  public Optional<UserEntity> findById(Integer id) {
    UserJsonEntity userJsonEntity = userJsonRepository.selectById(id);
    if (userJsonEntity != null) {
      UserDepartmentJsonEntity userDepartmentJsonEntity = userDepartmentJsonRepository.selectByUserId(id);
      DepartmentJsonEntity departmentJsonEntity = null;

      if (userDepartmentJsonEntity != null) {
        departmentJsonEntity = departmentJsonRepository.selectById(userDepartmentJsonEntity.getDepartmentId());
      }

      return Optional.of(UserEntity.builder()
          .id(userJsonEntity.getId())
          .name(userJsonEntity.getName())
          .email(userJsonEntity.getEmail())
          .department(departmentJsonEntity != null ? departmentJsonEntity.getName() : null)
          .build());
    }
    return Optional.empty();
  }

}
