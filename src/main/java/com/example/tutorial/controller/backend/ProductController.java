package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.service.CategoryService;
import com.example.tutorial.service.ColorService;
import com.example.tutorial.service.MemoryService;
import com.example.tutorial.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("detail/{id}")
    public String updatePage(@PathVariable Long id, Model model) {
        ProductDTO productDTO = productService.findOneById(id);
        model.addAttribute("product", productDTO);
        return "/backend/product/saveOrEdit";
    }

    @DeleteMapping("delete/{id}")
    public void deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id, redirectAttributes);
    }

    @PostMapping("save")
    public String saveProduct(ProductDTO productRequest, RedirectAttributes model) {
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
