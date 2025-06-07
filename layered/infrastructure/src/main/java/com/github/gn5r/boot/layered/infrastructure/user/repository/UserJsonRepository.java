package com.github.gn5r.boot.layered.infrastructure.user.repository;

import java.util.Optional;

import com.github.gn5r.boot.layered.infrastructure.user.entity.UserJsonEntity;

public interface UserJsonRepository {

  Optional<UserJsonEntity> selectById(Integer id);

}
