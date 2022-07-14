package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.BrandEntity;
import com.example.tutorial.service.BrandService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/backend/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("/create")
    public String createPage() {
        return "backend/brand/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String saveBrand(BrandEntity brand, RedirectAttributes model) {
        brandService.save(brand, model);
        return "redirect:/backend/brand/list";
    }


    @GetMapping("list")
    public String homeBrand(Model model,
                            @RequestParam(required = false) String searchKey,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        brandService.findAll(page, perPage, searchKey, model);
        return "/backend/brand/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        BrandEntity brandEntity = brandService.findOne(id);
        if (brandEntity == null) {
            MessageResponse.warningAlert(redirectAttributes, messageConfig.getMessage("id_not_found"));
            return "redirect:/backend/brand/list";
        }
        model.addAttribute("brand", brandEntity);
        return "backend/brand/saveOrEdit";
    }

    @GetMapping("delete/{id}")
    public String deleteBrand(@PathVariable Long id, RedirectAttributes model) {
        brandService.deleteById(id, model);
        return "redirect:/backend/brand/list";
    }


}
