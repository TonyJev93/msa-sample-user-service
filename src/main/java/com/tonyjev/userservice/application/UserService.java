package com.tonyjev.userservice.application;

import com.tonyjev.userservice.application.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);

    UserDto getUser(String userId);

    List<UserDto> getAllUser();
}
