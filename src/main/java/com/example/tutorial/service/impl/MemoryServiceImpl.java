package com.example.tutorial.service.impl;

import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.repository.MemoryRepository;
import com.example.tutorial.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemoryServiceImpl implements MemoryService {
    @Autowired
    private MemoryRepository memoryRepository;
    @Override
    public List<MemoryEntity> getAll() {
        return memoryRepository.findAll();
    }

    @Override
    public MemoryEntity getOne(Long id) {
        return null;
    }
}
