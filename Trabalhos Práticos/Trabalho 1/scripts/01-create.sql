CREATE DATABASE IF NOT EXISTS restaurantes; 

USE `restaurantes`; 

CREATE TABLE `area_geografica` (
	`codigo` INT(4) ZEROFILL NOT NULL,
	`zona_postal` INT(3) ZEROFILL NOT NULL,
	`distrito` VARCHAR(45) NOT NULL,
	`concelho` VARCHAR(45) NOT NULL,
	`freguesia` VARCHAR(45) NOT NULL);
  
  
  CREATE TABLE `restaurante` (
	`codigo` INT NOT NULL, 
	`area_geografica` INT(4) ZEROFILL NOT NULL, 
	`nome` VARCHAR(255) NOT NULL, 
	`morada` VARCHAR(255) NOT NULL, 
	`email` VARCHAR(255) NOT NULL,
	`telefone` INT NOT NULL);
  

  CREATE TABLE `mesa` (
	`numero` INT NOT NULL, 
	`codigo_restaurante` INT NOT NULL, 
	`area_restaurante` INT(4) ZEROFILL NOT NULL, 
	`numero_lugares` INT NOT NULL);

  
  CREATE TABLE `caracteristica` (
	`id` INT NOT NULL, 
    `designacao` VARCHAR(255) NOT NULL
  );
  
  CREATE TABLE `recurso_multimedia` (
	`id` INT NOT NULL, 
    `nome` VARCHAR(50) NOT NULL,
    `tipo` VARCHAR(10) NOT NULL, 
    `conteudo` LONGBLOB NOT NULL  
  ); 
  
   CREATE TABLE `recursos_restaurante` (
	`codigo_restaurante` INT NOT NULL, 
    `area_restaurante` INT(4) ZEROFILL NOT NULL, 
    `id_recurso` INT NOT NULL
  ); 
  
   CREATE TABLE `horario` ( 
	`id` INT NOT NULL,
	`dia_semana` ENUM('Seg', 'Ter', 'Qua', 'Qui', 'Sex', 'Sab', 'Dom') NOT NULL, 
    `hora_inicio` TIME NOT NULL, 
    `hora_fim` TIME NOT NULL  
  ); 
  
  
   CREATE TABLE `ementa` (
	`codigo` INT NOT NULL,
    `designacao` VARCHAR(100)
  );
  
  CREATE TABLE `horario_ementas_restaurante` (
	`codigo_restaurante` INT NOT NULL,
    `codigo_ementa`  INT NOT NULL,
    `id_horario` INT NOT NULL  
  ); 
  
  
   CREATE TABLE `utilizador` (
	`nif` INT NOT NULL UNIQUE, 
    `nome_proprio` VARCHAR(200) NOT NULL, 
    `apelido` VARCHAR(50) NOT NULL, 
    `idade`  INT NOT NULL
  ); 
  
  
   CREATE TABLE `cliente` (
	`numero` INT NOT NULL,
    `nif` INT NOT NULL UNIQUE, 
	`morada` VARCHAR(255) NOT NULL,
    `codigo_area_geografica` INT(4) ZEROFILL NOT NULL, 
    `data_ultima_visita` DATETIME DEFAULT NULL
  ); 
  
  
   CREATE TABLE `funcionario` (
	`numero` INT NOT NULL, 
    `nif` INT NOT NULL UNIQUE, 
    `tipo` ENUM('EMP','GER') , 
    `codigo_restaurante` INT NOT NULL
  ); 
  
   CREATE TABLE `item` (
	`numero` INT NOT NULL,
    `designacao` VARCHAR(100) NOT NULL,
    `descricao` VARCHAR(500),
    `tipo` ENUM('entrada', 'prato', 'bebida', 'sobremesa') NOT NULL,
    `recurso_multimedia` INT NOT NULL,
    `numero_gerente` INT NOT NULL  
  ); 
  
  
   CREATE TABLE `itens_ementa` (
	`codigo_ementa` INT NOT NULL, 
    `numero_item` INT NOT NULL, 
    `preco` FLOAT NOT NULL  
  ); 
  
  
   CREATE TABLE `reserva` (
	`id` INT NOT NULL,
    `codigo_restaurante` INT NOT NULL, 
    `area_restaurante` INT(4) ZEROFILL NOT NULL,
    `numero_cliente` INT NOT NULL,
    `numero_lugares` INT NOT NULL, 
    `data_hora_reserva` DATETIME NOT NULL,
    `data_hora_marcacao` DATETIME NOT NULL,
    `mesa` INT,
    `numero_funcionario` INT
  ); 
  
  
   CREATE TABLE `ementa_reservada` (
	`id_reserva` INT NOT NULL, 
    `codigo_ementa` INT NOT NULL, 
	`numero_item` INT NOT NULL
  ); 
  
  
   CREATE TABLE `caracteristicas_reserva` (
	`id_reserva` INT NOT NULL, 
    `id_caracteristica` INT NOT NULL  
  
  ); 
  

   CREATE TABLE `itens_preferidos_cliente` (
	`numero_cliente` INT NOT NULL,
    `numero_item` INT NOT NULL  
  ); 
  
