package com.example.tutorial.controller;

import com.example.tutorial.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Controller
public class HomeController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String signupPage() {
        return "signup";
    }

    @PostMapping("/register")
    public String signup(@ModelAttribute UserDTO userDTO, RedirectAttributes model) {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/t3htutorial";
            String user = "root";
            String password = "2306";
            con = DriverManager.getConnection(url, user, password);
            if(con != null) {
                String sql = "INSERT INTO `user` (`fullname`, `email`, `password`, `role`) VALUES (?, ?, ?, ?)";
                PreparedStatement statement = con.prepareStatement(sql);
                statement.setString(1,userDTO.getFullName());
                statement.setString(2, userDTO.getEmail());
                statement.setString(3, userDTO.getPassword());
                statement.setString(4,"USER");
                int result = statement.executeUpdate();
                if(result > 0) {
                    model.addFlashAttribute("message", "Đăng ký thành công");
                    model.addFlashAttribute("alert", "success");
                } else {
                    model.addFlashAttribute("message", "Đăng ký thất bại");
                    model.addFlashAttribute("alert", "warning");
                }
            }
        } catch (SQLException  e) {
            model.addFlashAttribute("message", "System Errors");
            model.addFlashAttribute("alert", "danger");
        }
        return "redirect:/register";
    }
}
