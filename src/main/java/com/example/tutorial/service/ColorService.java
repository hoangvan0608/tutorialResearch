package com.example.tutorial.service;

import com.example.tutorial.entity.ColorEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface ColorService  {

    void save(ColorEntity brand, RedirectAttributes model);

    void findAll(Integer page, Integer perPage, String searchKey, Model model);

    ColorEntity findOne(Long id);

    void deleteById(Long id, RedirectAttributes model);

    List<ColorEntity> findAll();
}
