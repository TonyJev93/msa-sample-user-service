package com.tonyjev.userservice.application.dto;

import com.tonyjev.userservice.common.util.ModelMapperUtils;
import com.tonyjev.userservice.domain.User;
import lombok.Data;
import lombok.ToString;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.util.ObjectUtils;

import java.util.UUID;

@Data
@ToString
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private String createdAt;
    private String encryptedPassword;

    public static UserDto from(User createdUser) {
        return (UserDto) ModelMapperUtils.mapStrict(createdUser, UserDto.class);
    }

    public User toEntity() {
        return (User) ModelMapperUtils.mapStrict(this, User.class);
    }
}
