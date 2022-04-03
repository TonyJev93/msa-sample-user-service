package com.tonyjev.userservice.dto;

import com.tonyjev.userservice.common.ModelMapperUtils;
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
    private String encryptedPwd;

    public static UserDto from(User createdUser) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return mapper.map(createdUser, UserDto.class);
    }

    public void generateUserId() {
        if (ObjectUtils.isEmpty(userId)) {
            this.userId = UUID.randomUUID().toString();
        }
    }

    public User toEntity() {
        return (User) ModelMapperUtils.mapStrict(this, User.class);
    }
}
