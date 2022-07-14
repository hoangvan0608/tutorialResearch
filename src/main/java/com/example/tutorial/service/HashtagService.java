package com.example.tutorial.service;

import com.example.tutorial.entity.HashTagEntity;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

public interface HashtagService {
    void save(HashTagEntity brand, RedirectAttributes model);

    void findAll(Integer page, Integer perPage, String searchKey, Model model);

    HashTagEntity findOne(Long id);

    void deleteById(Long id, RedirectAttributes model);
}
