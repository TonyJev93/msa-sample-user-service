package com.tonyjev.userservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String email;

    @Column(nullable = false, length = 50)
    private String name;

    @Column(nullable = false, length = 50, unique = true)
    private String userId;

    @Column(nullable = false, length = 50, unique = true)
    private String encryptedPwd;

    public void init() {
        if (id == null) {
            this.generateUserId();
        }
        
        this.encryptPwd();
    }

    private void generateUserId() {
        this.userId = UUID.randomUUID().toString();
    }

    private void encryptPwd() {
        this.encryptedPwd = "Encrypted Password";
    }
}
