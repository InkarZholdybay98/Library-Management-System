package com.example.libary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libary.entity.Category;
import com.example.libary.repository.CategoryRepo;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepo categoryRepo;
  
  public Category saveNewCategory(Category category){
    return categoryRepo.save(category);
  }

  public List<Category> getCategories(){
    return categoryRepo.findAll();
  }

  public Category getCategory(Long id){
    Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category does not exist"));
    return category;
  }

  public Category changeCategoryName(Long id , String newName){
    Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category does not exist"));
    category.setCategoryName(newName);
    categoryRepo.save(category);
    return category;
  }

  public void deleteCategory(Long id){
    Category category = categoryRepo.findById(id).orElseThrow(() -> new RuntimeException("Category does not exist"));
    categoryRepo.deleteById(id);
  }

}
