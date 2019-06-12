package com.example.postgresql_webapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
  @Autowired
  PersonRepository repository;

  public List<Person> findAll() {
    // ID順にソートして返す TODO コピペなので理解しきってない
    return ((List<Person>) repository.findAll()).stream()
      .sorted(Comparator.comparing(Person::getId))
      .collect(Collectors.toList());
  }
  public Optional<Person> findById(Long id){
    return repository.findById(id);
  }
  public Person updateRecord(Person person){
    return repository.save(person);
  }

  @Transactional
  public Person createRecord(Person _person){
/*
    Person newPerson = new Person();
    newPerson.setAge(11);
    newPerson.setId(Long.valueOf(13));
    newPerson.setName("新渡戸稲造");
*/
    NamedParameterJdbcTemplate jdbcTemplate;
//    template.setDataSource(org.postgresql.Driver.class);
    return _person;
  }
  public String deleteRecord(Long id){
    if(!repository.existsById(id)){
      return "delete faild:no such record.";
    }
    repository.deleteById(id);
    return "delete succeed";
  }
}