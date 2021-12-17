package com.example.rollingstoneecommercecategoryapi.spring.controller;

import com.example.rollingstoneecommercecategoryapi.events.CategoryEvent;
import com.example.rollingstoneecommercecategoryapi.spring.model.Category;
import com.example.rollingstoneecommercecategoryapi.spring.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
public class CategoryController extends AbstractController{

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<?> createCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.save(category);
        CategoryEvent categoryEvent = new CategoryEvent("One category is created", savedCategory);
        eventPublisher.publishEvent(categoryEvent);
        return ResponseEntity.ok().body("New Category has been created with ID: "+savedCategory.getId());
    }

    @GetMapping("/category/{id}")
    @ResponseBody
    public Category getCategory(@PathVariable("id") long id){
        Optional<Category> returnedCategory = categoryService.get(id);
        Category category = returnedCategory.get();

        CategoryEvent categoryEvent = new CategoryEvent("One Category is retrieved", category);
        eventPublisher.publishEvent(categoryEvent);
        return category;
    }

    @GetMapping("/category")
    public @ResponseBody Page<Category> getCategoriesByPage(
            @RequestParam(value = "pageNumber", required = true, defaultValue = "0") Integer pageNumber,
            @RequestParam(value = "pageSize", required = true, defaultValue = "20") Integer pageSize) {
                Page<Category> pagedCategory = categoryService.getCategoryByPage(pageNumber, pageSize);
                return pagedCategory;
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<?> updateCategory(@PathVariable("id") long id, @RequestBody Category category){
        checkResourceFound(this.categoryService.get(id));
        categoryService.update(id, category);
        return ResponseEntity.ok().body("Category has been updated successfully");
    }

    @DeleteMapping("/category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable("id") long id){
        checkResourceFound(this.categoryService.get(id));
        categoryService.delete(id);
        return ResponseEntity.ok().body("Category has been deleted successfully");
    }
}
