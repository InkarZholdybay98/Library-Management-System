package com.example.libary.repository;

import com.example.libary.entity.Publisher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends JpaRepository<Publisher , Long> {
  
}
