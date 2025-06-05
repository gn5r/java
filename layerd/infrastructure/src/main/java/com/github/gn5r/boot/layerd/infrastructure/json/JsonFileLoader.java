package com.github.gn5r.boot.layerd.infrastructure.json;

import java.io.IOException;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonFileLoader {

  public static <T> List<T> loadListFromJson(String filepath, TypeReference<List<T>> typeRef) {
    Resource resource = new ClassPathResource(filepath);
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(resource.getInputStream(), typeRef);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read from JSON file", e);
    }
  }
}
