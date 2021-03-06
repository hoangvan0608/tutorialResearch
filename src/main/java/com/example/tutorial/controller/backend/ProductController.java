package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.dto.ProductDTO;
import com.example.tutorial.entity.BrandEntity;
import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.service.*;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/backend/product/")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class ProductController {

    @Autowired
    private MemoryService memoryService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ColorService colorService;
    @Autowired
    private CategoryService categoryService;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("list")
    public String homeProduct(Model model,
                              @RequestParam(required = false) String searchKey,
                              @RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        productService.findAll(page, perPage, searchKey, model);
        return "/backend/product/list";
    }

    @ModelAttribute(name = "categories")
    public List<CategoryDTO> categoryEntities() {
        return categoryService.findAll();
    }

    @ModelAttribute(name = "memories")
    public List<MemoryEntity> memoryEntities() {
        return memoryService.findAll();
    }

    @ModelAttribute(name = "colors")
    public List<ColorEntity> colorEntities() {
        return colorService.findAll();
    }

    @ModelAttribute(name = "brands")
    public List<BrandEntity> brandEntities() {
        return brandService.findAll();
    }

    @GetMapping("create")
    public String createProductPage() {
        return "backend/product/saveOrEdit";
    }

    @GetMapping("update/{id}")
    public String updatePage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            ProductDTO productDTO = productService.findOneById(id);
            model.addAttribute("product", productDTO);
            return "/backend/product/saveOrEdit";
        } catch (Exception e) {
            MessageResponse.dangerAlert(redirectAttributes, messageConfig.getMessage("system.error"));
            return "redirect:/backend/product/list";
        }
    }

    @GetMapping("delete/{id}")
    public String deleteProduct(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        productService.deleteById(id, redirectAttributes);
        return "redirect:/backend/product/list";
    }

    @PostMapping("save")
    public String saveProduct(ProductDTO productRequest, RedirectAttributes model) {
        if(productRequest.getId() == null) {
            productService.save(productRequest, model);
        } else {
            productService.update(productRequest, model);
        }
        return "redirect:/backend/product/list";
    }

}
