package com.tonyjev.userservice.presentation.vo;


import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.common.util.ModelMapperUtils;
import com.tonyjev.userservice.infra.encoder.PasswordEncoder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class RequestUser {
    @NotNull(message = "Email cannot be null")
    @Size(min = 2, message = "Email not be less than two characters")
    private String email;

    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    private String name;

    @NotNull(message = "Password cannot be null")
    @Size(min = 8, message = "Password must be equal or grater than 8 characters")
    private String password;

    public UserDto toDto(PasswordEncoder passwordEncoder) {
        UserDto userDto = (UserDto) ModelMapperUtils.map(this, UserDto.class);
        userDto.setEncryptedPassword(passwordEncoder.encode(this.password));

        return userDto;
    }
}
