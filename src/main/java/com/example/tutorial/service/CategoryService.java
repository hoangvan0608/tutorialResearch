package com.example.tutorial.service;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.entity.CategoryEntity;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface CategoryService {
    void save(CategoryDTO categoryRequest, RedirectAttributes model);
    

    List<CategoryDTO> findAll();

    CategoryDTO findOne(Long id);

    void deleteById(Long id, RedirectAttributes model);
}
