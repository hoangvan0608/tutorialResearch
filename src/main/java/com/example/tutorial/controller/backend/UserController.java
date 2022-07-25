package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.service.UserService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/backend/user")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    MessageConfig messageConfig;

    @GetMapping("/list")
    public String getListUser(Model model,
                              @RequestParam(required = false) String searchKey,
                              @RequestParam(required = false, defaultValue = "1") Integer page,
                              @RequestParam(required = false, defaultValue = "5") Integer perPage) {
        userService.findAll(page, perPage, searchKey, model);
        return "backend/user/user_list";
    }

    @GetMapping("/update/{userId}")
    public String userDetail(@PathVariable Long userId, Model model) {
        UserDTO userDTO = userService.findOneById(userId);
        model.addAttribute("user", userDTO);
        return "backend/user/saveOrEdit";
    }

    @GetMapping("/create")
    public String createPage(Model model) {
        model.addAttribute("userDto", new UserDTO());
        return "backend/user/saveOrEdit";
    }

    @PostMapping("/save")
    public String save(UserDTO userDTO, RedirectAttributes attributes) {
        try {
            userService.save(userDTO, attributes);
            if (userDTO.getId() != null) {
                MessageResponse.successAlert(attributes, messageConfig.getMessage("update.success"));
            } else {
                MessageResponse.successAlert(attributes, messageConfig.getMessage("save.success"));
            }
        } catch (Exception e) {
            MessageResponse.dangerAlert(attributes, messageConfig.getMessage("system.error"));
        }
        return "redirect:/backend/user/list";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id, RedirectAttributes model) {
        try {
            userService.deleteById(id);
            MessageResponse.successAlert(model, messageConfig.getMessage("delete.success"));
        } catch (Exception e) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
        return "redirect:/backend/user/list";
    }

}
