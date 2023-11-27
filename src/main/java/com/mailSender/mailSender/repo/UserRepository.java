package com.mailSender.mailSender.repo;

import com.mailSender.mailSender.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmailIgnoreCase(String email);
    Boolean existsByEmail(String email);
}
