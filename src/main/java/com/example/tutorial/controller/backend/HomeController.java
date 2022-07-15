package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.service.UserService;
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


    @GetMapping("/login")
    public String login(@RequestParam(name = "error", required = false) String error, RedirectAttributes model, Model model1) {
        if (!StringUtils.isEmpty(error)) {
            MessageResponse.dangerAlert(model, "Sai tài khoản hoặc mật khẩu!");
            return "redirect:/login";
        }
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
