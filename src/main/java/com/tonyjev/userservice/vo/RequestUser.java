package com.tonyjev.userservice.vo;


import com.tonyjev.userservice.common.ModelMapperUtils;
import com.tonyjev.userservice.dto.UserDto;
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
    private String pwd;

    public UserDto toDto() {
        return (UserDto) ModelMapperUtils.mapStrict(this, UserDto.class);
    }
}
