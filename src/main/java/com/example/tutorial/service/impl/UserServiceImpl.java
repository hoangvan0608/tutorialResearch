package com.example.tutorial.service.impl;

import com.example.tutorial.config.language.MessageConfig;
import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.entity.UserDetailEntity;
import com.example.tutorial.entity.UserEntity;
import com.example.tutorial.repository.UserDetailRepository;
import com.example.tutorial.repository.UserRepository;
import com.example.tutorial.service.UserService;
import com.example.tutorial.utils.CONSTANT;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;
    @Autowired
    MessageConfig messageConfig;

    @Autowired
    private EmailServiceImpl emailService;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public void findAll(Integer page, Integer perPage, String key, Model model) {
        Page<UserEntity> pages = userRepository.findAll(PageRequest.of(page - 1, perPage));
        model.addAttribute("users", pages.getContent());
        model.addAttribute("page", page);
        model.addAttribute("perPage", perPage);
        model.addAttribute("total", pages.getTotalPages());

    }

    @Override
    public UserDTO findOneById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).get();
        UserDetailEntity userDetail = userDetailRepository.findFirstByUserId(userId);
        if (userEntity != null) {
            UserDTO userDTO = new UserDTO();
            userDTO.setRole(userEntity.getRole());
            userDTO.setPassword(userEntity.getPassword());
            userDTO.setFullName(userEntity.getFullName());
            userDTO.setEmail(userEntity.getEmail());
            userDTO.setId(userId);
            if(userDetail != null){
                userDTO.setPhone(userDetail.getPhoneNumber());
                userDTO.setAddress(userDetail.getAddress());
            }
            return userDTO;
        }
        return null;
    }

    @Override
    @Transactional
    public void save(UserDTO dto, RedirectAttributes attributes) {
        UserEntity userEntity = null;
        if(userRepository.existsByEmail(dto.getEmail())) {
            MessageResponse.dangerAlert(attributes, String.format(messageConfig.getMessage("email.error"), dto.getEmail()));
            return;
        }
        if (dto.getId() == null) {
            userEntity = new UserEntity();
            userEntity.setEmail(dto.getEmail());
            userEntity.setACTIVE(true);
            userEntity.setCode(UUID.randomUUID().toString());
            userEntity.setInsertTime(Timestamp.valueOf(LocalDateTime.now()));

        } else {
            userEntity = userRepository.findById(dto.getId()).get();
            userEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        }
        if (userEntity != null) {
            userEntity.setFullName(dto.getFullName());
            userEntity.setRole(dto.getRole());
            userEntity.setPassword(dto.getPassword());
            userRepository.save(userEntity);
            userDetailRepository.deleteAllByUserId(dto.getId());
            if(!StringUtils.isEmpty(dto.getPhone()) && !StringUtils.isEmpty(dto.getAddress())) {
                UserDetailEntity userDetail = new UserDetailEntity();
                userDetail.setUserId(userEntity.getId());
                userDetail.setAddress(dto.getAddress());
                userDetail.setPhoneNumber(dto.getPhone());
                userDetailRepository.save(userDetail);
            }
        }
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        userDetailRepository.deleteAllByUserId(id);
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void register(UserDTO dto, RedirectAttributes model) {
        if (userRepository.findUserEntityByEmail(dto.getEmail()) != null) {
            MessageResponse.warningAlert(model, messageConfig.getMessage("email.error"));
            return;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setFullName(dto.getFullName());
        userEntity.setEmail(dto.getEmail());
        userEntity.setRole(CONSTANT.ROLE_USER);
        userEntity.setPassword(passwordEncoder.encode(dto.getPassword()));
        userEntity.setCode(UUID.randomUUID().toString());
        userEntity.setACTIVE(false);
        userEntity.setInsertTime(Timestamp.valueOf(LocalDateTime.now()));
        try {
//            emailService.sendMail(userEntity);
            userRepository.save(userEntity);
            MessageResponse.successAlert(model, messageConfig.getMessage("register.success"));
        } catch (Exception e) {
            MessageResponse.dangerAlert(model, messageConfig.getMessage("system.error"));
        }
    }

    @Override
    public void verifyAccountByCode(String code) {
        UserEntity userEntity = userRepository.findUserEntityByCode(code);
        if(userEntity == null) {
            return;
        }
        userEntity.setACTIVE(true);
        userRepository.save(userEntity);
    }
}
