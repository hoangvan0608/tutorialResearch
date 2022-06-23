package com.example.tutorial.repository;

import com.example.tutorial.entity.CategoryEntity;
import com.example.tutorial.entity.MemoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemoryRepository extends JpaRepository<MemoryEntity, Long> {
}
