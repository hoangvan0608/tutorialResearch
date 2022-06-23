package com.example.tutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "product")
@Builder
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = true)
    private String image;

    @Column(nullable = false)
    private Long price;

    @Column(nullable = false)
    private Long categoryId;

    @Column
    private Long memoryId;

    @Column
    private Long colorId;
}
