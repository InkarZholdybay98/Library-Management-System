package com.example.libary.service;

import java.util.List;
import com.example.libary.entity.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.libary.repository.PublisherRepo;

@Service
public class PublisherService {
  
  @Autowired
  private PublisherRepo publisherRepo;

  public List<Publisher> getAllPublishers(){
    return publisherRepo.findAll();
  }

  public Publisher getPublisher(Long id){
    return publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Publisher does not exist"));
  }

  public Publisher addNewPublisher(Publisher publisher){
    return publisherRepo.save(publisher);
  }

  public Publisher changePublisherName(Long id , String newName){
    Publisher publisher = publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Publisher does not exist"));
    publisher.setPublisherName(newName);
    return publisherRepo.save(publisher);
  }

  public void deletePublisher(Long id){
    Publisher publisher = publisherRepo.findById(id).orElseThrow(() -> new RuntimeException("Publisher does not exist"));
    publisherRepo.deleteById(id);
  }

}
