package com.github.gn5r.boot.layered.application.usecase.user.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.gn5r.boot.layered.application.usecase.user.GetUserUseCase;
import com.github.gn5r.boot.layered.application.usecase.user.dto.UserDto;
import com.github.gn5r.boot.layered.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layered.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

  private final UserRepository userRepository;

  @Override
  public UserDto getUserById(Integer id) {
    Optional<UserEntity> userEntityOptional = userRepository.findById(id);
    return this.convertUserEntityToUserDto(userEntityOptional.orElse(null));
  }

  public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
    if (userEntity == null) {
      return null;
    }
    return UserDto.builder()
        .id(userEntity.getId())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .department(userEntity.getDepartment())
        .build();
  }

}
