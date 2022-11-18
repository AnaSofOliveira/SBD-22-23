USE `restaurantes`; 

-- DROP FOREIGN KEYS
ALTER TABLE `restaurante` DROP FOREIGN KEY fk_restaurante_area_geografica;
ALTER TABLE `mesa` DROP FOREIGN KEY fk_mesa_restaurante;

ALTER TABLE `recursos_restaurante` DROP FOREIGN KEY fk_recursos_restaurante;

ALTER TABLE `horario_ementas_restaurante` DROP FOREIGN KEY fk_horario_ementas_restaurante_restaurante; 
ALTER TABLE `horario_ementas_restaurante` DROP FOREIGN KEY fk_horario_ementas_restaurante_ementa;  
ALTER TABLE `horario_ementas_restaurante` DROP FOREIGN KEY fk_horario_ementas_restaurante_horario; 

ALTER TABLE `cliente` DROP FOREIGN KEY fk_cliente_utilizador;

ALTER TABLE `funcionario` DROP FOREIGN KEY fk_funcionario_utilizador;
ALTER TABLE `funcionario` DROP FOREIGN KEY fk_funcionario_restaurante;

ALTER TABLE `item` DROP FOREIGN KEY fk_item_funcionario;

ALTER TABLE `itens_ementa` DROP FOREIGN KEY fk_itens_ementa_ementa;
ALTER TABLE `itens_ementa` DROP FOREIGN KEY fk_itens_ementa_item;

ALTER TABLE `reserva` DROP FOREIGN KEY fk_reserva_restaurante;
ALTER TABLE `reserva` DROP FOREIGN KEY fk_reserva_cliente;
ALTER TABLE `reserva` DROP FOREIGN KEY fk_reserva_funcionario;
ALTER TABLE `reserva` DROP FOREIGN KEY fk_reserva_mesa;

ALTER TABLE `ementa_reservada` DROP FOREIGN KEY fk_ementa_reservada_reserva;
ALTER TABLE `ementa_reservada` DROP FOREIGN KEY fk_ementa_reservada_ementa;
ALTER TABLE `ementa_reservada` DROP FOREIGN KEY fk_ementa_reservada_item;

ALTER TABLE `caracteristicas_reserva` DROP FOREIGN KEY fk_caracteristicas_reserva_reserva;
ALTER TABLE `caracteristicas_reserva` DROP FOREIGN KEY fk_caracteristicas_reserva_caracteristica;

ALTER TABLE `itens_preferidos_cliente` DROP FOREIGN KEY fk_itens_preferidos_cliente_cliente;
ALTER TABLE `itens_preferidos_cliente` DROP FOREIGN KEY fk_itens_preferidos_cliente_item;


-- DROP TABLES
DROP TABLE `area_geografica`; 
DROP TABLE `restaurante`; 
DROP TABLE `mesa`; 
DROP TABLE `caracteristica`; 
DROP TABLE `recurso_multimedia`; 
DROP TABLE `recursos_restaurante`; 
DROP TABLE `horario`; 
DROP TABLE `ementa`; 
DROP TABLE `utilizador`; 
DROP TABLE `cliente`; 
DROP TABLE `funcionario`; 
DROP TABLE `item`; 
DROP TABLE `itens_ementa`; 
DROP TABLE `reserva`; 
DROP TABLE `ementa_reservada`; 
DROP TABLE `caracteristicas_reserva`; 
DROP TABLE `itens_preferidos_cliente`; 
DROP TABLE `horario_ementas_restaurante`;


-- DROP DATABASE
DROP DATABASE `restaurantes`; 