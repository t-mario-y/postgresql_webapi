package com.example.postgresql_webapi;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired
  PersonRepository repository;

  public Iterable<Person> findAll(){
    return repository.findAll();
  }
  public Optional<Person> findById(Long id){
    return repository.findById(id);
  }
}