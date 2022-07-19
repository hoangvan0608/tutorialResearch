package com.example.tutorial.service;

import com.example.tutorial.dto.LoginRequest;
import com.example.tutorial.dto.UserDTO;
import org.springframework.ui.Model;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface UserService {
    void findAll(Integer page, Integer perPage, String key, Model model);

    UserDTO findOneById(Long userId);

    void save(UserDTO dto, RedirectAttributes attributes);

    void deleteById(Long id);

    void register(UserDTO dto, RedirectAttributes model);
    void verifyAccountByCode(String code);

    Integer getAccountByUsername(LoginRequest loginRequest);
}
