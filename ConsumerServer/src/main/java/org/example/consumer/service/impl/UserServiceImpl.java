package org.example.consumer.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.consumer.domain.UserDomain;
import org.example.consumer.repository.UserRepository;
import org.example.consumer.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserDomain saveUser(UserDomain user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<UserDomain> getUserById(Long id) {
        return userRepository.findById(id);
    }
}
