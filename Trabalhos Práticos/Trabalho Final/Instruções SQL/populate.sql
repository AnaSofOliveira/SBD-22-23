USE `the_spoon`;

-- ADICIONAR AREAS GEOGRAFICAS
INSERT INTO area_geografica (codigoPostal, zonaPostal, freguesia, concelho, distrito) VALUES 
	(1700, 001, 'Lisboa', 'Lisboa', 'Lisboa'), (1700, 002, 'Lisboa', 'Lisboa', 'Lisboa'), 
    (1700, 003, 'Lisboa', 'Lisboa', 'Lisboa'), (2615, 001, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'),
    (2615, 002, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'), (2615, 003, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'),
    (1100, 001, 'Lisboa', 'Lisboa', 'Lisboa'), (1100, 002, 'Lisboa', 'Lisboa', 'Lisboa'); 
    
-- ADICIONAR MORADAS
insert into morada (codigoPostal, zonaPostal, designacao) values 
	(1700, 001, 'Rua de Entrecampos'), 
    (1100, 001, 'Rua dos Correeiros 204'), 
    (1100, 001, 'Paça da Figueira 17'), 
    (1700, 001,'Campo Grande 35B'), 
    (2615, 002, 'Rua da Juventude'), 
    (2615, 002, 'Estrada da Alfarrobeira'), 
    (2615, 002, 'Rua Josué Martins Romão 4'); 
  
-- ADICIONAR RESTAURANTES
INSERT INTO restaurante (nome, email, telefone, codigoMorada, codigoArea, zonaArea) VALUES
	('Pizza & Co', 'pizzaria@gmail.com', 911351759, 1, 1700, 001), 
    ('Elevador', 'elevador@gmail.com', 911351759, 2, 1100, 001), 
    ('Figus', 'figus@gmail.com', 911351759, 3, 1100, 001), 
    ('Taberna Londrina', 'tabernalondrina@tabernalondrina.com', 210912193, 4, 1700, 001), 
    ('Carvão', 'carvao@gmail.com', 934377871, 7, 2615, 002), 
    ('Mar by Nunes', 'pizzaria@gmail.com', 210730940, 6, 2615, 002), 
    ('Yasu Sushi', 'yasy@sushi.com', 219593295, 5,2615, 002);

-- ADICIONAR RECURSOS MULTIMÉDIA
	-- Recursos Restaurante "Elevador"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('elevador', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/elevador.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('ameijoas', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/ameijoas.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('bife novilho', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/bife_novilho.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('bolo chocolate', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/bolo_de_chocolate.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('fruta epoca', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/fruta_da_epoca.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('caldeirada de marisco', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/caldeirada_de_marisco.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('queijo', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/queijo.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('salmão', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/salmao.jpg'));

	-- Recursos Restaurante "Figus"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('figus', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/figus.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('ostras', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/ostras.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('peixe galo com rizzotto', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/peixe_galo_com_rizotto.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('peixinhos da horta', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/peixinhos_da_horta.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('polvo', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/polvo.jpg'));

	-- Recursos Restaurante "Pizza & Co"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('pizza and co', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/pizza_co.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('camponesa', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/camponesa.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('manjericão', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/manjericao.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('morango e chocolate', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/morango-e-chocolate.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('peperoni', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/peperoni.jpg'));

	-- Recursos Restaurante "Taberna Londrina"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('taberna londrina', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/taberna_londrina.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('cerveja', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/cerveja.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('cheesecake', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/cheesecake.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('folhados de alheira', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/folhados_alheira.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('francesinha', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/francesinha.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('hamburguer', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/hamburguer.jpg'));

	-- Recursos Restaurante "Carvão"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('carvão', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/carvao.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('bacalhau', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/bacalhau.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('perna de frango estufada', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/perna-de-frango-estufada.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('picanha', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/picanha.jpg'));

	-- Recursos Restaurante "Mar by Nunes"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('mar by nunes', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/mar_by_nunes.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('maminha', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/maminha.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('mariscada', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/mariscada.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('ostras', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/ostras.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('perca', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/perca.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('sapateira', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/sapateira.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('sardinhas', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/sardinhas.jpg'));

	-- Recursos Restaurante "Yasu Sushi"
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('yasu', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/yasu.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('lula', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/lula.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('sushi', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/sushi.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('variado', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/variado.jpg'));

	-- Recursos todos os bares - Bebidas
    INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('água', 'jpg', LOAD_FILE('../Uploads/restaurantes/agua.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('cerveja', 'jpg', LOAD_FILE('../Uploads/restaurantes/cerveja.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('ice_tea', 'jpg', LOAD_FILE('../Uploads/restaurantes/ice_tea.jpg'));
	INSERT INTO recurso_multimedia (nome, extensao, conteudo) VALUES ('limonada', 'jpg', LOAD_FILE('../Uploads/restaurantes/limonada.jpg'));

-- ADICIONAR RECURSOS RESTAURANTE
INSERT INTO recursos_restaurante (idRecurso, codigoRestaurante) VALUES 	
	(14, 1), (1, 2), (9, 3), 
    (19, 4), (25, 5), (29, 6),
    (36, 7);
    
-- ADICIONAR EMENTAS
insert into ementa (codigoRestaurante, designacao) values 
	(1, "Almoço"), (1, "Jantar"), 
	(2, "Almoço & Jantar"), 
	(3, "Almoço & Jantar"), 
	(4, "Almoço & Jantar"),
	(5, "Almoço"), (5, "Jantar"), 
	(6, "Almoço"), (6, "Jantar"), (6, "Almoço & Jantar"), 
	(7, "Almoço"), (7, "Jantar");

-- ADICIONAR HORARIO
insert into horario (horaInicio, horaFim, diaSemana, idEmenta, codigoRestaurante) values 
('10:00','15:00', 'Seg',1,1), ('10:00','15:00', 'Ter',1,1), ('10:00','15:00', 'Qua',1,1), ('10:00','15:00', 'Qui',1,1), ('10:00','15:00', 'Sex',1,1), 
('10:00','15:00', 'Sab',1,1), ('18:00','22:00', 'Seg',2,1), ('18:00','22:00', 'Ter',2,1), ('18:00','22:00', 'Qua',2,1), ('18:00','22:00', 'Qui',2,1), 
('18:00','22:00', 'Sex',2,1), ('18:00','22:00', 'Sab',2,1), ('10:00','19:00', 'Seg',3,2), ('10:00','19:00', 'Ter',3,2), ('10:00','19:00', 'Qua',3,2), 
('10:00','19:00', 'Qui',3,2), ('10:00','19:00', 'Sex',3,2), ('10:00','19:00', 'Ter',4,3), ('10:00','19:00', 'Qua',4,3), ('10:00','19:00', 'Qui',4,3), 
('10:00','19:00', 'Sex',4,3), ('10:00','19:00', 'Sab',4,3), ('10:00','19:00', 'Qua',5,4), ('10:00','19:00', 'Qui',5,4), ('10:00','19:00', 'Sex',5,4), 
('10:00','19:00', 'Sab',5,4), ('10:00','19:00', 'Dom',5,4), ('10:00','15:00', 'Seg',6,5), ('10:00','15:00', 'Ter',6,5), ('10:00','15:00', 'Qua',6,5), 
('10:00','15:00', 'Qui',6,5), ('10:00','15:00', 'Sex',6,5), ('10:00','15:00', 'Sab',6,5), ('18:00','22:00', 'Seg',7,5), ('18:00','22:00', 'Ter',7,5), 
('18:00','22:00', 'Qua',7,5), ('18:00','22:00', 'Qui',7,5), ('18:00','22:00', 'Sex',7,5), ('18:00','22:00', 'Sab',7,5), ('10:00','15:00', 'Seg',8,6), 
('18:00','22:00', 'Seg',9,6), ('10:00','19:00', 'Ter',10,6), ('10:00','19:00', 'Qua',10,6), ('10:00','19:00', 'Qui',10,6), ('10:00','19:00', 'Sex',10,6), 
('10:00','15:00', 'Sab',8,6), ('18:00','22:00', 'Sab',9,6), ('10:00','15:00', 'Seg',11,7), ('10:00','15:00', 'Ter',11,7), ('10:00','15:00', 'Qua',11,7), 
('10:00','15:00', 'Qui',11,7), ('10:00','15:00', 'Sex',11,7), ('10:00','15:00', 'Sab',11,7), ('18:00','22:00', 'Seg',12,7), ('18:00','22:00', 'Ter',12,7), 
('18:00','22:00', 'Qua',12,7), ('18:00','22:00', 'Qui',12,7), ('18:00','22:00', 'Sab',12,7);    
    
-- ADICIONAR ITENS
	-- Itens Restaurante "Pizza & Co" 
	insert into item (designacao, descricao, tipo, idRecurso) values 
		('Pizza Camponesa', 'Pizza Camponesa', 'prato', 15),
		('Pizza Manjericão', 'Pizza Manjericão', 'prato', 16), 
		('Pizza Morango e Chocolate', 'Pizza Morango e Chocolate', 'sobremesa', 17), 
		('Pizza Peperoni', 'Pizza Peperoni', 'prato', 18), 
		('Água', 'Água da fonte', 'bebida', 40), 
		('Limonada', 'Limonada', 'bebida', 43);


	-- Itens Restaurante "Elevador"
	insert into item (designacao, descricao, tipo, idRecurso) values 
		('Ameijoas', 'Ameijoas', 'prato', 2),
		('Bife Novilho', 'Bife Novilho', 'prato', 3), 
		('Bolo Chocolate', 'Bolo Chocolate', 'sobremesa', 4), 
		('Fruta Época', 'Fruta Época', 'sobremesa', 5),
		('Caldeirada de Marisco', 'Caldeirada de Marisco', 'prato', 6), 
		('Queijo', 'Queijo', 'entrada', 7), 
		('Salmão', 'Salmão', 'prato', 8),
		('Água', 'Água da fonte', 'bebida', 40), 
        ('Limonada', 'Limonada', 'bebida', 43);
        
	-- Itens Restaurante "Figus" 
	INSERT INTO item (designacao, descricao, tipo, idRecurso) VALUES 
		('Ostras', 'Ostras', 'prato', 10),
		('Peixe Galo', 'Peixe Galo com Rizzotto', 'prato', 11), 
		('Peixinhos da Horta', 'Peixinhos da Horta', 'entrada', 12), 
		('Polvo', 'Polvo', 'prato', 13),
		('Água', 'Água da fonte', 'bebida', 40), 
		('Limonada', 'Limonada', 'bebida', 43), 
		('Cerveja', 'Cerveja', 'bebida', 41), 
		('Ice Tea', 'Ice Tea', 'bebida', 42);   
		
	-- Itens Restaurante "Taberna Londrina" 
	INSERT INTO item (designacao, descricao, tipo, idRecurso) VALUES 
		('Cheesecake', 'Cheesecake', 'sobremesa', 20),
		('Folhados de Alheira', 'Folhados de Alheira', 'entrada', 22), 
		('Francesinha', 'Francesinha', 'prato', 23), 
		('Hamburguer', 'Hamburguer', 'prato', 24),
		('Água', 'Água da fonte', 'bebida', 40),
		('Cerveja', 'Cerveja', 'bebida', 20), 
		('Ice Tea', 'Ice Tea', 'bebida', 42),
		('Limonada', 'Limonada', 'bebida', 43);   
		
	-- Itens Restaurante "Carvão" 
	INSERT INTO item (designacao, descricao, tipo, idRecurso) VALUES 
		('Bacalhau', 'Bacalhau', 'prato', 26),
		('Perna de Frango', 'Perna de Frango Estufada', 'prato', 27), 
		('Picanha', 'Picanha', 'prato', 25),
		('Água', 'Água da fonte', 'bebida', 40),
		('Ice Tea', 'Ice Tea', 'bebida', 42);
		
	-- Itens Restaurante "Mar by Nunes" 
	INSERT INTO item (designacao, descricao, tipo, idRecurso) VALUES 
		('Maminha', 'Maminha', 'prato', 30),
		('Mariscada', 'Mariscada de Peixe', 'prato', 31), 
		('Ostras', 'Ostras', 'entrada', 32),
		('Perca', 'Perca', 'prato', 33),
		('Sapateira', 'Sapateira', 'prato', 34),
		('Sardinhas', 'Sardinhas', 'prato', 35),
		('Água', 'Água da fonte', 'bebida', 40),
		('Cerveja', 'Cerveja', 'bebida', 20), 
		('Limonada', 'Limonada', 'bebida', 43);     

	-- Itens Restaurante "Yasu" 
	INSERT INTO item (designacao, descricao, tipo, idRecurso) VALUES 
		('Lula', 'Lula', 'prato', 37),
		('Sushi', 'Sushi', 'prato', 38), 
		('Sushi Variado', 'Sushi Variado', 'prato', 39),
		('Cerveja', 'Cerveja', 'bebida', 20), 
		('Limonada', 'Limonada', 'bebida', 43); 

-- ADICIONAR ITENS EMENTA
INSERT INTO item_ementa VALUES 
	(35,6,5,2.5), (36,6,5,2.5), (32,6,5,10), (33,6,5,10), (34,7,5,15), (7,3,2,13), (8,3,2,13), (9,3,2,2.5), (10,3,2,2.5),
	(11,3,2,13), (13,3,2,13), (14,3,2,3), (15,3,2,3), (12,3,2,4.5), (16,4,3,13), (17,4,3,13), (19,4,3,13), (20,4,3,3),
	(21,4,3,3), (22,4,3,3), (23,4,3,3), (18,4,3,4.5), (43,8,6,2.5), (44,8,6,2.5), (45,8,6,2.5), (37,8,6,10), (38,8,6,10),
	(39,8,6,4), (40,9,6,15), (41,9,6,15), (42,9,6,15), (1,1,1,10), (2,1,1,10), (3,2,1,3), (4,2,1,15), (5,1,1,2.5),
	(6,1,1,2.5), (24,5,4,2.5), (26,5,4,13), (27,5,4,13), (28,5,4,3), (29,5,4,3), (30,5,4,3), (31,5,4,3), (25,5,4,4.5),
	(49,11,7,2.5), (50,11,7,2.5), (46,11,7,10), (47,11,7,10), (48,12,7,15);
    

