Setup
-----
- Clone and open in Intellij Idea IDE
- Change database connection config in `src/main/resources/application.properties`
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Run the app using ``mvn spring-boot:run``
- Browse ``http//localhost:8080/api/usuarios``
- Create package for deployment using ``mvn package`` (change properties if required)

Table Structure
---------------


``CREATE TABLE plano(
  id_plano int NOT NULL AUTO_INCREMENT,
  nome_plano varchar(45),
  qnt_gigas int,
  primary key(id_plano)
);``

``CREATE TABLE usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) NOT NULL unique key,
  email varchar(45) NOT NULL unique key,
  data_cadastro date,
  linha varchar(45) NOT NULL unique key,
  id_plano int default null,
  primary key(id_usuario),
  foreign key(id_plano) references plano(id_plano)
);``

Note
-----
For getting XML response use ``Accept`` header ``application/xml`` and ``application/json`` for JSON response.