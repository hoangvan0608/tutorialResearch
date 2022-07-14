package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.ColorEntity;
import com.example.tutorial.service.ColorService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/backend/color")
public class ColorController {
    @Autowired
    private ColorService colorService;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("/create")
    public String createPage() {
        return "backend/color/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String save(ColorEntity brand, RedirectAttributes model) {
        colorService.save(brand, model);
        return "redirect:/backend/color/list";
    }


    @GetMapping("list")
    public String homePage(Model model,
                            @RequestParam(required = false) String searchKey,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        colorService.findAll(page, perPage, searchKey, model);
        return "/backend/color/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        ColorEntity brandEntity = colorService.findOne(id);
        if (brandEntity == null) {
            MessageResponse.warningAlert(redirectAttributes, messageConfig.getMessage("id_not_found"));
            return "redirect:/backend/color/list";
        }
        model.addAttribute("color", brandEntity);
        return "backend/color/saveOrEdit";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes model) {
        colorService.deleteById(id, model);
        return "redirect:/backend/color/list";
    }


}
