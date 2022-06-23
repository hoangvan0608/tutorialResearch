package com.example.tutorial.payload.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewProductRequest {
    private Long id;
    private String name;
    private Long categoryId;
    private Long memoryId;
    private Long colorId;
    private String description;
    private String image;
    private Long price;
}
