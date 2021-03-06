package com.example.tutorial.repository;

import com.example.tutorial.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByEmail(String email);

    UserEntity findUserEntityByCode(String code);

    Boolean existsByEmail(String email);
}
