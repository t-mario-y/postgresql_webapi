# postgresql_webapi
Spring Boot to PostgreSQL API

https://cloud.google.com/solutions/set-up-postgres?hl=ja
 - Compute Engine インスタンス上で PostgreSQL をインストールする。  
 - PostgreSQL をリモート アクセス用に設定する。  
 - ポートを開くように Cloud Platform ファイアウォールを設定する。  
 - リモート パソコンから PostgreSQL に接続する。

Spring Initilizrで下記4つを有効にして作成  
 - Web Startar
 - JPA
 - postgresql
 - lombok

以下の内容はJPAなので、Spring Data Jdbcに移行後は不要  

Spring Boot起動時に下記のエラーが出た
```
java.sql.SQLFeatureNotSupportedException: org.postgresql.jdbc.PgConnection.createClob() メソッドはまだ実装されていません。
```
https://qiita.com/bwtakacy/items/be3509e1765546f92184 を参考に、hibernate.propertiesを作成して記入
```
hibernate.jdbc.lob.non_contextual_creation = true
```
