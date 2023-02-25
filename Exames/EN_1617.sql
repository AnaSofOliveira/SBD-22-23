CREATE TABLE `en_1617`.`empregado` (
	`idEmpregado` INT NOT NULL,
    `nome` VARCHAR(50) NOT NULL, 
    `dataNascimento` DATE NOT NULL, 
    PRIMARY KEY(`idEmpregado`));

INSERT INTO `en_1617`.`empregado` (`idEmpregado`, `nome`, `dataNascimento`) VALUES ('1', 'João', '1994-01-01');
INSERT INTO `en_1617`.`empregado` (`idEmpregado`, `nome`, `dataNascimento`) VALUES ('2', 'Maria', '1995-02-01');
INSERT INTO `en_1617`.`empregado` (`idEmpregado`, `nome`, `dataNascimento`) VALUES ('3', 'Joaquina', '1876-05-12');

CREATE TABLE `en_1617`.`empresa` (
	`idEmpresa` INT NOT NULL,
    `nome` VARCHAR(50) NOT NULL, 
    `localidade` VARCHAR(50) NOT NULL, 
    PRIMARY KEY(`idEmpresa`));
    
INSERT INTO `en_1617`.`empresa` (`idEmpresa`, `nome`, `localidade`) VALUES ('1', 'Empresa1', 'Lisboa');
INSERT INTO `en_1617`.`empresa` (`idEmpresa`, `nome`, `localidade`) VALUES ('2', 'Empresa2', 'Porto');


-- 1. b)
    CREATE TABLE `en_1617`.`trabalhar` (
  `idEmpregado` INT NOT NULL,
  `idEmpresa` INT NOT NULL,
  `salario` FLOAT NOT NULL,
  PRIMARY KEY (`idEmpregado`, `idEmpresa`));
  
  ALTER TABLE `trabalhar` ADD CONSTRAINT fk_empregado FOREIGN KEY (`idEmpregado`) REFERENCES `empregado`(`idEmpregado`);
  ALTER TABLE `trabalhar` ADD CONSTRAINT fk_empresa FOREIGN KEY (`idEmpresa`) REFERENCES `empresa`(`idEmpresa`); 
  
-- Adicionar dados à tabela `trabalhar`  
INSERT INTO `en_1617`.`trabalhar` (`idEmpregado`, `idEmpresa`, `salario`) VALUES ('2', '1', '10');
INSERT INTO `en_1617`.`trabalhar` (`idEmpregado`, `idEmpresa`, `salario`) VALUES ('3', '1', '5');
INSERT INTO `en_1617`.`trabalhar` (`idEmpregado`, `idEmpresa`, `salario`) VALUES ('1', '2', '100');
 

-- 1. c)
SELECT NOME, year(curdate())-year(e.dataNascimento) as idade
FROM EMPREGADO as e
	INNER JOIN TRABALHAR as t
	ON (t.idEmpregado = e.idEmpregado)
	ORDER BY idade DESC
    LIMIT 1;	
    
-- 1. d)
SELECT * FROM TRABALHAR;

UPDATE trabalhar as t
	INNER JOIN empresa as e
    ON (t.idEmpresa = e.idEmpresa and e.localidade != 'Lisboa')
SET salario = salario + salario*0.1;

SELECT * FROM TRABALHAR;

-- 1. e)
SELECT * FROM trabalhar; 

UPDATE trabalhar as t
	INNER JOIN empresa as e on (e.nome = 'ISEL UP')
    INNER JOIN empregado as emp on (emp.nome = 'Zé Ninguém')
SET t.idEmpresa = e.idEmpresa
WHERE t.idEmpregado = emp.idEmpregado;

SELECT * FROM trabalhar; 
