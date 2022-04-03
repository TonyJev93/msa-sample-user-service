package com.tonyjev.userservice.controller;

import com.tonyjev.userservice.dto.UserDto;
import com.tonyjev.userservice.service.UserService;
import com.tonyjev.userservice.vo.RequestUser;
import com.tonyjev.userservice.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseUser> createUser(@RequestBody RequestUser request) {
        UserDto userDto = userService.createUser(request.toDto());
        return new ResponseEntity<>(ResponseUser.from(userDto), HttpStatus.CREATED);
    }
}
