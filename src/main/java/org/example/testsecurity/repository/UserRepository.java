package org.example.testsecurity.repository;

import org.example.testsecurity.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existByUsername(String username);

    UserEntity findByUsername(String username);
}
