package com.example.tutorial.service.impl;

import com.example.tutorial.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailServiceImpl {

    @Autowired
    JavaMailSender mailSender;
    public void sendMail(UserEntity userEntity) {
        String text = "http://localhost:8080/register/verify/" + userEntity.getCode();
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(userEntity.getEmail());
        mailMessage.setSubject("Verify your account");
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<h1>Xác Thực tài khoản </h1>")
                .append("<h2>Vui lòng bấm vào link sau để xác thực tài khoản của bạn</h2>")
                .append(text);
        mailMessage.setText(stringBuilder.toString());
        mailMessage.setSentDate(new Date());
        mailSender.send(mailMessage);
    }
}
