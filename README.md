# CRUDjavaconsola
Primer  CRUD usando java

Datos importantes

bdname: bd_escuela
table: estudiante 

SQlQuey

CREATE TABLE estudiante(
  id_estudiante int AUTO_INCREMENT NOT NULL,
  carnet_estudiante varchar(6) DEFAULT NULL,
  nom_estudiante varchar(30) DEFAULT NULL,
  ape_estudiante varchar(30) DEFAULT NULL,
  edad_estudiante int(3) NOT NULL,
  PRIMARY KEY (id_estudiante))
ENGINE=INNODB AUTO_INCREMENT=1000
