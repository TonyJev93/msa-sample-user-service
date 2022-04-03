package com.tonyjev.userservice.presentation.vo;

import com.tonyjev.userservice.common.util.ModelMapperUtils;
import com.tonyjev.userservice.application.dto.UserDto;
import lombok.Data;

@Data
public class ResponseUser {

    private String email;
    private String name;
    private String userId;

    public static ResponseUser from(UserDto userDto) {
        return (ResponseUser) ModelMapperUtils.mapStrict(userDto, ResponseUser.class);
    }
}
