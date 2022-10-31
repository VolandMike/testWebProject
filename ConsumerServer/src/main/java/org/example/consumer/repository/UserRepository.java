package org.example.consumer.repository;

import org.example.consumer.domain.UserDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, Long> {
    Optional<UserDomain> getUserDomainByUsername(String userName);
}
