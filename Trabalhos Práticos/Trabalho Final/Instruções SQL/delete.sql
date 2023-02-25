USE `the_spoon`;

alter table morada drop foreign key fk_areageografica;
alter table morada drop primary key; 

alter table area_geografica drop primary key; 




drop table reservas_atribuidas;
drop table item_reserva;
drop table caracteristicas_reserva;
drop table reserva;
drop table funcionario;
drop table cliente;
drop table utilizador;
drop table caracteristicas_mesa;
drop table caracteristica;
drop table mesa; 
drop table recurso_item;
drop table item_ementa;
drop table item;
drop table horario;
drop table ementa;
drop table recursos_restaurante; 
drop table restaurante;
drop table recurso_multimedia;
drop table morada; 
drop table area_geografica;