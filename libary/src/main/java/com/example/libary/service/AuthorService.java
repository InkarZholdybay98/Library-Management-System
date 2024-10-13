package com.example.libary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;
import com.example.libary.entity.Author;
import com.example.libary.repository.AuthorRepo;

@Service
public class AuthorService {

  @Autowired
  private AuthorRepo authorRepo;

  public List<Author> getAllAuthors(){
    return authorRepo.findAll();
  }

  public Author getAuthorById(Long id){
    return authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author does not exist"));
  }
  
  public Author addAuthor(Author author){
    return authorRepo.save(author);
  }

  public Author changeAuthorName(Long id , String newName){
    Author author = authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author does not exist"));
    author.setAuthorName(newName);
    return authorRepo.save(author);
  }

  public void deleteAuthor(Long id){
    Author author = authorRepo.findById(id).orElseThrow(() -> new RuntimeException("Author does not exist"));
    authorRepo.deleteById(id);
  }

}
