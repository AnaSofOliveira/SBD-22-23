use restaurantes;

-- Listar restaurantes
SELECT distinct r.nome
from restaurante as r; 

-- Listar áreas dos restaurantes
select r.nome, ag.distrito, ag.concelho, ag.freguesia, ag.codigo, ag.zona_postal
from restaurante r
	inner join area_geografica as ag on r.area_geografica = ag.codigo
    group by r.nome, ag.distrito, ag.concelho, ag.freguesia, ag.codigo; 
    



select *
from horario_ementas_restaurante;

select r.nome, her.codigo_ementa, her.id_horario
from restaurante r
	inner join horario_ementas_restaurante her on r.codigo = her.codigo_restaurante;
    

select h.id, h.dia_semana, h.hora_inicio, h.hora_fim
from horario h
	right join horario_ementas_restaurante her on h.id = her.id_horario;

use restaurantes;

select e.codigo, e.designacao, ie.numero_item, ie.preco
from ementa e
	left join itens_ementa ie on (e.codigo = ie.codigo_ementa); 

select * from ementa;


























