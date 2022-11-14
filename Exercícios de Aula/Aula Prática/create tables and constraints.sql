create database `aulaPratica1`; 
use `aulaPratica1`; 

create table DISCIPLINA(
	codigo char(4) not null, 
    designacao varchar(100) not null, 
    constraint pk_disciplina primary key (codigo)
);


create table INSCRICAO (
	numero int not null, 
    codigo char(4) not null, 
    ano smallint not null, 
    nota numeric(3, 1) null, 
    constraint pk_inscricao primary key (numero, codigo)
); 

create table ALUNO (
	numero int not null, 
    nome varchar(100) not null, 
    genero char(1) not null, 
    nascido datetime not null, 
    constraint pk_aluno primary key (numero)
); 

alter table INSCRICAO add constraint fk_aluno foreign key (numero) references ALUNO(numero); 
alter table INSCRICAO add constraint fk_disciplina foreign key (codigo) references DISCIPLINA(codigo); 


-- Exercício 2: DROP TABLE ALUNO
-- ERRO: Error Code: 3730. Cannot drop table 'aluno' referenced by a foreign key constraint 'fk_aluno' on table 'inscricao'.
-- Não é possível eliminar tabela sem que eliminemos primeiro 
-- fk_aluno na tabela INSCRICAO

alter table INSCRICAO drop foreign key fk_aluno; 
drop table ALUNO; 

