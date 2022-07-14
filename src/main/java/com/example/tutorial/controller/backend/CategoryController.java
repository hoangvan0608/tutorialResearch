package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.service.CategoryService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/backend/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("/create")
    public String createPage() {
        return "backend/category/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String saveCategory(CategoryDTO categoryDTO, RedirectAttributes model) {
        categoryService.save(categoryDTO, model);
        if (categoryDTO.getId() == null) {
            return "redirect:/backend/category/create";
        } else {
            return "redirect:/backend/category/list";
        }
    }

    @GetMapping("/list")
    public String homeCategory(Model model,
                            @RequestParam(required = false) String searchKey,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        categoryService.findAll(page, perPage, searchKey, model);
        return "backend/category/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        CategoryDTO dto = categoryService.findOne(id);
        if (dto == null) {
            MessageResponse.warningAlert(redirectAttributes, messageConfig.getMessage("id_not_found"));
            return "redirect:/backend/category/list";
        }
        model.addAttribute("category", dto);
        return "backend/category/saveOrEdit";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes model) {
        categoryService.deleteById(id, model);
        return "redirect:/backend/category/list";
    }


}
