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

application.propetiesに追記  
※リポジトリではapplication.properties.envとして保持
```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://{host}:{port}/{dbName}
spring.datasource.username={userId}
spring.datasource.password={password}
```

Spring Boot起動時に下記のエラーが出た
```
java.sql.SQLFeatureNotSupportedException: org.postgresql.jdbc.PgConnection.createClob() メソッドはまだ実装されていません。
```
https://qiita.com/bwtakacy/items/be3509e1765546f92184 を参考に、hibernate.propertiesを作成して記入
```
hibernate.jdbc.lob.non_contextual_creation = true
```
