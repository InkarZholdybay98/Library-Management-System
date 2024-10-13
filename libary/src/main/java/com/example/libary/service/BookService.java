package com.example.libary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.libary.entity.Book;
import com.example.libary.repository.BookRepo;

@Service
public class BookService {

  @Autowired
  private BookRepo bookRepo;
  
  public Book addNewBook(Book book){
    return bookRepo.save(book);
  }

  public List<Book>getAllBooks(){
    return bookRepo.findAll();
  }

  public Book getBookById(Long id){
    Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book does not exist"));
    return book;
  }

  public Book changeBookName(Long id , String newname){
    Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book does not exist"));
    book.setBookName(newname);
    bookRepo.save(book);
    return book;
  }

  public void deleteBook(Long id){
    Book book = bookRepo.findById(id).orElseThrow(() -> new RuntimeException("Book does not exist"));
    bookRepo.deleteById(id);
  }

}
