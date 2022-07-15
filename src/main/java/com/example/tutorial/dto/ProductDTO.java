package com.example.tutorial.dto;

import com.example.tutorial.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
    private Long userId;
    private List<String> paths = new ArrayList<>();
    private int size = paths.size();
}
