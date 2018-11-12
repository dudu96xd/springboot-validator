use mydb;
CREATE TABLE plano(  id_plano int NOT NULL AUTO_INCREMENT,  nome_plano varchar(45),  valor double,  qnt_gigas int,  primary key(id_plano));
CREATE TABLE usuario (  id_usuario int(11) NOT NULL AUTO_INCREMENT,  nome varchar(45) NOT NULL unique key,  email varchar(45) NOT NULL unique key,  data_ca
dastro date,  linha varchar(45) NOT NULL unique key,  id_plano int default null,  primary key(id_usuario),  foreign key(id_plano) references plano(id_plano));
