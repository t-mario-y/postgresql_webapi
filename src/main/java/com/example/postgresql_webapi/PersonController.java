package com.example.postgresql_webapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  PersonService service;
  
  @GetMapping(value="/findAll")
  public List<Person> findAll(){
    return (List<Person>) service.findAll();
  }
  @GetMapping(value="/findById/{id}")
  public Optional<Person> findById(@PathVariable("id") Long id){
    return service.findById(id);
  }
}