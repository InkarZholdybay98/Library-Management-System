package com.example.libary.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "publishers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column
  private String publisherName;

  @ManyToMany(mappedBy = "publishers" , cascade = CascadeType.ALL)
  @JsonIgnore
  private List<Book> books;

}
