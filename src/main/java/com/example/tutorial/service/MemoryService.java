package com.example.tutorial.service;

import com.example.tutorial.entity.MemoryEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface MemoryService {
    void save(MemoryEntity entity, RedirectAttributes model);

    void findAll(Integer page, Integer perPage, String searchKey, Model model);

    MemoryEntity findOne(Long id);

    void deleteById(Long id, RedirectAttributes model);

    List<MemoryEntity> findAll();
}
