package com.github.gn5r.boot.layerd.application.usecase.user.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.gn5r.boot.layerd.application.usecase.user.GetUserUseCase;
import com.github.gn5r.boot.layerd.application.usecase.user.dto.UserDto;
import com.github.gn5r.boot.layerd.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layerd.domain.user.repository.UserRepository;

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
        .build();
  }

}
