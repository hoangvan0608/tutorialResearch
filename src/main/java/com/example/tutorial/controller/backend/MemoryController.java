package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.entity.MemoryEntity;
import com.example.tutorial.service.MemoryService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/backend/memory")
public class MemoryController {
    @Autowired
    private MemoryService service;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("/create")
    public String createPage() {
        return "backend/memory/saveOrEdit";
    }

    @PostMapping(path = "/save")
    public String save(MemoryEntity entity, RedirectAttributes model) {
        service.save(entity, model);
        return "redirect:/backend/memory/list";
    }


    @GetMapping("list")
    public String homePage(Model model,
                            @RequestParam(required = false) String searchKey,
                            @RequestParam(required = false, defaultValue = "1") Integer page,
                            @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        service.findAll(page, perPage, searchKey, model);
        return "/backend/memory/list";
    }

    @GetMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        MemoryEntity entity = service.findOne(id);
        if (entity == null) {
            MessageResponse.warningAlert(redirectAttributes, messageConfig.getMessage("id_not_found"));
            return "redirect:/backend/memory/list";
        }
        model.addAttribute("memory", entity);
        return "backend/memory/saveOrEdit";
    }

    @GetMapping("delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes model) {
        service.deleteById(id, model);
        return "redirect:/backend/hashtag/list";
    }


}
