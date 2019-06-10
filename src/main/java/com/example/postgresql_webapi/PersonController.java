package com.example.postgresql_webapi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
  @Autowired
  PersonService service;
  
  @RequestMapping(value="/getAll",method=RequestMethod.GET)
  public List<Person> index(){
    return service.findAll();
  }
}