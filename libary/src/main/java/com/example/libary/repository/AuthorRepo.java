package com.example.libary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.libary.entity.Author;

@Repository
public interface AuthorRepo extends JpaRepository<Author , Long>{
  
}
