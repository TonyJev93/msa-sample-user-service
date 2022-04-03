package com.tonyjev.userservice.presentation;

import com.tonyjev.userservice.application.UserService;
import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.infra.encoder.PasswordEncoder;
import com.tonyjev.userservice.presentation.vo.RequestUser;
import com.tonyjev.userservice.presentation.vo.ResponseUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public ResponseEntity<List<ResponseUser>> getUsers() {
        List<UserDto> userAllDto = userService.getAllUser();

        List<ResponseUser> responseUsers = userAllDto.stream().map(ResponseUser::from).collect(Collectors.toList());

        return new ResponseEntity<>(responseUsers, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<ResponseUser> getUser(@PathVariable String userId) {
        UserDto userDto = userService.getUser(userId);
        return new ResponseEntity<>(ResponseUser.from(userDto), HttpStatus.CREATED);
    }
}
