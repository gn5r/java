package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.github.gn5r.boot.layerd.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layerd.domain.user.repository.UserRepository;
import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

  private final UserJsonRepository userJsonRepository;

  @Override
  public Optional<UserEntity> findById(Integer id) {
    UserJsonEntity userJsonEntity = userJsonRepository.selectById(id);
    if (userJsonEntity != null) {
      return Optional.of(UserEntity.builder()
          .id(userJsonEntity.getId())
          .name(userJsonEntity.getName())
          .email(userJsonEntity.getEmail())
          .build());
    }
    return Optional.empty();
  }

}
