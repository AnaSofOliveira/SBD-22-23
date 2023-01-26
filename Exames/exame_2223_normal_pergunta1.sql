-- a) Codifique em SQL o esquena de relação 'Venda'. Adote os tipos de dados que achar convinientes referindo todas as restrições aplicãveis --
CREATE TABLE `exame_2122_normal`.`venda` (
  `lojaId` INT NOT NULL,
  `produtoId` INT NOT NULL,
  `instanteVenda` DATETIME NOT NULL,
  `quantidade` INT NOT NULL,
  PRIMARY KEY (`lojaId`, `produtoId`, `instanteVenda`));
  
ALTER TABLE venda ADD CONSTRAINT fk_Loja FOREIGN KEY(lojaId) REFERENCES Loja(lojaId); 
ALTER TABLE venda ADD CONSTRAINT fk_Produto FOREIGN KEY(produtoId) REFERENCES Produto(produtoId); 

ALTER TABLE venda ADD CONSTRAINT pk_Venda PRIMARY KEY(lojaId, produtoId, instanteVenda);


-- ADICIONAR DADOS ÀS TABELAS PARA TESTAR INSTRUÇÕES ABAIXO --
INSERT INTO `exame_2122_normal`.`loja` (`lojaId`, `designacao`, `codigoPostal`) 
VALUES ('1', 'Loja1', '1959-007'),
('2', 'Loja2', '1959-007'), ('3', 'Loja3', '1959-006'), ('4', 'Loja4', '1959-006'), 
('5', 'Loja5', '1959-009'), ('6', 'Loja6', '1959-009'), ('7', 'Loja7', '1200-154'), 
('8', 'Loja8', '1366-145'), ('9', 'Loja9', '1635-459'), ('10', 'Loja10', '2615-359');

INSERT INTO `exame_2122_normal`.`produto` (`produtoId`, `nome`, `descricao`, `precoSemIVA`, `taxaVU`) 
VALUES (1, 'Produto1', 'Produto1', 0.1, 0.25), (2, 'Produto2', 'Produto2', 1, 0.25), (3, 'Produto3', 'Produto3', 10, 0.2);

INSERT INTO `exame_2122_normal`.`venda` (`lojaId`, `produtoId`, `instanteVenda`, `quantidade`) 
VALUES ('1', '1', CURDATE(), '1'), ('1', '2', CURDATE(), '2'), ('1', '3', CURDATE(), '3'), 
('2', '1', CURDATE(), '4'), ('2', '3', CURDATE(), '5'), ('3', '2', CURDATE(), '6'), 
('4', '2', CURDATE(), '7'), ('2', '4', CURDATE(), '8');

-- b) Apresente uma instrução SQL que possa ser usada para obter a descrição dos produtos com faturação inferior a 10€ na última semana --
SELECT nome, descricao, precoSemIVA, taxaIVA, ROUND(precoSemIVA*taxaIVA, 3), ROUND(precoSemIVA+precoSemIVA*taxaIVA, 3)
FROM produto as p
	INNER JOIN venda as v
    ON (v.produtoId = p.produtoId and WEEK(v.instanteVenda)=WEEK(CURDATE())-1 and 
		YEAR(v.instanteVenda)=YEAR(CURDATE()) and
        p.precoSemIVA*p.taxaIVA < 10);

-- c) Escreva ums instrução SQL que liste, por loja, o total mensal de vendas realizadas nas áreas geográficas com códigos postais: 1959-007 e 1959-006 --
SELECT v.lojaId, MONTH(v.instanteVenda), SUM(v.quantidade)
FROM venda as v
	INNER JOIN loja as l
    ON (l.lojaId = v.lojaId and (l.codigoPostal='1959-006' or l.codigoPostal='1959-007'))
GROUP BY v.lojaId; 

-- d) Sugira, uma instrução SQL que registe agora a venda de cinco unidades do produto 2023 na loja designada 'Thurinzuo' --
INSERT INTO venda(lojaId, produtoId, instanteVenda, quantidade)
SELECT lojaId, 2023, CURDATE(), 5
FROM loja as l
WHERE l.designacao = 'Thurinzuo';

-- e) Indique uma diretiva SQL que reduza 0.1% os preços inferiores a 1€ --
UPDATE produto
SET taxaIVA = 0.1
WHERE precoSemIVA + precoSemIVA*taxaIVA < 1;


