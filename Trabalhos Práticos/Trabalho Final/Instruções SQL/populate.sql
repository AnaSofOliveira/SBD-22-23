USE `the_spoon`;

-- ADICIONAR AREAS GEOGRAFICAS
INSERT INTO area_geografica (codigoPostal, zonaPostal, freguesia, concelho, distrito) VALUES 
	(1700,120,'Alvalade','Lisboa','Lisboa'),
	(1700,121,'Alvalade','Lisboa','Lisboa'),
	(1700,201,'São João de Brito','Lisboa','Lisboa'),
	(1700,211,'Alvalade','Lisboa','Lisboa'),
	(1700,072,'Campo Grande','Lisboa','Lisboa'),
	(1700,337,'São João de Brito','Lisboa','Lisboa'),
	(1100,223,'Castelo','Lisboa','Lisboa'),
	(1100,248,'São Cristovão','Lisboa','Lisboa'),
	(1100,174,'Santo Estevão','Lisboa','Lisboa'),
	(1100,453,'Santo Estevão','Lisboa','Lisboa'),
	(1100,213,'São Vicente de Fora','Lisboa','Lisboa'),
	(1100,603,'Santo Estevão','Lisboa','Lisboa'),
	(1100,060,'São Nicoau','Lisboa','Lisboa'),
	(2615,040,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,070,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,779,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,394,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,359,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,015,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,018,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(1700,162,'Campo Grande','Lisboa','Lisboa'),
	(1100,170,'Alvalade','Lisboa','Lisboa'),
	(1100,442,'São Nicoau','Lisboa','Lisboa'),
	(1700,36,'São Miguel','Lisboa','Lisboa'),
	(2615,124,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,034,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'),
	(2615,136,'Alverca do Ribatejo','Vila Franca de Xira','Lisboa'); 
    
-- ADICIONAR MORADAS
insert into morada (codigoPostal, zonaPostal, designacao) values 
	(1700,120,'Rua Coronel Bento Roma Lt 942'),
	(1700,120,'Rua Coronel Bento Roma 10A'),
	(1700,121,'Rua Doutor Gama Barros 2'),
	(1700,201,'Rua de Entrecampos 28'),
	(1700,211,'Avenida Frei Miguel Contreiras 22'),
	(1700,072,'Rua Fausto Guedes Teixeira 10'),
	(1700,337,'Quinta da Carrapata Bairro São João de Brito'),
	(1700,337,'Rua do Chafariz Bairro São João de Brito'),
	(1100,223,'Rua Espírito Santo Ímpares 37'),
	(1100,248,'Travessa do Maldonado 2'),
	(1100,174,'Rua dos Corvos 27'),
	(1100,453,'Rua dos Remédios 173'),
	(1100,213,'Rua dos Fanqueiros 241'),
	(1100,603,'Escadinhas Terreiro do Trigo'),
	(1100,060,'Rua de São Julião Capela de Nossa Senhora da Oliveirinha'),
	(1100,060,'Rua de São Julião 130'),
	(2615,040,'Rua da Escola Bairro da Chasa'),
	(2615,070,'Rua Diamantino Freitas Brás'),
	(2615,779,'Rua Domingos José Ferreira'),
	(2615,394,'Rua Carlos Arrojado Panasqueira'),
	(2615,394,'Rua dos Navegantes Panasqueira'),
	(2615,394,'Rua do Salineiro Panasqueira'),
	(2615,359,'Rua Dom João i Quinta da Vala'),
	(2615,015,'Rua Francisco dos Santos A-dos-Potes'),
	(2615,018,'Escadinhas do Jardim A-dos-Potes'),
	(1700,162, 'Rua de Entrecampos' ),
	(1100,170, 'Rua dos Correeiros 204' ),
	(1100,442, 'Paça da Figueira 17' ),
	(1700,036,'Campo Grande 35B' ),
	(2615,124, 'Rua da Juventude' ),
	(2615,034, 'Estrada da Alfarrobeira' ),
	(2615,136, 'Rua Josué Martins Romão 4' );
  
-- ADICIONAR RESTAURANTES
INSERT INTO restaurante (nome, email, telefone, codigoMorada, codigoArea, zonaArea) VALUES
	('Pizza & Co', 'pizzaria@gmail.com', 911351759, 26, 1700, 162), 
    ('Elevador', 'elevador@gmail.com', 911351759, 27, 1100, 170), 
    ('Figus', 'figus@gmail.com', 911351759, 28, 1100, 442), 
    ('Taberna Londrina', 'tabernalondrina@tabernalondrina.com', 210912193, 29, 1700, 036), 
    ('Carvão', 'carvao@gmail.com', 934377871, 30, 2615, 124), 
    ('Mar by Nunes', 'pizzaria@gmail.com', 210730940, 31, 2615, 034), 
    ('Yasu Sushi', 'yasy@sushi.com', 219593295, 32,2615, 136);

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
INSERT INTO item_ementa(idItem, idEmenta, codigoRestaurante, preco) VALUES 
	(35,6,5,2.5), (36,6,5,2.5), (32,6,5,10), (33,6,5,10), (34,7,5,15), (7,3,2,13), (8,3,2,13), (9,3,2,2.5), (10,3,2,2.5),
	(11,3,2,13), (13,3,2,13), (14,3,2,3), (15,3,2,3), (12,3,2,4.5), (16,4,3,13), (17,4,3,13), (19,4,3,13), (20,4,3,3),
	(21,4,3,3), (22,4,3,3), (23,4,3,3), (18,4,3,4.5), (43,8,6,2.5), (44,8,6,2.5), (45,8,6,2.5), (37,8,6,10), (38,8,6,10),
	(39,8,6,4), (40,9,6,15), (41,9,6,15), (42,9,6,15), (1,1,1,10), (2,1,1,10), (3,2,1,3), (4,2,1,15), (5,1,1,2.5),
	(6,1,1,2.5), (24,5,4,2.5), (26,5,4,13), (27,5,4,13), (28,5,4,3), (29,5,4,3), (30,5,4,3), (31,5,4,3), (25,5,4,4.5),
	(49,11,7,2.5), (50,11,7,2.5), (46,11,7,10), (47,11,7,10), (48,12,7,15);

-- ADICIONAR MESA 
insert into mesa(numero, codigoRestaurante, lotacao) values 
	(1, 1, 4), (2, 1, 4), (3, 1, 8), (4, 1, 8), 
    (1, 2, 2), (2, 2, 4), (3, 2, 2), (4, 2, 8), 
    (1, 3, 2), (2, 3, 4), (3, 3, 2), (4, 3, 8),
    (1, 4, 2), (2, 4, 2), (3, 4, 8), (4, 4, 8), 
    (1, 5, 2), (2, 5, 2), (3, 5, 2), (4, 5, 2), 
    (1, 6, 4), (2, 6, 4), (3, 6, 4), (4, 6, 4), 
    (1, 7, 4), (2, 7, 8), (3, 7, 8), (4, 7, 4); 

-- ADICIONAR CARACTERISTICAS
INSERT INTO caracteristica (caracteristica) VALUES 
	('Fumador'), 
    ('Acessibilidade'), 
    ('Vista Mar'), 
    ('Vista Parque');
    
-- ADICIONAR CARACTERISITCAS MESAS
insert into caracteristicas_mesa(numeroCaracteristica, numeroMesa, codigoRestaurante) values 
	(1, 1, 1), (1, 2, 1), (2, 3, 1), (2, 4, 1), -- Restaurante 1: 2 mesas de 4 lugares para fumadores e 2 mesas com 8 lugares com acessibilidade
	(2, 1, 2), (2, 2, 2), (2, 3, 2), (2, 4, 2), -- Restaurante 2: 4 mesas com acessibilidade
	(1, 1, 3), -- Restaurante 3: 1 mesas de 2 lugares para fumadores
	-- Restaurante 4: 4 mesas sem caracteristicas
	(4, 1, 5), (4, 2, 5), (4, 3, 5), (2, 4, 5), -- Restaurante 5: 3 mesas com 2 lugares com vista Parque e 1 mesa com 2 lugares com acessibilidade
	(4, 1, 6), (3, 2, 6), (4, 3, 6), (1, 3, 6), (3, 4, 6), (1, 4, 6), -- Restaurante 6: 1 mesa com X lugares com vista Parque, 1 mesa com X lugares com vista Mar, 1 mesa com X lugares com vista Parque e para fumadores e 1 mesa com X lugares com vista Mar e para fumadores
	(1, 4, 7), (2, 4, 7); -- Restaurante 7: 1 mesa com 8 lugares com acessibilidade e para fumadores

    
-- ADICIONAR UTILIZADOR
INSERT INTO utilizador(nif, nomeProprio, apelido, idade) VALUES
	(107441870,'FRANCISCO ', 'VIVEIROS',35),
	(108094049,'ABILIO ', 'CUNHA',33),
	(108257681,'MARIA ', 'VICTORINO',43),
	(109104242,'ADÃO ', 'PEREIRA',37),
	(109728386,'ADELAIDE ', 'SOZINHO',33),
	(109985133,'FRANCISCO ', 'NUNES',46),
	(112323391,'HERMINIO ', 'TEIXEIRA',15),
	(112365906,'FERNANDO ', 'OLIVEIRA',24),
	(112626157,'MANUEL ', 'GRANGEIRO',47),
	(114071870,'VERA ', 'CARDOSO',21),
	(114350655,'FERNANDO ', 'CLAUDIO',62),
	(115213384,'MARIA ', 'SILVA',15),
	(115376950,'ABILIO ', 'CARDOSO',37),
	(116166258,'ABEL ', 'MARQUES',20),
	(135725828,'ACACIO ', 'PEDRO',57),
	(136270972,'MARIA ', 'SARAIVA',48),
	(138042934,'FERNANDO ', 'CUNHA',23),
	(138748543,'ADELAIDE ', 'LOURO',42),
	(140305335,'FERNANDO ', 'SACRAMENTO',63),
	(140523871,'HERMINIA ', 'DOMINGOS',27),
	(155951041,'VERISSIMO', 'SANTOS',46),
	(156853620,'HENRIQUE', 'BARBOSA',30),
	(157100162,'FRANCISCO', 'LUZIO',30),
	(157432920,'FRANCISCO', 'CRUZ',42),
	(157739317,'MANUEL', 'TEMIDO',53),
	(157784150,'MARIA', 'SILVA',36),
	(158027736,'MARIA', 'REIS',47),
	(158137507,'HERMANO', 'RODRIGUES',59),
	(158719506,'MANUEL', 'LOPES',49),
	(159403057,'FERNANDO', 'CARVALHO',35),
	(159873908,'VENTURA', 'MARGARIDO',26),
	(160799619,'HERMINIA', 'FELIX',35),
	(160851556,'MANUEL', 'ROSARIO',31),
	(161346863,'MANUEL', 'SOUSA',34),
	(161438849,'MANUEL', 'COELHO',38),
	(161510507,'VICTOR', 'BAPTISTA',54),
	(162580967,'MANUEL', 'CARDOSO',44),
	(164004092,'MARIA', 'PALMA',57),
	(164282238,'FERNANDO', 'CAETANO',19),
	(164811869,'FERNANDO', 'GUERREIRO',44),
	(164867546,'FERNANDO', 'MONTEIRO',60),
	(164911782,'HERMINIO', 'FIGUEIREDO',19),
	(164962760,'SOLANGE', 'ALMEIDA',32),
	(164966978,'MARIA', 'NUNES',51),
	(166205370,'HERMENEGILDO', 'ALMEIDA',37),
	(166432547,'HENRIQUE', 'SERRA',22),
	(166603112,'FERNANDO', 'LOURENÇO',27),
	(168465329,'ABILIO', 'CABRAL',63),
	(168574756,'FERNANDO', 'AMADOR',15),
	(168922142,'MANUEL', 'VASCONCELOS',35),
	(170038785,'MANUEL', 'TIAGO',18),
	(170068579,'FRANCISCO', 'BASTOS',32),
	(170428494,'MANUEL', 'FRANCISCO',31);


-- ADICIONAR CLIENTE
insert into cliente(nif, codigoMorada, codigoArea, zonaArea) values 
	(158719506,1,1700,120),
	(159403057,2,1700,120),
	(159873908,3,1700,121),
	(160799619,4,1700,201),
	(160851556,5,1700,211),
	(161346863,6,1700,72),
	(161438849,7,1700,337),
	(161510507,8,1700,337),
	(162580967,9,1100,223),
	(164004092,10,1100,248),
	(164282238,11,1100,174),
	(164811869,12,1100,453),
	(164867546,13,1100,213),
	(164911782,14,1100,603),
	(164962760,15,1100,60),
	(164966978,16,1100,60),
	(166205370,17,2615,40),
	(166432547,18,2615,70),
	(166603112,19,2615,779),
	(168465329,20,2615,394),
	(168574756,21,2615,394),
	(168922142,22,2615,394),
	(170038785,23,2615,359),
	(170068579,24,2615,15),
	(170428494,25,2615,18);

-- ADICIONAR FUNCIONARIO
-- GERENTES
insert into funcionario (nif, codigoRestaurante) values 
	(107441870,1),
	(108094049,2),
	(108257681,3),
	(109104242,4),
	(109728386,5),
	(109985133,6),
	(112323391,7); 

-- FUNCIONARIOS
insert into funcionario (nif, chefe, codigoRestaurante) values 
	(112365906,1,1),
	(112626157,2,2),
	(114071870,3,3),
	(114350655,4,4),
	(115213384,5,5),
	(115376950,6,6),
	(116166258,7,7),
	(135725828,1,1),
	(136270972,2,2),
	(138042934,3,3),
	(138748543,4,4),
	(140305335,5,5),
	(140523871,6,6),
	(155951041,7,7),
	(156853620,1,1),
	(157100162,2,2),
	(157432920,3,3),
	(157739317,4,4),
	(157784150,5,5),
	(158027736,6,6),
	(158137507,7,7); 


-- ADICIONAR RESERVA
insert into reserva (codigoRestaurante, dataHoraMarcacao, numeroCliente, nroPessoas, dataHora) values 
	(1, '2023-12-1 12:00', 1, 8, now()), -- VER ITENS DISPONIVEIS NA EMENTA 1 
    (2, '2023-12-1 19:00', 2, 8, now()), -- VER ITENS DISPONIVEIS NA EMENTA 3 
    (3, '2023-12-1 12:00', 4, 8, now()), -- VER ITENS DISPONIVEIS NA EMENTA 5
    (4, '2023-12-1 12:00', 3, 2, now()); -- VER ITENS DISPONIVEIS NA EMENTA 4

-- ADICIONAR ITENS RESERVA
insert into item_reserva (numeroReserva, codigoRestaurante, idItem, quantidade) values 
	(1, 1, 1, 6), (1, 1, 2, 2), (1, 1, 6, 3), (1, 1, 5, 5), -- Reserva 1: 6 Pizzas Camponesas + 2 Manjericao | 3 Limonadas + 5 Águas; 
	(2, 2, 7, 1), (2, 2, 8, 4), (2, 2, 11, 2), (2, 2, 15, 5), (2, 2, 14, 3), (2, 2, 9, 4), (2, 2, 10, 4),  -- Reserva 2: Ameijoas + 4 Bifes Novilho + 2 Caldeiradas de Marisco + 5 Limonadas + 3 Águas + 4 Bolo de Chocolate + 4 Frutas da Época
    -- Reserva 3: Não escolheu itens
    (4, 4, 16, 1), (4, 4, 19, 1), (4, 4, 22, 2); -- Reserva 4: Ostras + Polvo + 2 Cervejas
    
-- ADICIONAR CARACTERISTICAS RESERVA
insert into caracteristicas_reserva (numeroReserva, codigoRestaurante, numeroCaracteristica) values 
	(1, 1, 1), -- RESERVA 1: Fumadores
    (4, 4, 3), (4, 4, 2); -- RESERVA 4: Vista Mar + Acessibilidade


-- ADICIONAR RESERVA ATRIBUIDAS
insert into reservas_atribuidas (numeroReserva, codigoRestaurante, numeroFuncionario, numeroMesa, estado, dataHora) values 
	(1, 1, 8, 3, 'aceite', now()), 
    (2, 2, 16, 4, 'aceite', now()), 
    (3, 3, 24, null, 'recusado', now()), 
    (4, 4, 11, null, 'recusado', now());
    


