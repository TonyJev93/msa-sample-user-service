package com.tonyjev.userservice.vo;

import com.tonyjev.userservice.common.ModelMapperUtils;
import com.tonyjev.userservice.dto.UserDto;
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
