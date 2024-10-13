package com.example.libary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libary.entity.*;
import com.example.libary.service.*;
import java.util.*;

@RestController
@RequestMapping("/api/books")
public class BookController {

  @Autowired
  private BookService bookService;

  @Autowired
  private AuthorService authorService;

  @Autowired
  private PublisherService publisherService;

  @Autowired
  private CategoryService categoryService;
  
  @PostMapping
  public ResponseEntity<Book> addNewBook(@RequestBody Book book){

    List<Author> authors = new ArrayList<Author>();
    for (Author author : book.getAuthors()) {
      Author foundAuthor = authorService.getAuthorById(author.getId());
      authors.add(foundAuthor);
    }
    book.setAuthors(authors);


    List<Publisher> publishers = new ArrayList<Publisher>();
    for(Publisher publisher : book.getPublishers()){
      Publisher foundPublisher = publisherService.getPublisher(publisher.getId());
      publishers.add(foundPublisher);
    }
    book.setPublishers(publishers);


    List<Category> categories = new ArrayList<>();
    for(Category category : book.getCategories()){
      Category foundCategory = categoryService.getCategory(category.getId());
      categories.add(foundCategory);
    }
    book.setCategories(categories);

    return new ResponseEntity<>(bookService.addNewBook(book) , HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<Book>> getBooks(){
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Book> getBook(@PathVariable Long id){
    return ResponseEntity.ok(bookService.getBookById(id)) ;
  }

  @PutMapping("/{id}")
  public ResponseEntity<Book> changeBooksName(@PathVariable Long id , @RequestBody Book book){

    List<Author> authors = new ArrayList<>();
    for(Author author : book.getAuthors()){
      Author foundAuthor = authorService.getAuthorById(author.getId());
      authors.add(foundAuthor);
    }
    book.setAuthors(authors);

    List<Publisher> publishers = new ArrayList<>();
    for(Publisher publisher : book.getPublishers()){
      Publisher foundPublisher = publisherService.getPublisher(publisher.getId());
      publishers.add(foundPublisher);
    }
    book.setPublishers(publishers);

    List<Category> categories = new ArrayList<>();
    for(Category category : book.getCategories()){
      Category foundCategory = categoryService.getCategory(category.getId());
      categories.add(foundCategory);
    }
    book.setCategories(categories);

    book.setId(id);
    bookService.addNewBook(book);  
    return ResponseEntity.ok(book);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteBook(@PathVariable Long id){
    bookService.deleteBook(id);
    return ResponseEntity.ok("The book was successfully deleted");
  }

}
