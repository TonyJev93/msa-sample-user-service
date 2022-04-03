package com.tonyjev.userservice.presentation.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.tonyjev.userservice.application.dto.UserDto;
import com.tonyjev.userservice.common.util.ModelMapperUtils;
import lombok.Getter;

import java.util.List;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // Json 값이 없는 경우 무시
public class ResponseUser {

    private String email;
    private String name;
    private String userId;

    private List<ResponseOrder> orders;

    public static ResponseUser from(UserDto userDto) {
        return (ResponseUser) ModelMapperUtils.map(userDto, ResponseUser.class);
    }
}
