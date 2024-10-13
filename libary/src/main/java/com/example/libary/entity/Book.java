package com.example.libary.entity;

import java.util.*;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "books")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String bookName;

  @ManyToMany
  @JoinTable(name = "book_authors" , 
             joinColumns = {@JoinColumn(name = "book_id")} ,
             inverseJoinColumns = {@JoinColumn(name = "author_id")})
  private List<Author> authors;

  @ManyToMany
  @JoinTable(name = "book_publishers" , 
            joinColumns = {@JoinColumn(name = "book_id")} , 
            inverseJoinColumns = {@JoinColumn(name = "publisher_id")})
  private List<Publisher> publishers;

  @ManyToMany
  @JoinTable(name = "books_categories" , 
            joinColumns = {@JoinColumn(name = "book_id")} , 
            inverseJoinColumns = {@JoinColumn(name = "category_id")})
  private List<Category> categories;
}
