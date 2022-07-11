package com.example.tutorial.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private String image;
    private Long price;
    private Long categoryId;
    private Long memoryId;
    private Long colorId;
}
