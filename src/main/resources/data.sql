DROP TABLE IF EXISTS USUARIOS;
DROP TABLE IF EXISTS PROJETOS;
DROP TABLE IF EXISTS USUARIOS_PROJETOS;
DROP TABLE IF EXISTS HORAS_APONTADAS;

CREATE TABLE USUARIOS
(
  MATRICULA_USUARIO INT AUTO_INCREMENT  PRIMARY KEY,
  NOME_USUARIO VARCHAR(50) NOT NULL,
  TIPO_USUARIO INT(2) NOT NULL
);

insert into USUARIOS (NOME_USUARIO,TIPO_USUARIO) values
    ('Administrador',1),
    ('Programador 1',2),
    ('Programador 2',2);

CREATE TABLE PROJETOS
(
  ID_PROJETO INT AUTO_INCREMENT  PRIMARY KEY,
  NOME_PROJETO VARCHAR(50) NOT NULL
);

insert into PROJETOS (NOME_PROJETO) values
    ('Projeto Cliente A'),
    ('Projeto Cliente B');

CREATE TABLE USUARIOS_PROJETOS
(
  MATRICULA_USUARIO INT(10) NOT NULL ,
  ID_PROJETO INT(10) NOT NULL,
  FOREIGN KEY(MATRICULA_USUARIO) REFERENCES USUARIOS,
  FOREIGN KEY(ID_PROJETO) REFERENCES PROJETOS
);

insert into USUARIOS_PROJETOS (MATRICULA_USUARIO,ID_PROJETO) values
    (2,1),
    (3,1),
    (3,2);

CREATE TABLE HORAS_APONTADAS
(
  MATRICULA_USUARIO INT(10) NOT NULL ,
  ID_PROJETO INT(10) NOT NULL,
  HORAS_APONTADAS TIME,
  DATA_DO_LACAMENTO DATE
)


