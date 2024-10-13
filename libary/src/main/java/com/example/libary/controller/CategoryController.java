package com.example.libary.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libary.entity.Category;
import com.example.libary.service.CategoryService;
import java.util.*;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

  @Autowired
  private CategoryService categoryService;
  
  @PostMapping
  public ResponseEntity<Category>  addCategory(@RequestBody Category category ){
    return new ResponseEntity<>(categoryService.saveNewCategory(category) , HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Category>> getCategories(){
    List<Category> categories = categoryService.getCategories();
    return ResponseEntity.ok(categories);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
    return ResponseEntity.ok(categoryService.getCategory(id));
  }

  @PutMapping("/{id}")
  public ResponseEntity<Category> changeNameOfCategory(@PathVariable Long id , @RequestBody Map<String  , String> request){
    String newName = request.get("newName");
    return ResponseEntity.ok(categoryService.changeCategoryName(id, newName));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteCategory(@PathVariable Long id){
    categoryService.deleteCategory(id);
    return ResponseEntity.ok("Category was successfully deleted");
  }

}
