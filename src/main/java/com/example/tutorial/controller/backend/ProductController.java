package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.entity.CategoryEntity;
import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.payload.request.NewProductRequest;
import com.example.tutorial.service.CategoryService;
import com.example.tutorial.service.ColorService;
import com.example.tutorial.service.MemoryService;
import com.example.tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/backend/product/")
public class ProductController {

    @Autowired
    private MemoryService memoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("create")
    public String createProductPage() {
        return "backend/product/saveOrEdit";
    }

    @PostMapping("save")
    public String saveProduct(NewProductRequest productRequest, RedirectAttributes model) {
        productService.save(productRequest, model);
        return "redirect:/backend/product/create";
    }

    @ModelAttribute(name = "categories")
    public List<CategoryDTO> categoryEntities() {
        return categoryService.findAll();
    }

    @ModelAttribute(name = "colors")
    public List<ColorEntity> colorEntities() {
        return colorService.getAll();
    }

    @ModelAttribute(name = "memories")
    private List<MemoryEntity> memoryEntities() {
        return memoryService.getAll();
    }


}
