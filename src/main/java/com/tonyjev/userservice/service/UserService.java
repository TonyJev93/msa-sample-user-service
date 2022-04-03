package com.tonyjev.userservice.service;

import com.tonyjev.userservice.dto.UserDto;

public interface UserService {
    UserDto createUser(UserDto userDto);
}
