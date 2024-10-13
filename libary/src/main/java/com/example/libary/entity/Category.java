package com.example.libary.entity;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String categoryName;

  @ManyToMany(mappedBy = "categories" , cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Book> books;
  
}
