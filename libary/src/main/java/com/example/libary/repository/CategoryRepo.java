package com.example.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libary.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category , Long> {
  
}
