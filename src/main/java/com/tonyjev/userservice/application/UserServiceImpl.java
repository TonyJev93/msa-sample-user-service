package com.tonyjev.userservice.application;

import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.application.infra.UserRepository;
import com.tonyjev.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        User user = userDto.toEntity();

        user.init();

        User createdUser = userRepository.save(user);

        return UserDto.from(createdUser);
    }
}
