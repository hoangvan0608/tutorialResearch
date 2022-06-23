package com.example.tutorial.service;

import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.ProductEntity;
import com.example.tutorial.payload.request.NewProductRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface ProductService {
    List<ProductDTO> getAll();

    void save(NewProductRequest productRequest, RedirectAttributes model);
}
