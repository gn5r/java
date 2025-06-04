package com.github.gn5r.boot.layerd.infrastructure.user.repository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.gn5r.boot.layerd.infrastructure.user.entity.UserJsonEntity;

@Repository
public class UserJsonRepositoryImpl implements UserJsonRepository {

  private static final String USER_JSON_FILE = "users.json";

  @Override
  public UserJsonEntity selectById(Integer id) {
    List<UserJsonEntity> users = selectAll();
    Optional<UserJsonEntity> user = users.stream()
        .filter(u -> u.getId().equals(id))
        .findFirst();
    return user.orElse(null);
  }

  public List<UserJsonEntity> selectAll() {
    Resource resource = new ClassPathResource(USER_JSON_FILE);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(resource.getInputStream(), new TypeReference<List<UserJsonEntity>>() {
      });
    } catch (IOException e) {
      throw new RuntimeException("Failed to read users from JSON file", e);
    }
  }

}
