package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.CategoryDTO;
import com.example.tutorial.service.CategoryService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/backend/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

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

    @GetMapping(path = "/list")
    public String getCategories(Model model) {
        List<CategoryDTO> list = categoryService.findAll();
        model.addAttribute("categories", list);
        return "backend/category/list";
    }

    @GetMapping("/update/{id}")
    public String update(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        CategoryDTO dto = categoryService.findOne(id);
        if (dto == null) {
            MessageResponse.warningAlert(redirectAttributes, "Không tìm thấy thể loại với id là : " + id);
            return "redirect:/backend/category/list";
        }
        model.addAttribute("category", dto);
        return "backend/category/saveOrEdit";
    }

    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable Long id, RedirectAttributes model) {
        categoryService.deleteById(id, model);
        return "redirect:/backend/category/list";
    }


}
