-- Inserir a inscrição na disciplica de SBD
insert into ALUNO values ('39275','Ana Sofia Preto Oliveira','f','1994-03-11 00:00:00');
insert into INSCRICAO values('39275', 'SBD', '2022', null);

-- DELETE FROM ALUNO:
-- ERRO: Error Code: 1175. You are using safe update mode and you tried to update a table without a WHERE that uses a KEY column.  To disable safe mode, toggle the option in Preferences -> SQL Editor and reconnect.
-- Podemos adicionar WHERE CAUSE | Desativar segurança
delete from aluno; 


-- Lançar nota SBD no ano corrente
update inscricao set nota=15 where numero=39275 and codigo='SBD';


-- Permitir que o aluno se inscreva à mesma disciplina noutros anos
-- Error Code: 1062. Duplicate entry '39275-SBD' for key 'inscricao.PRIMARY'
insert into INSCRICAO values('39275', 'SBD', '2021', null);

-- Para permitir a inscrição do aluno em mais anos é preciso alterar 
-- a unicidade da entidade DISCIPLINA para que um aluno em cada inscrição 
-- se possa inscrever em zero ou mais disciplinas

-- 1º Remover foreign key para numero do aluno na tabela inscriçao
alter table INSCRICAO drop foreign key fk_aluno; 

-- 2º Drop primary key (numero, codigo)
alter table INSCRICAO drop primary key; 

-- 3º Adicionar primary key como sendo (numero, codigo, ano)
alter table INSCRICAO add constraint pk_inscricao primary key (numero, codigo, ano);

-- 4º Adicionar foreign keys para numero do aluno da tabela ALUNO 
alter table INSCRICAO add constraint fk_aluno foreign key (numero) references ALUNO(numero); 

-- Agora já é possivel corre instrução abaixo
insert into INSCRICAO values('39275', 'SBD', '2021', null);

select * from INSCRICAO;