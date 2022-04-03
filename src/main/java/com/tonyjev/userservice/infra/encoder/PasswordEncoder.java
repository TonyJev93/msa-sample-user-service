package com.tonyjev.userservice.infra.encoder;

public interface PasswordEncoder {
    String encode(String password);
}
