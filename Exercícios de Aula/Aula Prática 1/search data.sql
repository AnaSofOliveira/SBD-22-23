-- a)
select nome from ALUNO;

-- b)
select aluno.numero, aluno.nome, disciplina.designacao, inscricao.ano, inscricao.nota 
from disciplina 
	inner join (aluno 
		inner join inscricao 
        on aluno.numero = inscricao.numero) 
    on disciplina.codigo = inscricao.codigo;
    
select aluno.numero, nome, designacao, ano, nota
from aluno, disciplina, inscricao
where aluno.numero = inscricao.numero and disciplina.codigo=inscricao.codigo
order by numero, designacao;
    
-- c)
select designacao, nome 
from aluno, disciplina, inscricao 
where aluno.numero=inscricao.numero and disciplina.codigo=inscricao.codigo 
order by designacao, aluno.numero;

-- d) 
select aluno.numero, inscricao.codigo 
from aluno 
	left join inscricao 
    on aluno.numero = inscricao.numero;

-- e)
select avg(nota) as media from inscricao;

-- f)
-- 1ª listar disciplinas com alunos com nome zélia

select aluno.nome, inscricao.codigo
from inscricao
	inner join aluno
    on aluno.numero = inscricao.numero;
