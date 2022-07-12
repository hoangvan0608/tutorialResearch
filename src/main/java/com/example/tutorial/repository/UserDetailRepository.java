package com.example.tutorial.repository;

import com.example.tutorial.entity.UserDetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailEntity, Long> {
    void deleteAllByUserId(Long id);
    UserDetailEntity findFirstByUserId(Long id);
}
