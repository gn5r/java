package com.github.gn5r.boot.layered.application.usecase.user.impl;

import org.springframework.stereotype.Service;

import com.github.gn5r.boot.layered.application.usecase.user.GetUserUseCase;
import com.github.gn5r.boot.layered.application.usecase.user.dto.UserDto;
import com.github.gn5r.boot.layered.domain.exception.user.UserNotFoundException;
import com.github.gn5r.boot.layered.domain.user.entity.UserEntity;
import com.github.gn5r.boot.layered.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GetUserUseCaseImpl implements GetUserUseCase {

  private final UserRepository userRepository;

  @Override
  public UserDto getUserById(Integer id) {
    UserEntity userEntity = userRepository.findById(id)
        .orElseThrow(() -> new UserNotFoundException("ID:" + id + " のユーザーが見つかりません。"));
    return this.convertUserEntityToUserDto(userEntity);
  }

  public UserDto convertUserEntityToUserDto(UserEntity userEntity) {
    return UserDto.builder()
        .id(userEntity.getId())
        .name(userEntity.getName())
        .email(userEntity.getEmail())
        .department(userEntity.getDepartment())
        .build();
  }

}
