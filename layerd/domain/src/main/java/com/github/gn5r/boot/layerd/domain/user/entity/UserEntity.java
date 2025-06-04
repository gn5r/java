package com.github.gn5r.boot.layerd.domain.user.entity;

import lombok.Builder;
import lombok.Data;

/**
 * Represents a user entity in the domain layer.
 * This class is a placeholder for user-related data and behavior.
 * It can be extended with fields and methods as needed.
 * Currently, it does not contain any fields or methods.
 * Future enhancements may include user attributes, validation, and business
 * logic.
 */
@Data
@Builder
public class UserEntity {

  private Integer id;
  private String name;
  private String email;

}
