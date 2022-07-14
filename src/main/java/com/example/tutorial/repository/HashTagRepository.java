package com.example.tutorial.repository;

import com.example.tutorial.entity.HashTagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HashTagRepository extends JpaRepository<HashTagEntity, Long> {
}
