package com.github.gn5r.boot.layerd.domain.user.repository;

import java.util.Optional;

import com.github.gn5r.boot.layerd.domain.user.entity.UserEntity;

/**
 * Repository interface for managing user entities.
 * This interface defines methods for retrieving user data from the data source.
 * It is part of the domain layer and should be implemented by a concrete
 * repository class.
 */
public interface UserRepository {

  Optional<UserEntity> findById(Integer id);

}
