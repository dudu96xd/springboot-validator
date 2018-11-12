Setup
-----
- Clone and open in Intellij Idea IDE
- Change database connection config in `src/main/resources/application.properties`
- Install maven dependencies using IDE auto import or using the command ``mvn install``
- Run the app using ``docker-compose up``
- Browse ``http//localhost:8081/api/planos``

Table Structure
---------------


``CREATE TABLE plano(
    id_plano int NOT NULL AUTO_INCREMENT,
    nome_plano varchar(45),
    valor double,
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