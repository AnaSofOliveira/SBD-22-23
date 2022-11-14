USE `restaurantes`; 

-- ADD PRIMARY KEYS 
-- AREA GEOGRAFICA
ALTER TABLE `area_geografica` ADD CONSTRAINT pk_area_geografica PRIMARY KEY (`codigo`, `zona_postal`); 

-- RESTAURANTE
ALTER TABLE `restaurante` ADD CONSTRAINT pk_restaurante PRIMARY KEY (`codigo`, `area_geografica`); 
ALTER TABLE `restaurante` MODIFY `codigo` INT NOT NULL AUTO_INCREMENT;

-- MESA
ALTER TABLE `mesa` ADD CONSTRAINT pk_mesa PRIMARY KEY (`numero`, `codigo_restaurante`, `area_restaurante`);

-- CARACTERISTICA
ALTER TABLE `caracteristica` ADD CONSTRAINT pk_caracteristica PRIMARY KEY(`id`);
ALTER TABLE `caracteristica` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- RECURSO_MULTIMEDIA
ALTER TABLE `recurso_multimedia` ADD CONSTRAINT pk_recurso_multimedia PRIMARY KEY(`id`);
ALTER TABLE `recurso_multimedia` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- RECURSOS_RESTAURANTE
ALTER TABLE `recursos_restaurante` ADD CONSTRAINT pk_recursos_restaurante PRIMARY KEY(`codigo_restaurante`, `area_restaurante`, `id_recurso`);

-- HORARIO
ALTER TABLE `horario` ADD CONSTRAINT pk_horario PRIMARY KEY(`id`);
ALTER TABLE `horario` MODIFY `id` INT NOT NULL AUTO_INCREMENT;
ALTER TABLE `horario` ADD UNIQUE KEY un_horario (`dia_semana`, `hora_inicio`, `hora_fim`);

-- HORARIO_EMENTAS_RESTAURANTE
ALTER TABLE `horario_ementas_restaurante` ADD CONSTRAINT pk_horario_ementas_restaurante PRIMARY KEY(`codigo_restaurante`, `codigo_ementa`, `id_horario`);

-- EMENTA
ALTER TABLE `ementa` ADD CONSTRAINT pk_ementa PRIMARY KEY(`codigo`);
ALTER TABLE `ementa` MODIFY `codigo` INT NOT NULL AUTO_INCREMENT;

-- UTILIZADOR
ALTER TABLE `utilizador` ADD CONSTRAINT pk_utilizador PRIMARY KEY(`nif`);

-- CLIENTE
ALTER TABLE `cliente` ADD CONSTRAINT pk_cliente PRIMARY KEY(`numero`);
ALTER TABLE `cliente` MODIFY `numero` INT NOT NULL AUTO_INCREMENT;

-- FUNCIONARIO
ALTER TABLE `funcionario` ADD CONSTRAINT pk_funcionario PRIMARY KEY(`numero`, `tipo`, `codigo_restaurante`);
ALTER TABLE `funcionario` MODIFY `numero` INT NOT NULL AUTO_INCREMENT;

-- ITEM
ALTER TABLE `item` ADD CONSTRAINT pk_item PRIMARY KEY(`numero`);
ALTER TABLE `item` MODIFY `numero` INT NOT NULL AUTO_INCREMENT;

-- ITENS_EMENTA
ALTER TABLE `itens_ementa` ADD CONSTRAINT pk_itens_ementa PRIMARY KEY(`codigo_ementa`, `numero_item`);

-- RESERVA
ALTER TABLE `reserva` ADD CONSTRAINT pk_reserva PRIMARY KEY(`id`);
ALTER TABLE `reserva` MODIFY `id` INT NOT NULL AUTO_INCREMENT;

-- EMENTA_RESERVADA
ALTER TABLE `ementa_reservada` ADD CONSTRAINT pk_ementa_reservada PRIMARY KEY(`id_reserva`, `codigo_ementa`, `numero_item`);

-- CARACTERISTICAS_RESERVA
ALTER TABLE `caracteristicas_reserva` ADD CONSTRAINT pk_caracteristicas_reserva PRIMARY KEY(`id_reserva`, `id_caracteristica`);

-- ITENS_PREFERIDOS_CLIENTE
ALTER TABLE `itens_preferidos_cliente` ADD CONSTRAINT pk_itens_preferiados_cliente PRIMARY KEY(`numero_cliente`, `numero_item`);





-- ADD FOREIGN KEYS
-- RESTAURANTE
ALTER TABLE `restaurante`ADD CONSTRAINT fk_restaurante_area_geografica FOREIGN KEY (`area_geografica`) REFERENCES `area_geografica`(`codigo`);
-- MESA
ALTER TABLE `mesa` ADD CONSTRAINT fk_mesa_restaurante FOREIGN KEY(`codigo_restaurante`, `area_restaurante`) REFERENCES `restaurante`(`codigo`, `area_geografica`);

