package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.github.gn5r.boot.layerd.infrastructure.json.JsonFileLoader;
import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;

@Repository
public class UserJsonRepositoryImpl implements UserJsonRepository {

  private static final String USER_JSON_FILE = "users.json";

  @Override
  public Optional<UserJsonEntity> selectById(Integer id) {
    List<UserJsonEntity> users = selectAll();
    Optional<UserJsonEntity> user = users.stream()
        .filter(u -> u.getId().equals(id))
        .findFirst();
    return user;
  }

  public List<UserJsonEntity> selectAll() {
    return JsonFileLoader.loadListFromJson(USER_JSON_FILE, new TypeReference<List<UserJsonEntity>>() {
    });
  }

}
