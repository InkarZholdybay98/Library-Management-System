package com.example.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libary.entity.Book;

@Repository
public interface BookRepo extends JpaRepository<Book , Long> {
  
}
