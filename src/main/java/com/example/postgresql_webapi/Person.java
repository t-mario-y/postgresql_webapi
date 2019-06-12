package com.example.postgresql_webapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table(value = "person")
public class Person {

  @Id
  private Long id;

  private String name;

  private Integer age;
}