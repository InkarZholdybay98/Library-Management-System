package com.example.libary.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Author {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String authorName;

  @ManyToMany(mappedBy = "authors" , cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Book> books;
  
}
