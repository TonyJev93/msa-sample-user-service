package com.tonyjev.userservice.application;

import com.tonyjev.userservice.application.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
