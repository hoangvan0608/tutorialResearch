package com.example.tutorial.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

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
    private Long brandId;
    private Long hashTag;
    private List<String> paths = new ArrayList<>();
}
