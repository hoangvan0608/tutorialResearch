package com.example.tutorial.service.impl;

import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.repository.ColorRepository;
import com.example.tutorial.service.ColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ColorServiceImpl implements ColorService {
    @Autowired
    private ColorRepository colorRepository;
    @Override
    public List<ColorEntity> getAll() {
        return colorRepository.findAll();
    }

    @Override
    public ColorEntity getOne(Long id) {
        return colorRepository.findById(id).get();
    }
}
