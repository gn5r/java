package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import java.util.Optional;

import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;

public interface UserJsonRepository {

  Optional<UserJsonEntity> selectById(Integer id);

}
