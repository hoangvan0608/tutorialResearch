package com.example.tutorial.controller.frontend;

import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeFController {
    @Autowired
    private ProductService productService;
    @GetMapping({"","/home","/"})
    public String homePage(Model model) {
        List<ProductDTO> products = productService.getAll();
        model.addAttribute("products", products);
        return "frontend/homePage";
    }
}
