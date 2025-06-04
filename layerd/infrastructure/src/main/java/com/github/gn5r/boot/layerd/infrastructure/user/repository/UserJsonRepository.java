package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;

public interface UserJsonRepository {

  UserJsonEntity selectById(Integer id);

}
