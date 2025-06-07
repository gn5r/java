package com.github.gn5r.boot.layered.application.usecase.user;

import com.github.gn5r.boot.layered.application.usecase.user.dto.UserDto;

public interface GetUserUseCase {

  /**
   * Retrieves a user by their ID.
   *
   * @param id the ID of the user to retrieve
   * @return a UserDto containing user details, or null if not found
   */
  UserDto getUserById(Integer id);

}
