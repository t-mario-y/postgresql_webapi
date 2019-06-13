package com.example.postgresql_webapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/persons")
public class WebApiController {
  @Autowired
  PersonService service;
  
  @GetMapping
  public List<Person> findAll(){
    return (List<Person>) service.findAll();
  }
  @GetMapping(value="/{id}")
  public Optional<Person> findById(@PathVariable("id") Long id){
    return service.findById(id);
  }
  @PatchMapping(value="/{id}")
  public Person update(@PathVariable("id") Long id, @RequestBody Person person) {
    person.setId(id);
    return service.updateRecord(person);
  }
  @PostMapping
  public Optional<Person> create(@RequestBody Person param) {
    return service.createRecord(param);
  }
  @DeleteMapping(value="/{id}")
  public String delete(@PathVariable("id") Long id){
    service.deleteRecord(id);
    return "delete success.";
  }
}