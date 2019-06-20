package com.example.postgresql_webapi;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
  @Autowired
  PersonRepository repository;
  @Autowired
  NamedParameterJdbcTemplate template;

  private final String INSERT_PERSON_SQL = "INSERT INTO person (id, name, age) VALUES (:id, :name, :age)";

  public List<Person> findAll() {
    // ID順にソートして返す TODO コピペなので理解しきってない
    return ((List<Person>) repository.findAll()).stream()
      .sorted(Comparator.comparing(Person::getId))
      .collect(Collectors.toList());
  }

  //IDを指定して検索
  public Optional<Person> findById(Long id) {
    //idが不正の場合は空文字列ではなく"null"という文字列が帰る
    //TODO Web APIとしてはちょっと不親切
    return repository.findById(id);
  }

  //既存レコードの更新
  public Person updateRecord(Person person) {
    //TODO 更新が成功したら成功後のレコードをJSONで返し、失敗したらエラーを返したい(200ではない)
    //ハンドリングが雑。
    return repository.save(person);
  }

  public  Optional<Person> createRecord(Person _person) {
    long newRecordId = 0;
    for (Person itr : repository.findAll()) {
      if(itr.getId() > newRecordId){
        newRecordId = itr.getId();
      }
    }
    newRecordId += 1;

    _person.setId(Long.valueOf(newRecordId));

    //TODO INSERT生打ち…もう少し自動生成に寄せたい
    SqlParameterSource param = new MapSqlParameterSource()
      .addValue("id", _person.getId())
      .addValue("name", _person.getName())
      .addValue("age", _person.getAge());

    template.update(INSERT_PERSON_SQL, param);

    return repository.findById(newRecordId);
  }

  public String deleteRecord(Long id){
    if(!repository.existsById(id)){
      return "delete failed:no such record.";
    }
    repository.deleteById(id);
    return "delete succeeded";
  }
}