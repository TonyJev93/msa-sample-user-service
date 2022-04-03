package com.tonyjev.userservice.presentation;

import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.application.UserService;
import com.tonyjev.userservice.infra.encoder.PasswordEncoder;
import com.tonyjev.userservice.presentation.vo.RequestUser;
import com.tonyjev.userservice.presentation.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResponseUser> createUser(@Valid @RequestBody RequestUser requestUser) {
        UserDto userDto = userService.createUser(requestUser.toDto(passwordEncoder));
        return new ResponseEntity<>(ResponseUser.from(userDto), HttpStatus.CREATED);
    }
}
