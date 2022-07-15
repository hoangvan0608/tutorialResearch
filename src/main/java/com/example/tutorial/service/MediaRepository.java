package com.example.tutorial.service;

import com.example.tutorial.entity.MediaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MediaRepository extends JpaRepository<MediaEntity, Long> {
    List<MediaEntity> findAllByProductId(Long id);
    void deleteAllByProductId(Long productId);
}
