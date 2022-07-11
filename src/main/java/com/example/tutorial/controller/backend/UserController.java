package com.example.tutorial.controller.backend;

import com.example.tutorial.dto.UserDTO;
import com.example.tutorial.service.UserService;
import com.example.tutorial.utils.MessageResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/backend/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public String getListUser(Model model) {
        List<UserDTO> userDTOList = userService.findAll();
        model.addAttribute("users", userDTOList);
        return "backend/user/user_list";
    }

    @GetMapping("detail/{userId}")
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
            userService.save(userDTO);
            if(userDTO.getId() != null) {
                MessageResponse.successAlert(attributes, "Cập nhật thông tin tài khoản thành công");
            } else {
                MessageResponse.successAlert(attributes, "Thêm tài khoản thành công");
            }
        } catch (Exception e) {
            MessageResponse.dangerAlert(attributes,"Có lỗi xảy ra");
        }
        return "redirect:/backend/user/list";
    }

}
