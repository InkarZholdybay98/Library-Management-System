package com.example.libary.controller;

import java.util.List;
import com.example.libary.entity.Publisher;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.libary.service.PublisherService;
import java.util.*;

@RestController
@RequestMapping("/api/publishers")
public class PublisherController {

  @Autowired
  private PublisherService publisherService; 
  
  @GetMapping
  public ResponseEntity<List<Publisher>> getPublishers(){
    List<Publisher> publishers = publisherService.getAllPublishers();
    return ResponseEntity.ok(publishers);
  }

  @GetMapping("/{id}")
  public ResponseEntity<Publisher> getPublisherById(@PathVariable Long id){
    return ResponseEntity.ok(publisherService.getPublisher(id));
  }

  @PostMapping
  public ResponseEntity<Publisher> saveNewPublisher(@RequestBody Publisher publisher){
    return new ResponseEntity<>(publisherService.addNewPublisher(publisher) , HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Publisher> changePublisherName(@PathVariable Long id , @RequestBody Map<String , String> request){
    return ResponseEntity.ok(publisherService.changePublisherName(id, request.get("newName")));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deletePublisher(@PathVariable Long id){
    publisherService.deletePublisher(id);
    return ResponseEntity.ok("Publisher was successfully deleted");
  }

}
