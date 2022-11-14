-- Inserir dados da tabela DISCIPLINA
insert into DISCIPLINA values ('SBD','Sistemas de Bases de Dados');
insert into DISCIPLINA values ('ICD','Infraestuturas Computacionais Distribuídos');
insert into DISCIPLINA values ('TI', 'Tecnologias de Informação');
insert into DISCIPLINA values ('FSO', 'Fundamentos de Sistemas Operativos');
insert into DISCIPLINA values ('SMI', 'Sistemas Multimédia para a Internet');


-- Inserir dados da tabela INSCRICAO
-- ERRO: Error Code: 1452. Cannot add or update a child row: a foreign key constraint fails (`aulapratica1`.`inscricao`, CONSTRAINT `fk_aluno` FOREIGN KEY (`numero`) REFERENCES `aluno` (`numero`))
insert into INSCRICAO (numero, ano, nota, codigo) values (1, 2022, NULL, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (2, 2021, 10.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (3, 2022, 15.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (4, 2020, 10.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (6, 2020, NULL, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (7, 2022, 18.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (8, 2021, 15.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (9, 2015, 13.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (10,2020, NULL, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (11,2022, 14.2, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (12,2021, 18.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (13,2019, 16.0, 'SBD');
insert into INSCRICAO (numero, ano, nota, codigo) values (14,2020, 14.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (15,2018, 15.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (16,2017, 11.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (18,2015, 11.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (19,2015, 13.1, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (20,2014, 16.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (21,2013, 17.0, 'ICD');
insert into INSCRICAO (numero, ano, nota, codigo) values (22,2014, 13.0, 'ICD');


-- Inserir dados da tabela ALUNO
insert into ALUNO values ('1','ABEL ALVES BOTELHO','m','1990-10-20 00:00:00');
insert into ALUNO values ('2','Abel Alves da Costa Pina','m','1991-5-4 00:00:00');
insert into ALUNO values ('3','ABILIO DOS SANTOS PINTO','m','1994-1-14 00:00:00');
insert into ALUNO values ('4','Abílio Pires dos Santos','m','1995-1-6 00:00:00');
insert into ALUNO values ('5','ACACIO CARDOSO DA ROCHA','m','1997-12-16 00:00:00');
insert into ALUNO values ('6','Acácio Cardoso do Nascimento','m','1997-2-1 00:00:00');
insert into ALUNO values ('7','Adalberto Luís Marques Rabaça','m','1996-12-27 00:00:00');
insert into ALUNO values ('8','ADALBERTO LUIS MARTINHO DE MELO','m','1996-12-15 00:00:00');
insert into ALUNO values ('9','ADAO DE ALMEIDA SILVARES','m','1994-2-28 00:00:00');
insert into ALUNO values ('10','Adao de Almeida Vasconcelos','m','1998-6-8 00:00:00');
insert into ALUNO values ('11','ADAO FINO DA COSTA','m','1995-9-30 00:00:00');
insert into ALUNO values ('12','Adélia Oliveira Pereira','f','1995-7-30 00:00:00');
insert into ALUNO values ('13','ADELIA MARIA VAZ PESTANA DIAS','f','1993-10-30 00:00:00');
insert into ALUNO values ('14','ADERITO AUGUSTO FERREIRINHA','m','1993-3-18 00:00:00');
insert into ALUNO values ('15','Adérito Augusto Figueira','m','1992-7-7 00:00:00');
insert into ALUNO values ('16','ZACARIAS MACHADO FERREIRA','m','1992-4-7 00:00:00');
insert into ALUNO values ('17','ZACARIAS MAGALHAES FERNANDES','m','1992-4-16 00:00:00');
insert into ALUNO values ('18','Zélia Maria Lima da Costa','f','1991-7-2 00:00:00');
insert into ALUNO values ('19','Zélia Maria Lopes Dias Moreira','f','1997-8-7 00:00:00');
insert into ALUNO values ('20','Álvaro Silva d’ Almeida','m','1998-9-7 00:00:00');
insert into ALUNO values ('21','António Fagundes Fraga','m','1999-11-7 00:00:00');
insert into ALUNO values ('22','Abreu Oliveira Antunes','m','1990-1-7 00:00:00');
