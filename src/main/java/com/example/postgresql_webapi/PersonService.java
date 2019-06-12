package com.example.postgresql_webapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired
  PersonRepository repository;
  @Autowired
  JdbcTemplate jdbcTemplate;

  public List<Person> findAll() {
    // ID順にソートして返す TODO コピペなので理解しきってない
    return ((List<Person>) repository.findAll()).stream().sorted(Comparator.comparing(Person::getId))
        .collect(Collectors.toList());
  }

  public Optional<Person> findById(Long id) {
    return repository.findById(id);
  }

  public Person updateRecord(Person person) {
    return repository.save(person);
  }

  public String createRecord(Person _person) {
    //TODO IDはフロントエンド側は知らないので不親切
    if(repository.existsById(_person.getId())){
      //failedなのにHTTPは200が帰るのはおかしい
      return "failed: duplicate id record exists.";
    }
    int result = jdbcTemplate.update(
      new StringBuilder( "INSERT INTO person VALUES (")
      .append(_person.getId()).append(", '")
      .append(_person.getName()).append("', ")
      .append(_person.getAge()).append(")")
      .toString()
    );
    return "create succeed";
  }

  public String deleteRecord(Long id){
    if(!repository.existsById(id)){
      return "delete faild:no such record.";
    }
    repository.deleteById(id);
    return "delete succeed";
  }
}