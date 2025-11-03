package com.github.gn5r.boot.layered.infrastructure.json;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileLoader {

  public static <T> List<T> loadListFromJson(Resource resource, TypeReference<List<T>> typeRef) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(resource.getInputStream(), typeRef);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read from JSON file", e);
    }
  }
}
