package com.tonyjev.userservice.infra.encoder;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class PasswordEncoderImpl implements PasswordEncoder {
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public String encode(String password) {
        return passwordEncoder.encode(password);
    }
}
