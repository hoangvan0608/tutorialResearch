package com.example.tutorial.dto;

import com.example.tutorial.dto.validation.password.RepassAnnotation;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@RepassAnnotation
public class UserDTO {
    private Long id;

    @NotBlank(message = "Vui lòng điền đầy đủ họ tên")
    private String fullName;

    @Email(message = "Vui lòng nhập đúng định dạng email")
    @NotBlank(message = "Vui lòng điền email của bạn")
    private String email;

    @NotBlank(message = "Vui lòng điền password")
    private String password;

//    @NotBlank(message = "Vui lòng điền Re-password")
    private String repass;
    private String role;

    private String address;
    private String phone;
    private String code;
    private String ACTIVE;
}
