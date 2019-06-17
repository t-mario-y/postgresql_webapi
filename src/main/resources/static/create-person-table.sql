--参照用テーブルの定義、データの設定、検索、テーブル消去(oracle db)
CREATE TABLE person 
(
  id NUMBER(6,0) not null enable,
  name VARCHAR2(64) not null enable,
  age NUMBER(3) not null enable
)
TABLESPACE "DATA01_AREA"
;
insert into person (
  id,name,age
)values(
  1,'akira',21
)
;
insert into person (
  id,name,age
)values(
  2,'yukari',32
)
;
select * from person
;
drop table person
;
