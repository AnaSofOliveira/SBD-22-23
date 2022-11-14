USE `restaurantes`; 

-- ADICIONAR AREAS GEOGRAFICAS
INSERT INTO `area_geografica` VALUES 
	(1700, 001, 'Lisboa', 'Lisboa', 'Lisboa'), (1700, 002, 'Lisboa', 'Lisboa', 'Lisboa'), 
    (1700, 003, 'Lisboa', 'Lisboa', 'Lisboa'), (2615, 001, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'),
    (2615, 002, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'), (2615, 003, 'Lisboa', 'Vila Franca Xira', 'Alverca do Ribatejo'),
    (1100, 001, 'Lisboa', 'Lisboa', 'Lisboa'), (1100, 002, 'Lisboa', 'Lisboa', 'Lisboa'); 

-- ADICIONAR RESTAURANTES
INSERT INTO `restaurante`(`area_geografica`, `nome`, `morada`, `email`, `telefone`) VALUES
	(1700, 'Pizza & Co', 'Rua de Entrecampos', 'pizzaria@gmail.com', 911351759), 
    (1100, 'Elevador', 'Rua dos Correeiros 204', 'elevador@gmail.com', 911351759), 
    (1100, 'Figus', 'Paça da Figueira 17', 'figus@gmail.com', 911351759), 
    (1700, 'Taberna Londrina', 'Campo Grande 35B', 'tabernalondrina@tabernalondrina.com', 210912193), 
    (2615, 'Carvão', 'Rua da Juventude', 'carvao@gmail.com', 934377871), 
    (2615, 'Mar by Nunes', 'Estrada da Alfarrobeira', 'pizzaria@gmail.com', 210730940), 
    (2615, 'Yasu Sushi', 'Rua Josué Martins Romão 4', 'yasy@sushi.com', 219593295);


-- ADICIONAR RECURSOS MULTIMÉDIA
	-- Recursos Restaurante "Elevador"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('elevador', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/elevador.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('ameijoas', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/ameijoas.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('bife novilho', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/bife_novilho.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('bolo chocolate', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/bolo_de_chocolate.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('fruta epoca', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/fruta_da_epoca.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('caldeirada de marisco', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/caldeirada_de_marisco.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('queijo', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/queijo.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('salmão', 'jpg',  LOAD_FILE('../Uploads/restaurantes/1100 - Elevador/itens/salmao.jpg'));

	-- Recursos Restaurante "Figus"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('figus', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/figus.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('ostras', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/ostras.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('peixe galo com rizzotto', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/peixe_galo_com_rizotto.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('peixinhos da horta', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/peixinhos_da_horta.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('polvo', 'jpg', LOAD_FILE('../Uploads/restaurantes/1100 - Figus/itens/polvo.jpg'));

	-- Recursos Restaurante "Pizza & Co"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('pizza and co', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/pizza_co.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('camponesa', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/camponesa.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('manjericão', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/manjericao.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('morango e chocolate', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/morango-e-chocolate.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('peperoni', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - Pizza & Co/itens/peperoni.jpg'));

	-- Recursos Restaurante "Taberna Londrina"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('taberna londrina', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/taberna_londrina.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('cerveja', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/cerveja.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('cheesecake', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/cheesecake.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('folhados de alheira', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/folhados_alheira.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('francesinha', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/francesinha.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('hamburguer', 'jpg', LOAD_FILE('../Uploads/restaurantes/1700 - taberna_londrina/itens/hamburguer.jpg'));

	-- Recursos Restaurante "Carvão"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('carvão', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/carvao.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('bacalhau', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/bacalhau.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('perna de frango estufada', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/perna-de-frango-estufada.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('picanha', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Carvao/itens/picanha.jpg'));

	-- Recursos Restaurante "Mar by Nunes"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('mar by nunes', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/mar_by_nunes.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('maminha', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/maminha.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('mariscada', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/mariscada.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('ostras', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/ostras.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('perca', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/perca.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('sapateira', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/sapateira.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('sardinhas', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - Mar by Nunes/itens/sardinhas.jpg'));

	-- Recursos Restaurante "Yasu Sushi"
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('yasu', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/yasu.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('lula', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/lula.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('sushi', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/sushi.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('variado', 'jpg', LOAD_FILE('../Uploads/restaurantes/2615 - yasu_sushi/itens/variado.jpg'));

	-- Recursos todos os bares - Bebidas
    INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('água', 'jpg', LOAD_FILE('../Uploads/restaurantes/agua.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('cerveja', 'jpg', LOAD_FILE('../Uploads/restaurantes/cerveja.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('ice_tea', 'jpg', LOAD_FILE('../Uploads/restaurantes/ice_tea.jpg'));
	INSERT INTO `restaurantes`.`recurso_multimedia` (`nome`, `tipo`, `conteudo`) VALUES ('limonada', 'jpg', LOAD_FILE('../Uploads/restaurantes/limonada.jpg'));


-- ADICIONAR RECURSOS RESTAURANTE
INSERT INTO `recursos_restaurante` VALUES 
	(1, 1700, 14), 
    (2, 1100, 1), 
    (3, 1100, 9), 
    (4, 1700, 19),
    (5, 2615, 25),
    (6, 2615, 29),
    (7, 2615, 36);

-- ADICIONAR HORARIO
INSERT INTO `horario`(`dia_semana`, `hora_inicio`, `hora_fim`) VALUES
	('Seg', '10:00', '19:00'),
	('Ter', '10:00', '19:00'), 
	('Qua', '10:00', '19:00'), 
	('Qui', '10:00', '19:00'), 
	('Sex', '10:00', '19:00'), 
	('Sab', '10:00', '19:00'), 
	('Dom', '10:00', '19:00'), 
	('Seg', '10:00', '15:00'), 
	('Seg', '18:00', '22:00'), 
	('Ter', '10:00', '15:00'), 
	('Ter', '18:00', '22:00'), 
	('Qua', '10:00', '15:00'), 
	('Qua', '18:00', '22:00'), 
	('Qui', '10:00', '15:00'), 
	('Qui', '18:00', '22:00'), 
	('Sex', '10:00', '15:00'), 
	('Sex', '18:00', '22:00'), 
	('Sab', '10:00', '15:00'), 
	('Sab', '18:00', '22:00'), 
	('Dom', '10:00', '15:00'), 
	('Dom', '18:00', '22:00');
    

-- ADICIONAR MESAS
INSERT INTO `mesa`(`numero`, `codigo_restaurante`, `area_restaurante`, `numero_lugares`) VALUES 
	(1, 1, 1700, 4), (2, 1, 1700, 4), (3, 1, 1700, 8), (4, 1, 1700, 8), 
    (1, 2, 1100, 2), (2, 2, 1100, 4), (3, 2, 1100, 2), (4, 2, 1100, 8), 
    (1, 3, 1100, 2), (2, 3, 1100, 4), (3, 3, 1100, 2), (4, 3, 1100, 8),
    (1, 4, 1700, 2), (2, 4, 1700, 2), (3, 4, 1700, 8), (4, 4, 1700, 8), 
    (1, 5, 2615, 2), (2, 5, 2615, 2), (3, 5, 2615, 2), (4, 5, 2615, 2), 
    (1, 6, 2615, 4), (2, 6, 2615, 4), (3, 6, 2615, 4), (4, 6, 2615, 4), 
    (1, 7, 2615, 4), (2, 7, 2615, 8), (3, 7, 2615, 8), (4, 7, 2615, 4); 


-- ADICIONAR CARACTERISITCAS
INSERT INTO `caracteristica`(`designacao`) VALUES 
	('Fumador'), 
    ('Acessibilidade'), 
    ('Vista Mar'), 
    ('Vista Parque');

-- ADICIONAR UTILIZADORES
INSERT INTO `utilizador`(`nif`, `nome_proprio`, `apelido`, `idade`) VALUES
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


-- ADICIONAR FUNCIONARIOS
INSERT INTO `funcionario`(`nif`, `tipo`, `codigo_restaurante`) VALUES 
	(107441870, 'GER',1),
	(108094049, 'GER',2),
	(108257681, 'GER',3),
	(109104242, 'GER',4),
	(109728386, 'GER',5),
	(109985133, 'GER',6),
	(112323391, 'GER',7),
	(112365906, 'EMP',1),
	(112626157, 'EMP',2),
	(114071870, 'EMP',3),
	(114350655, 'EMP',4),
	(115213384, 'EMP',5),
	(115376950, 'EMP',6),
	(116166258, 'EMP',7),
	(135725828, 'EMP',1),
	(136270972, 'EMP',2),
	(138042934, 'EMP',3),
	(138748543, 'EMP',4),
	(140305335, 'EMP',5),
	(140523871, 'EMP',6),
	(155951041, 'EMP',7),
	(156853620, 'EMP',1),
	(157100162, 'EMP',2),
	(157432920, 'EMP',3),
	(157739317, 'EMP',4),
	(157784150, 'EMP',5),
	(158027736, 'EMP',6),
	(158137507, 'EMP',7);


-- ADICIONAR CLIENTES 
INSERT INTO `cliente`(`nif`, `morada`, `codigo_area_geografica`) VALUES 
	(158719506,'Rua Coronel Bento Roma Lt 942',1700),
	(159403057,'Rua Coronel Bento Roma 10A',1700),
	(159873908,'Rua Doutor Gama Barros 2',1700),
	(160799619,'Rua de Entrecampos 28',1700),
	(160851556,'Avenida Frei Miguel Contreiras 22',1700),
	(161346863,'Rua Fausto Guedes Teixeira 10',1700),
	(161438849,'Quinta da Carrapata Bairro São João de Brito',1700),
	(161510507,'Rua do Chafariz Bairro São João de Brito',1700),
	(162580967,'Rua Espírito Santo Ímpares 37',1100),
	(164004092,'Travessa do Maldonado 2',1100),
	(164282238,'Rua dos Corvos 27',1100),
	(164811869,'Rua dos Remédios 173',1100),
	(164867546,'Rua dos Fanqueiros 241',1100),
	(164911782,'Escadinhas Terreiro do Trigo',1100),
	(164962760,'Rua de São Julião Capela de Nossa Senhora da Oliveirinha',1100),
	(164966978,'Rua de São Julião 130',1100),
	(166205370,'Rua da Escola Bairro da Chasa',2615),
	(166432547,'Rua Diamantino Freitas Brás',2615),
	(166603112,'Rua Domingos José Ferreira',2615),
	(168465329,'Rua Carlos Arrojado Panasqueira',2615),
	(168574756,'Rua dos Navegantes Panasqueira',2615),
	(168922142,'Rua do Salineiro Panasqueira',2615),
	(170038785,'Rua Dom João i Quinta da Vala',2615),
	(170068579,'Rua Francisco dos Santos A-dos-Potes',2615),
	(170428494,'Escadinhas do Jardim A-dos-Potes',2615);


-- ADICIONAR ITENS
	-- Itens Restaurante "Pizza & Co" - Gerente 1
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Pizza Camponesa', 'Pizza Camponesa', 'prato', 15, 1),
		('Pizza Manjericão', 'Pizza Manjericão', 'prato', 16, 1), 
		('Pizza Morango e Chocolate', 'Pizza Morango e Chocolate', 'sobremesa', 17, 1), 
		('Pizza Peperoni', 'Pizza Peperoni', 'prato', 18, 1), 
		('Água', 'Água da fonte', 'bebida', 40, 1), 
		('Limonada', 'Limonada', 'bebida', 43, 1);

	-- Itens Restaurante "Elevador" - Gerente 2
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Ameijoas', 'Ameijoas', 'prato', 2, 2),
		('Bife Novilho', 'Bife Novilho', 'prato', 3, 2), 
		('Bolo Chocolate', 'Bolo Chocolate', 'sobremesa', 4, 2), 
		('Fruta Época', 'Fruta Época', 'sobremesa', 5, 2), 
		('Caldeirada de Marisco', 'Caldeirada de Marisco', 'prato', 6, 2), 
		('Queijo', 'Queijo', 'entrada', 7, 2), 
		('Salmão', 'Salmão', 'prato', 8, 2),
		('Água', 'Água da fonte', 'bebida', 40, 2), 
		('Limonada', 'Limonada', 'bebida', 43, 2);
		
	-- Itens Restaurante "Figus" - Gerente 3
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Ostras', 'Ostras', 'prato', 10, 3),
		('Peixe Galo', 'Peixe Galo com Rizzotto', 'prato', 11, 3), 
		('Peixinhos da Horta', 'Peixinhos da Horta', 'entrada', 12, 3), 
		('Polvo', 'Polvo', 'prato', 13, 3),
		('Água', 'Água da fonte', 'bebida', 40, 3), 
		('Limonada', 'Limonada', 'bebida', 43, 3), 
		('Cerveja', 'Cerveja', 'bebida', 41, 3), 
		('Ice Tea', 'Ice Tea', 'bebida', 42, 3);   
		
	-- Itens Restaurante "Taberna Londrina" - Gerente 4
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Cheesecake', 'Cheesecake', 'sobremesa', 20, 4),
		('Folhados de Alheira', 'Folhados de Alheira', 'entrada', 22, 4), 
		('Francesinha', 'Francesinha', 'prato', 23, 4), 
		('Hamburguer', 'Hamburguer', 'prato', 24, 4),
		('Água', 'Água da fonte', 'bebida', 40, 4),
		('Cerveja', 'Cerveja', 'bebida', 20, 4), 
		('Ice Tea', 'Ice Tea', 'bebida', 42, 4),
		('Limonada', 'Limonada', 'bebida', 43, 4);   
		
	-- Itens Restaurante "Carvão" - Gerente 5
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Bacalhau', 'Bacalhau', 'prato', 26, 5),
		('Perna de Frango', 'Perna de Frango Estufada', 'prato', 27, 5), 
		('Picanha', 'Picanha', 'prato', 25, 5),
		('Água', 'Água da fonte', 'bebida', 40, 5),
		('Ice Tea', 'Ice Tea', 'bebida', 42, 5);
		
	-- Itens Restaurante "Mar by Nunes" - Gerente 6
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Maminha', 'Maminha', 'prato', 30, 6),
		('Mariscada', 'Mariscada de Peixe', 'prato', 31, 6), 
		('Ostras', 'Ostras', 'entrada', 32, 6),
		('Perca', 'Perca', 'prato', 33, 6),
		('Sapateira', 'Sapateira', 'prato', 34, 6),
		('Sardinhas', 'Sardinhas', 'prato', 35, 6),
		('Água', 'Água da fonte', 'bebida', 40, 6),
		('Cerveja', 'Cerveja', 'bebida', 20, 6), 
		('Limonada', 'Limonada', 'bebida', 43, 6);     

	-- Itens Restaurante "Yasu" - Gerente 7
	INSERT INTO `item`(`designacao`, `descricao`, `tipo`, `recurso_multimedia`, `numero_gerente`) VALUES 
		('Lula', 'Lula', 'prato', 37, 7),
		('Sushi', 'Sushi', 'prato', 38, 7), 
		('Sushi Variado', 'Sushi Variado', 'prato', 39, 7),
		('Cerveja', 'Cerveja', 'bebida', 20, 7), 
		('Limonada', 'Limonada', 'bebida', 43, 7);  


-- ADICIONAR EMENTAS
INSERT INTO `ementa`(`designacao`) VALUES
	('Almoço'), 
    ('Jantar'),
    ('Almoço e Jantar'); 


-- ADICIONAR HORARIOS DAS EMENTAS DOS RESTAURANTES
	-- Restaurante 1
	INSERT INTO `horario_ementas_restaurante` VALUES
		(1, 1, 8), 
		(1, 1, 10), 
		(1, 1, 12), 
		(1, 1, 14), 
		(1, 1, 16), 
		(1, 1, 18), 
		(1, 2, 9), 
		(1, 2, 11),
		(1, 2, 13),
		(1, 2, 15),
		(1, 2, 17),
		(1, 2, 19);
		
	-- Restaurante 2
	INSERT INTO `horario_ementas_restaurante` VALUES
		(2, 3, 1), 
		(2, 3, 2), 
		(2, 3, 3), 
		(2, 3, 4), 
		(2, 3, 5);
		
	-- Restaurante 3
	INSERT INTO `horario_ementas_restaurante` VALUES
		(3, 3, 2), 
		(3, 3, 3), 
		(3, 3, 4), 
		(3, 3, 5),
		(3, 3, 6);
		
		-- Restaurante 4
	INSERT INTO `horario_ementas_restaurante` VALUES
		(4, 3, 3), 
		(4, 3, 4), 
		(4, 3, 5),
		(4, 3, 6), 
		(4, 3, 7);
		
		-- Restaurante 5
	INSERT INTO `horario_ementas_restaurante` VALUES
		(5, 1, 8), 
		(5, 1, 10), 
		(5, 1, 12), 
		(5, 1, 14), 
		(5, 1, 16), 
		(5, 1, 18), 
		(5, 2, 9), 
		(5, 2, 11),
		(5, 2, 13),
		(5, 2, 15),
		(5, 2, 17),
		(5, 2, 19);
		
		-- Restaurante 6
	INSERT INTO `horario_ementas_restaurante` VALUES
		(6, 1, 8), 
		(6, 2, 9), 
		(6, 3, 2), 
		(6, 3, 3), 
		(6, 3, 4), 
		(6, 3, 5), 
		(6, 1, 18), 
		(6, 2, 19);
		
		-- Restaurante 7
	INSERT INTO `horario_ementas_restaurante` VALUES
		(7, 1, 8), 
		(7, 1, 10), 
		(7, 1, 12), 
		(7, 1, 14), 
		(7, 1, 16), 
		(7, 1, 18), 
		(7, 2, 9), 
		(7, 2, 11),
		(7, 2, 13),
		(7, 2, 15),
		(7, 2, 17),
		(7, 2, 19);

-- ADICIONAR RESERVAS
-- TODO