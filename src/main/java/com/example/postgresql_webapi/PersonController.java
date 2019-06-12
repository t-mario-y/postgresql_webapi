package com.example.postgresql_webapi;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
  @RequestMapping(value="/update", method=RequestMethod.PATCH)
  public Person update(@RequestBody Person param) {
    return service.updateRecord(param);
  }
  @RequestMapping(value="/create", method=RequestMethod.POST)
  public String create(@RequestBody Person param) {
    return service.createRecord(param);
  }
  @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
  public String delete(@PathVariable("id") Long id){
    service.deleteRecord(id);
    return "delete success.";
  }
}