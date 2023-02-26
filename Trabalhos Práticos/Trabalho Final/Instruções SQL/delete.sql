USE `the_spoon`;

-- DROP FOREIGN KEYS
-- RESERVAS_ATRIBUIDAS
ALTER TABLE reservas_atribuidas DROP FOREIGN KEY fk_reservasAtribuidas_reserva;
ALTER TABLE reservas_atribuidas DROP FOREIGN KEY fk_reservasAtribuidas_restaurante;
ALTER TABLE reservas_atribuidas DROP FOREIGN KEY fk_reservasAtribuidas_mesa;
ALTER TABLE reservas_atribuidas DROP FOREIGN KEY fk_reservasAtribuidas_funcionario;

-- ITEM_RESERVA
ALTER TABLE item_reserva DROP FOREIGN KEY fk_itemReserva_reserva;
ALTER TABLE item_reserva DROP FOREIGN KEY fk_itemReserva_restaurante;
ALTER TABLE item_reserva DROP FOREIGN KEY fk_itemReserva_item;

-- CARACTERISTICAS_RESERVA
ALTER TABLE caracteristicas_reserva DROP FOREIGN KEY fk_caracteristicasReserva_reserva;
ALTER TABLE caracteristicas_reserva DROP FOREIGN KEY fk_caracteristicasReserva_restaurante;
ALTER TABLE caracteristicas_reserva DROP FOREIGN KEY fk_caracteristicasReserva_caracteristica;

-- RESERVA
ALTER TABLE reserva DROP FOREIGN KEY fk_reserva_restaurante;
ALTER TABLE reserva DROP FOREIGN KEY fk_reserva_cliente;

-- FUNCIONARIO
ALTER TABLE funcionario DROP FOREIGN KEY fk_funcionario_utilizador;
ALTER TABLE funcionario DROP FOREIGN KEY fk_funcionario_chefe;
ALTER TABLE funcionario DROP FOREIGN KEY fk_funcionario_restaurante;

-- CLIENTE
ALTER TABLE cliente DROP FOREIGN KEY fk_cliente_utilizador;
ALTER TABLE cliente DROP FOREIGN KEY fk_cliente_morada;

-- CARACTERISTICAS_MESA
ALTER TABLE caracteristicas_mesa DROP FOREIGN KEY fk_caracteristicasMesa_caracteristica;
ALTER TABLE caracteristicas_mesa DROP FOREIGN KEY fk_caracteristicasMesa_mesa;
ALTER TABLE caracteristicas_mesa DROP FOREIGN KEY fk_caracteristicasMesa_restaurante;

-- MESA
ALTER TABLE mesa DROP FOREIGN KEY fk_mesa_restaurante;

-- ITEM_EMENTA
ALTER TABLE item_ementa DROP FOREIGN KEY fk_itemEmenta_item;
ALTER TABLE item_ementa DROP FOREIGN KEY fk_itemEmenta_ementa;
ALTER TABLE item_ementa DROP FOREIGN KEY fk_itemEmenta_restaurante;

-- HORARIO
ALTER TABLE horario DROP FOREIGN KEY fk_horario_ementa;
ALTER TABLE horario DROP FOREIGN KEY fk_horario_restaurante;

-- EMENTA
ALTER TABLE ementa DROP FOREIGN KEY fk_ementa_restaurante;

-- RECURSOS_MULTIMEDIA_RESTAURANTE
ALTER TABLE recursos_restaurante DROP FOREIGN KEY fk_recursos_recurso;
ALTER TABLE recursos_restaurante DROP FOREIGN KEY fk_recursos_restaurante;

-- RESTAURANTE
ALTER TABLE restaurante DROP FOREIGN KEY fk_restaurante_morada;

-- MORADA
ALTER TABLE morada DROP FOREIGN KEY fk_morada_areageografica;


-- DROP TABLES
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
drop table item_ementa;
drop table item;
drop table horario;
drop table ementa;
drop table recursos_restaurante; 
drop table restaurante;
drop table recurso_multimedia;
drop table morada; 
drop table area_geografica;

-- DROP DATABASE
drop database the_spoon;