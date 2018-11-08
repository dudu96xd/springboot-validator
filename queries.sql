create schema mydb;

drop schema mydb;

use mydb;

CREATE TABLE usuario (
  id_usuario int(11) NOT NULL AUTO_INCREMENT,
  nome varchar(45) NOT NULL unique key,
  email varchar(45) NOT NULL unique key,
  data_cadastro date,
  linha varchar(45) NOT NULL unique key,
  id_plano int default null,
  primary key(id_usuario),
  foreign key(id_plano) references plano(id_plano)
);

select * from usuario;

CREATE TABLE plano(
  id_plano int NOT NULL AUTO_INCREMENT,
  nome_plano varchar(45),
  qnt_gigas int,
  primary key(id_plano)
);

ALTER USER 'dudu9'@'localhost' IDENTIFIED WITH mysql_native_password BY '1234';