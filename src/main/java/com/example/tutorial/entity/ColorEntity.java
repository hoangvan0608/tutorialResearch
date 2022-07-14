package com.example.tutorial.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity(name = "color")
@Data
public class ColorEntity extends EntityBase{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

}
