package com.example.rollingstoneecommercecategoryapi.spring.service;

import com.example.rollingstoneecommercecategoryapi.spring.model.Category;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface CategoryService {
    Category save(Category category);
    Optional<Category> get(Long id);
    Page<Category> getCategoryByPage(Integer pageNumber, Integer pageSize);
    void update(Long id, Category category);
    void delete(Long id);
}
