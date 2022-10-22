package org.example.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.repository.UserRepository;
import org.example.consumer.service.UserService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;

    @Override
    public UserDomain saveUser(UserDomain user) {
        return repository.save(user);
    }
}
