package org.example.consumer.service;

import org.example.consumer.domain.UserDomain;

public interface UserService {
    UserDomain saveUser(UserDomain user);
}
