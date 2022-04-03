package com.tonyjev.userservice.repository;

import com.tonyjev.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
