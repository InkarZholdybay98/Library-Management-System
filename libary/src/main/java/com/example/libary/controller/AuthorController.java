package com.example.libary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libary.entity.Author;
import com.example.libary.service.AuthorService;
import java.util.*;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {

  @Autowired
  private AuthorService authorService;

  @GetMapping
  public ResponseEntity<List<Author>> getAuthors(){
    List<Author> authors = authorService.getAllAuthors();
    return ResponseEntity.ok(authors);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Author> getAuthorById(@PathVariable Long id){
    Author author = authorService.getAuthorById(id);
    return ResponseEntity.ok(author);
  }
 
  @PostMapping
  public ResponseEntity<Author> saveNewAuthor(@RequestBody Author author){
    Author newAuthor = authorService.addAuthor(author);
    return new ResponseEntity<>(newAuthor, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Author> changeAuthorsName(@PathVariable Long id , @RequestBody Map<String , String> request){
    String newName = request.get("newName");
    Author author =  authorService.changeAuthorName(id, newName);
    return ResponseEntity.ok(author);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteAuthor(@PathVariable Long id){
    authorService.deleteAuthor(id);
    return ResponseEntity.ok("Author was successfully deleted");
  }
  
}
