package com.tonyjev.userservice.application.infra;

import com.tonyjev.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUserId(String userId);
}
