package com.example.tutorial.entity;

import lombok.Data;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity(name = "brand")
@Data
public class BrandEntity extends EntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
