package com.example.tutorial.service;

import com.example.tutorial.dto.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> findAll();

    UserDTO findOneById(Long userId);

    void save(UserDTO dto);
}
