package com.example.tutorial.controller.backend;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.LoginRequest;
import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.service.UserService;
import com.example.tutorial.utils.CONSTANT;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @Autowired
    MessageConfig messageConfig;


    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, RedirectAttributes model, Model model1) {
        if (!StringUtils.isEmpty(error)) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("login_error"));
            return "redirect:/login";
        }
        return "login";
    }

    @PostMapping("/doLogin")
    public String loginProcess(LoginRequest loginRequest, RedirectAttributes redirectAttributes, Model model) {
        Integer code = userService.getAccountByUsername(loginRequest);
        if (code == CONSTANT.EMAIL_NOT_FOUND) {
            MessageResponse.dangerAlert(redirectAttributes, messageConfig.getMessage("email_not_found"));
            return "redirect:/login";
        } else if (code == CONSTANT.PASSWORD_INVALID) {
            MessageResponse.dangerAlert(redirectAttributes, messageConfig.getMessage("password_invalid"));
            return "redirect:/login";
        }
        return "redirect:/backend/product/list";
    }

    @GetMapping("/register")
    public String signupPage(Model model) {
        UserDTO userDTO = new UserDTO();
        model.addAttribute("dto", userDTO);
        return "signup";
    }

    @PostMapping("/register")
    public String signup(@Valid @ModelAttribute("dto") UserDTO dto, BindingResult bindingResult, RedirectAttributes model) {
        if (bindingResult.hasErrors()) {
            return "signup";
        }
        userService.register(dto, model);
        return "redirect:/register";
    }

    @GetMapping("/register/verify/{code}")
    public String verify(@PathVariable String code) {
       userService.verifyAccountByCode(code);
       return "redirect:/login";
    }
}
