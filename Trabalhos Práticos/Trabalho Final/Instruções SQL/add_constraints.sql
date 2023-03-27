USE `the_spoon`;

-- ADD PRIMARY KEYS 
-- AREA GEOGRAFICA
alter table area_geografica add constraint pk_area_geografica primary key(codigoPostal, zonaPostal);

-- MORADA
alter table morada add constraint pk_morada primary key(codigo, codigoPostal, zonaPostal); 
ALTER TABLE morada MODIFY codigo INT NOT NULL AUTO_INCREMENT;

-- RECURSO_MULTIMEDIA
alter table `recurso_multimedia` add constraint pk_recurso primary key(id);
ALTER TABLE `recurso_multimedia` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- RESTAURANTE
alter table restaurante add constraint pk_restaurante primary key(codigo); 
ALTER TABLE `restaurante` MODIFY `codigo` INT NOT NULL AUTO_INCREMENT;

-- RECURSOS_MULTIMEDIA_RESTAURANTE
alter table recursos_restaurante add constraint pk_recursos_restaurante primary key (idRecurso, codigoRestaurante);

-- EMENTA
alter table ementa add constraint pk_ementa primary key (id, codigoRestaurante); 
ALTER TABLE `ementa` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- HORARIO
alter table horario add constraint pk_horario primary key(horaInicio, horaFim, diaSemana, idEmenta, codigoRestaurante);

-- ITEM
alter table item add constraint pk_item primary key (id); 
ALTER TABLE `item` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- ITEM_EMENTA
alter table item_ementa add constraint pk_item_ementa primary key (idItem, idEmenta, codigoRestaurante);

-- MESA
alter table mesa add constraint pk_mesa primary key (numero, codigoRestaurante);
ALTER TABLE mesa MODIFY numero INT NOT NULL AUTO_INCREMENT;

-- CARACTERISTICA
alter table caracteristica add constraint pk_caracteristica primary key(numero); 
ALTER TABLE caracteristica MODIFY numero INT NOT NULL AUTO_INCREMENT;

-- CARACTERISTICAS_MESA
alter table caracteristicas_mesa add constraint pk_caracteristicas_mesa primary key(numeroCaracteristica, numeroMesa, codigoRestaurante);

-- UTILIZADOR
alter table utilizador add constraint pk_utilizador primary key (nif); 

-- CLIENTE
alter table cliente add constraint pk_cliente primary key(numero); 
alter table cliente modify numero int not null auto_increment;

-- FUNCIONARIO
alter table funcionario add constraint pk_funcionario primary key(numero); 
alter table funcionario modify numero int not null auto_increment; 

-- RESERVA
alter table reserva add constraint pk_reserva primary key(numero, codigoRestaurante);
alter table reserva modify numero int not null auto_increment; 

-- CARACTERISTICAS_RESERVA
alter table caracteristicas_reserva add constraint pk_caracteristicasReserva primary key(numeroReserva, codigoRestaurante, numeroCaracteristica); 

-- ITEM_RESERVA
alter table item_reserva add constraint pk_itemReserva primary key(numeroReserva, codigoRestaurante, idItem);

-- RESERVAS_ATRIBUIDAS
alter table reservas_atribuidas add constraint pk_reservasAtribuidas primary key(numeroReserva, numeroFuncionario); 

-- ####################################################################################################################################

-- ADD FOREIGN KEYS
-- MORADA
alter table morada add constraint fk_morada_areageografica foreign key (codigoPostal, zonaPostal) references area_geografica(codigoPostal, zonaPostal);

-- RESTAURANTE
alter table restaurante add constraint fk_restaurante_morada foreign key(codigoMorada, codigoArea, zonaArea) references morada(codigo, codigoPostal, zonaPostal); 

-- RECURSOS_MULTIMEDIA_RESTAURANTE
alter table recursos_restaurante add constraint fk_recursos_recurso foreign key (idRecurso) references recurso_multimedia(id);
alter table recursos_restaurante add constraint fk_recursos_restaurante foreign key (codigoRestaurante) references restaurante(codigo);

-- EMENTA
alter table ementa add constraint fk_ementa_restaurante foreign key (codigoRestaurante) references restaurante(codigo);

-- HORARIO
alter table horario add constraint fk_horario_ementa foreign key (idEmenta) references ementa(id); 
alter table horario add constraint fk_horario_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 

-- ITEM
alter table item add constraint fk_item_recurso foreign key(idRecurso) references recurso_multimedia(id);

-- ITEM_EMENTA
alter table item_ementa add constraint fk_itemEmenta_item foreign key (idItem) references item(id); 
alter table item_ementa add constraint fk_itemEmenta_ementa foreign key (idEmenta) references ementa(id); 
alter table item_ementa add constraint fk_itemEmenta_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 

-- MESA
alter table mesa add constraint fk_mesa_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 

-- CARACTERISTICAS_MESA
alter table caracteristicas_mesa add constraint fk_caracteristicasMesa_caracteristica foreign key(numeroCaracteristica) references caracteristica(numero); 
alter table caracteristicas_mesa add constraint fk_caracteristicasMesa_mesa foreign key(numeroMesa) references mesa(numero); 
alter table caracteristicas_mesa add constraint fk_caracteristicasMesa_restaurante foreign key(codigoRestaurante) references restaurante(codigo); 

-- CLIENTE
alter table cliente add constraint fk_cliente_utilizador foreign key(nif) references utilizador(nif); 
alter table cliente add constraint fk_cliente_morada foreign key(codigoMorada, codigoArea, zonaArea) references morada(codigo, codigoPostal, zonaPostal);

-- FUNCIONARIO
alter table funcionario add constraint fk_funcionario_utilizador foreign key(nif) references utilizador(nif); 
alter table funcionario add constraint fk_funcionario_chefe foreign key(chefe) references funcionario(numero); 
alter table funcionario add constraint fk_funcionario_restaurante foreign key(codigoRestaurante) references restaurante(codigo); 

-- RESERVA
alter table reserva add constraint fk_reserva_restaurante foreign key(codigoRestaurante) references restaurante(codigo);
alter table reserva add constraint fk_reserva_cliente foreign key(numeroCliente) references cliente(numero);

-- CARACTERISTICAS_RESERVA
alter table caracteristicas_reserva add constraint fk_caracteristicasReserva_reserva foreign key (numeroReserva) references reserva(numero); 
alter table caracteristicas_reserva add constraint fk_caracteristicasReserva_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 
alter table caracteristicas_reserva add constraint fk_caracteristicasReserva_caracteristica foreign key (numeroCaracteristica) references caracteristica(numero); 

-- ITEM_RESERVA
alter table item_reserva add constraint fk_itemReserva_reserva foreign key(numeroReserva) references reserva(numero); 
alter table item_reserva add constraint fk_itemReserva_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 
alter table item_reserva add constraint fk_itemReserva_item foreign key(idItem) references item(id);  

-- RESERVAS_ATRIBUIDAS
alter table reservas_atribuidas add constraint fk_reservasAtribuidas_reserva foreign key(numeroReserva) references reserva(numero); 
alter table reservas_atribuidas add constraint fk_reservasAtribuidas_restaurante foreign key (codigoRestaurante) references restaurante(codigo); 
alter table reservas_atribuidas add constraint fk_reservasAtribuidas_mesa foreign key(numeroMesa) references mesa(numero); 
alter table reservas_atribuidas add constraint fk_reservasAtribuidas_funcionario foreign key(numeroFuncionario) references funcionario(numero); 