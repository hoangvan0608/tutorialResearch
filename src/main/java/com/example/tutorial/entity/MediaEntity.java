package com.example.tutorial.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "media")
public class MediaEntity extends  EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String path;
    private Long productId;
}
