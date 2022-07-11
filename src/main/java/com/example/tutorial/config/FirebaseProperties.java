package com.example.tutorial.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "firebase")
public class FirebaseProperties {
    public String bucketName;

    public String imageUrl;
}
