package com.example.tutorial.service.impl;

import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.entity.UserEntity;
import com.example.tutorial.repository.UserRepository;
import com.example.tutorial.service.UserService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Override
    public List<UserDTO> findAll() {
        return modelMapper.map(userRepository.findAll(), new TypeToken<List<UserDTO>>(){}.getType());
    }

    @Override
    public UserDTO findOneById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        if(userEntity != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setRole(userEntity.getRole());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setFullName(userEntity.getFullName());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setId(userId);
            return userDTO;
        }
        return null;
    }

    @Override
    public void save(UserDTO dto) {
        if(dto.getId() == null) {
            UserEntity userEntity = new UserEntity();
            userEntity.setFullName(dto.getFullName());
            userEntity.setEmail(dto.getEmail());
            userEntity.setRole(dto.getRole());
            userEntity.setPassword(dto.getPassword());
            userRepository.save(userEntity);
        } else {
            UserEntity userEntity = userRepository.findById(dto.getId()).get();
            if(userEntity != null) {
                userEntity.setFullName(dto.getFullName());
                userEntity.setEmail(dto.getEmail());
                userEntity.setRole(dto.getRole());
                userEntity.setPassword(dto.getPassword());
                userRepository.save(userEntity);
            }
        }
    }
}
