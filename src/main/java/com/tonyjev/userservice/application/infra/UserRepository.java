package com.tonyjev.userservice.application.infra;

import com.tonyjev.userservice.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
