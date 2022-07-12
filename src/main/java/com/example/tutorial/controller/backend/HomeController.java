package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.service.UserService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String login() {
        return "login";
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
