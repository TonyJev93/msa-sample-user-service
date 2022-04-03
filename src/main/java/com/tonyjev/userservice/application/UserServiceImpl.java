package com.tonyjev.userservice.application;

import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.application.exception.UserNotFoundException;
import com.tonyjev.userservice.application.infra.UserRepository;
import com.tonyjev.userservice.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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

    @Override
    public UserDto getUser(String userId) {
        User user = userRepository.findByUserId(userId).orElseThrow(UserNotFoundException::new);

        UserDto userDto = UserDto.from(user);
        userDto.setOrders(Collections.EMPTY_LIST);

        return userDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        Iterable<User> allUsers = userRepository.findAll();

        return StreamSupport.stream(allUsers.spliterator(), false)
                .map(UserDto::from)
                .collect(Collectors.toList());
    }
}
