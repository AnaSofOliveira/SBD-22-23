CREATE DATABASE IF NOT EXISTS `the_spoon`;
USE `the_spoon`;

CREATE TABLE if not exists AREA_GEOGRAFICA (
	codigo_postal INT NOT NULL, 
    zona_postal INT NOT NULL, 
    freguesia varchar(50) NOT NULL, 
    concelho varchar(50) NOT NULL, 
    distrito varchar(50) NOT NULL
);

create table if not exists morada (
	codigo int not null, 
    codigo_postal int not null, 
    zona_postal int not null, 
    designacao varchar(250) not null
);

create table if not exists recurso_multimedia (
	id int not null, 
    extensao varchar(5) not null, 
    conteudo LONGBLOB NOT NULL 
);

create table if not exists restaurante (
	codigo int not null,
    codigo_morada int not null, 
    codigo_area int not null, 
    zona_area int not null, 
    nome varchar(50) not null, 
    email varchar(50) not null, 
    telefone int not null
);

create table if not exists recursos_restaurante (
	idRecurso int not null, 
    codigoRestaurante int not null
);

create table if not exists ementa (
	id int not null, 
    codigoRestaurante int not null, 
    designacao varchar(250) not null
);

create table if not exists horario (
	dataHoraInicio datetime not null, 
    dataHoraFim datetime not null, 
    diaSemana varchar(3) not null, 
    idEmenta int not null, 
    codigoRestaurante int not null
);

create table if not exists item (
	id int not null, 
    designacao varchar(250) not null, 
    descricao varchar(250), 
    preco float not null, 
    tipo enum('sobremesa' , 'entrada', 'bebida', 'prato') not null
);

create table if not exists item_ementa (
	idItem int not null, 
    idEmenta int not null, 
    codigoRestaurante int not null
);

create table if not exists recurso_item (
	idItem int not null, 
    idRecurso int not null
);

create table if not exists mesa (
	numero int not null, 
    codigoRestaurante int not null, 
    lotacao int not null
);

create table if not exists caracteristica (
	numero int not null, 
    caracteristica varchar(250) not null
);

create table if not exists caracteristicas_mesa (
	numeroCaracteristica int not null, 
    numeroMesa int not null, 
    codigoRestaurante int not null
);
 
create table if not exists utilizador (
	nif int not null, 
    nomeProprio varchar(50) not null, 
    apelido varchar(50) not null, 
    idade int not null
);

create table if not exists cliente (
	numero int not null, 
    nif int not null, 
    dataUltimaVisita datetime not null, 
    codigoMorada int not null
);

create table if not exists funcionario (
	numero int not null, 
    nif int not null, 
    chefe int, 
    codigoRestaurante int not null
);

create table if not exists reserva (
	numero int not null, 
    codigoRestaurante int not null, 
    dataHoraMarcacao datetime not null, 
    numeroCliente int not null, 
    nroPessoas int not null, 
    dataHora datetime not null
);

create table if not exists caracteristicas_reserva (
	numeroReserva int not null, 
    numeroCaracteristica int not null
);

create table if not exists item_reserva (
	numeroReserva int not null, 
    idItem int not null
);

create table if not exists reservas_atribuidas (
	numeroReserva int not null,  
    numeroFuncionario int not null,
    numeroMesa int, 
    estado enum('aceite', 'recusado') not null, 
    dataHora datetime not null
);

















