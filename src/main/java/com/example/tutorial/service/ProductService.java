package com.example.tutorial.service;

import com.example.tutorial.dto.ProductDTO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void save(ProductDTO productRequest, RedirectAttributes model);

    ProductDTO findOneById(Long id);

    void deleteById(Long id, RedirectAttributes model);

    void findAll(Integer page, Integer perPage, String searchKey, Model model);
}
