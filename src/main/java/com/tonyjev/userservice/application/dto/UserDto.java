package com.tonyjev.userservice.application.dto;

import com.tonyjev.userservice.common.util.ModelMapperUtils;
import com.tonyjev.userservice.domain.User;
import com.tonyjev.userservice.presentation.vo.ResponseOrder;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {
    private String email;
    private String name;
    private String pwd;
    private String userId;
    private String createdAt;
    private String encryptedPassword;

    private List<ResponseOrder> orders;

    public static UserDto from(User createdUser) {
        return (UserDto) ModelMapperUtils.map(createdUser, UserDto.class);
    }

    public User toEntity() {
        return (User) ModelMapperUtils.map(this, User.class);
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public void setOrders(List<ResponseOrder> orders) {
        this.orders = orders;
    }
}
