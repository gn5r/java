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
    Optional<UserJsonEntity> userJsonEntityOptional = userJsonRepository.selectById(id);
    if (userJsonEntityOptional.isPresent()) {
      UserJsonEntity userJsonEntity = userJsonEntityOptional.get();
      Optional<UserDepartmentJsonEntity> userDepartmentJsonEntityOptional = userDepartmentJsonRepository
          .selectByUserId(id);
      DepartmentJsonEntity departmentJsonEntity = null;

      if (userDepartmentJsonEntityOptional.isPresent()) {
        UserDepartmentJsonEntity userDepartmentJsonEntity = userDepartmentJsonEntityOptional.get();
        departmentJsonEntity = departmentJsonRepository.selectById(userDepartmentJsonEntity.getDepartmentId())
            .orElse(null);
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
