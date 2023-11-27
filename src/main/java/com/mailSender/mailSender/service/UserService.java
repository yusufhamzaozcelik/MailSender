package com.mailSender.mailSender.service;

import com.mailSender.mailSender.model.User;

public interface UserService {

    User saveUser(User user);

    Boolean verifyToken(String token);
}
