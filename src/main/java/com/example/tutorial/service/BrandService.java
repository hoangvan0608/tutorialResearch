package com.example.tutorial.service;

import com.example.tutorial.entity.BrandEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface BrandService {
    void save(BrandEntity brand, RedirectAttributes model);

    void findAll(Integer page, Integer perPage, String searchKey, Model model);

    BrandEntity findOne(Long id);

    void deleteById(Long id, RedirectAttributes model);

    List<BrandEntity> findAll();
}
