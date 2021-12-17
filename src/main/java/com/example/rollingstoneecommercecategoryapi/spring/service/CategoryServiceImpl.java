package com.example.rollingstoneecommercecategoryapi.spring.service;

import com.example.rollingstoneecommercecategoryapi.exceptions.Http400Exception;
import com.example.rollingstoneecommercecategoryapi.spring.dao.CategoryDaoRepository;
import com.example.rollingstoneecommercecategoryapi.spring.model.Category;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService{
    private final Logger log = LoggerFactory.getLogger(CategoryServiceImpl.class);

    @Autowired
    private CategoryDaoRepository categoryDao;

    @Override
    public Category save(Category category) {
        try{
            return categoryDao.save(category);
        }catch (Exception e){
            throw new Http400Exception(e.getMessage());
        }
    }

    @Override
    public Optional<Category> get(Long id) {
        return categoryDao.findById(id);
    }

    @Override
    public Page<Category> getCategoryByPage(Integer pageNumber, Integer pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("categoryName").descending());
        return categoryDao.findAll(pageable);
    }

    @Override
    public void update(Long id, Category category) {
        categoryDao.save(category);
    }

    @Override
    public void delete(Long id) {
        categoryDao.deleteById(id);
    }
}
