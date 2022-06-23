package com.example.tutorial.service;

import java.util.List;

public interface GeneralService<T> {

    List<T> getAll();

    T getOne(Long id);

}