-- RECURSOS_RESTAURANTE
ALTER TABLE `recursos_restaurante` ADD CONSTRAINT fk_recursos_restaurante FOREIGN KEY(`codigo_restaurante`, `area_restaurante`) REFERENCES `restaurante`(`codigo`, `area_geografica`);

-- HORARIO_EMENTAS_RESTAURANTE
ALTER TABLE `horario_ementas_restaurante` ADD CONSTRAINT fk_horario_ementas_restaurante_restaurante FOREIGN KEY(`codigo_restaurante`) REFERENCES `restaurante`(`codigo`);
ALTER TABLE `horario_ementas_restaurante` ADD CONSTRAINT fk_horario_ementas_restaurante_ementa FOREIGN KEY(`codigo_ementa`) REFERENCES `ementa`(`codigo`);
ALTER TABLE `horario_ementas_restaurante` ADD CONSTRAINT fk_horario_ementas_restaurante_horario FOREIGN KEY(`id_horario`) REFERENCES `horario`(`id`);

-- CLIENTE
ALTER TABLE `cliente` ADD CONSTRAINT fk_cliente_utilizador FOREIGN KEY(`nif`) REFERENCES `utilizador`(`nif`);

-- 
ALTER TABLE `funcionario` ADD CONSTRAINT fk_funcionario_utilizador FOREIGN KEY(`nif`) REFERENCES `utilizador`(`nif`);
ALTER TABLE `funcionario` ADD CONSTRAINT fk_funcionario_restaurante FOREIGN KEY(`codigo_restaurante`) REFERENCES `restaurante`(`codigo`);

-- ITEM
ALTER TABLE `item` ADD CONSTRAINT fk_item_funcionario FOREIGN KEY(`numero_gerente`) REFERENCES `funcionario`(`numero`);

-- ITENS_EMENTA
ALTER TABLE `itens_ementa` ADD CONSTRAINT fk_itens_ementa_ementa FOREIGN KEY(`codigo_ementa`) REFERENCES `ementa`(`codigo`);
ALTER TABLE `itens_ementa` ADD CONSTRAINT fk_itens_ementa_item FOREIGN KEY(`numero_item`) REFERENCES `item`(`numero`);

-- RESERVA
ALTER TABLE `reserva` ADD CONSTRAINT fk_reserva_restaurante FOREIGN KEY(`codigo_restaurante`, `area_restaurante`) REFERENCES `restaurante`(`codigo`, `area_geografica`);
ALTER TABLE `reserva` ADD CONSTRAINT fk_reserva_cliente FOREIGN KEY(`numero_cliente`) REFERENCES `cliente`(`numero`);
ALTER TABLE `reserva` ADD CONSTRAINT fk_reserva_funcionario FOREIGN KEY(`numero_funcionario`) REFERENCES `funcionario`(`numero`);
ALTER TABLE `reserva` ADD CONSTRAINT fk_reserva_mesa FOREIGN KEY(`mesa`) REFERENCES `mesa`(`numero`);

-- EMENTA_RESERVADA
ALTER TABLE `ementa_reservada` ADD CONSTRAINT fk_ementa_reservada_reserva FOREIGN KEY(`id_reserva`) REFERENCES `reserva`(`id`);
ALTER TABLE `ementa_reservada` ADD CONSTRAINT fk_ementa_reservada_ementa FOREIGN KEY(`codigo_ementa`) REFERENCES `ementa`(`codigo`);
ALTER TABLE `ementa_reservada` ADD CONSTRAINT fk_ementa_reservada_item FOREIGN KEY(`numero_item`) REFERENCES `item`(`numero`);

-- CARACTERISTICAS_RESERVA
ALTER TABLE `caracteristicas_reserva` ADD CONSTRAINT fk_caracteristicas_reserva_reserva FOREIGN KEY(`id_reserva`) REFERENCES `reserva`(`id`);
ALTER TABLE `caracteristicas_reserva` ADD CONSTRAINT fk_caracteristicas_reserva_caracteristica FOREIGN KEY(`id_caracteristica`) REFERENCES `caracteristica`(`id`);

-- ITENS_PREFERIDOS_CLIENTE
ALTER TABLE `itens_preferidos_cliente` ADD CONSTRAINT fk_itens_preferidos_cliente_cliente FOREIGN KEY(`numero_cliente`) REFERENCES `cliente`(`numero`);
ALTER TABLE `itens_preferidos_cliente` ADD CONSTRAINT fk_itens_preferidos_cliente_item FOREIGN KEY(`numero_item`) REFERENCES `item`(`numero`);



