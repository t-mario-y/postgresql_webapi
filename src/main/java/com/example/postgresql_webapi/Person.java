package com.example.postgresql_webapi;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Getter;
import lombok.Setter;

@Table(value = "person")
public class Person {

  @Id
  @Getter @Setter
  private Long id;

  @Getter @Setter
  private String name;

  @Getter @Setter
  private Integer age;
}