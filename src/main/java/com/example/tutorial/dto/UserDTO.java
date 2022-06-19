package com.example.tutorial.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {
    private Long id;
    private String fullName;
    private String email;
    private String password;
    private String repass;
    private String role;
}
