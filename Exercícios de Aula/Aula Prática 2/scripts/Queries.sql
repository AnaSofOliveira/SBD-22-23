-- 1. Nome dos alunos inscritos em 2022
SELECT a.nome, i.codigo
FROM `aluno` as a 
	INNER JOIN `inscricao` as i on (a.numero = i.numero) where (i.ano = 2022);

-- 2. Nome dos alunos e dados dos seus veículos se existirem    
SELECT a.nome, x.marca, x.modelo, x.matricula
FROM `aluno` as a
	LEFT JOIN (
		SELECT av.aluno, v.marca, v.modelo, v.matricula
		FROM `aluno_veiculo` as av
			LEFT JOIN `veiculo` as v on (av.veiculo = v.matricula)
    ) as x ON (a.numero = x.aluno);
    
-- 3. Alunos inscritos em TI 2021
SELECT a.nome, i.codigo
FROM `aluno` as a 
	INNER JOIN `inscricao` as i on (a.numero = i.numero) where (i.ano = 2021 and i.codigo='TI');
    
    
-- 4. Para o aluno 'Manel Jaquim' listar as disciplinas com notas lançadas, ano, disciplina e nota
SELECT a2.nome, i.ano, i.codigo, i.nota
FROM `inscricao` as i
	INNER JOIN (
		SELECT a.numero, a.nome
		FROM `aluno` as a 
			WHERE (a.nome = 'Manel Jaquim')
    ) as a2 on (a2.numero = i.numero and nota is not null);
    
 
 -- 5. Número de disciplinas em que cada aluno esta inscrito
 SELECT a.nome, insc2.num
 FROM `aluno` as a 
	INNER JOIN (
		SELECT i.numero, COUNT(i.codigo) as num
			FROM `inscricao` as i
			where (i.ano = 2022)
			group by i.numero
    ) as insc2 ON (insc2.numero = a.numero);
 
 
-- 6. Número de disciplinas em que cada aluno esta inscrito por ano
select a.numero, a.nome, i.ano, i.codigo
from aluno a
		inner join inscricao i on a.numero = i.numero
        inner join inscricao i2 on i.ano = i2.ano and i.codigo = i2.codigo
order by a.numero, a.nome, i.ano, i.codigo; 










-- 12. Listar o nome dos alunos e as disciplinas por ano indicando quantos colegas têm na mesma disciplina
SELECT a.numero, a.nome, i.codigo, i.ano, count(*)
FROM aluno a
	inner join inscricao i on a.numero = i.numero
    inner join inscricao iColegas on a.numero <> iColegas.numero and i.codigo = iColegas.codigo and i.ano = iColegas.ano
group by a.numero, a.nome, i.codigo, i.ano
order by a.numero;


-- 13. lista de alunos cuja nota na disciplina é inferior à média nessa disciplina desse ano
-- Versão 1 - Sem imprimir média
select a.numero, a.nome, i.codigo, i.ano, i.nota
from aluno as a
	inner join inscricao as i on a.numero = i.numero
where i.nota <(
	select avg(inotas.nota)
    from inscricao as inotas
    where inotas.ano = i.ano and inotas.codigo = i.codigo
    group by inotas.codigo, inotas.ano
);

-- Versão 2 - A imprimir a média
/*select a.numero, a.nome, i.codigo, i.ano, i.nota, 
from aluno as a
	inner join inscricao as i on a.numero = i.numero
    inner join (
		select codigo, ano, avg(nota) as media
        from inscricao
        group by codigo, ano
    ) medias in 
where i.nota <(
	select avg(inotas.nota)
    from inscricao as inotas
    where inotas.ano = i.ano and inotas.codigo = i.codigo
    group by inotas.codigo, inotas.ano
);*/


-- 14. Listar alunos em disciplinas por ano que tenham 3 ou mais alunos
select a.numero, a.nome, i.codigo, i.ano, i.nota
from aluno a 
	inner join inscricao i on a.numero = i.numero
where (i.codigo, i.ano) in (
	select inInsc.codigo, inInsc.codigo
    from inscricao inInsc
    where inInsc.codigo = i.codigo and inInsc.ano = i.ano
    group by inInsc.codigo, inInsc.ano
    having count(*) >= 3
)
order by i.ano asc;




