CREATE DATABASE bd_LOG_MAT;
USE bd_LOG_MAT;


CREATE TABLE tbl_PREGAO (
idPregao INT(6) auto_increment primary key,
numPregao VARCHAR(8) NOT NULL,
processo VARCHAR(20) NOT NULL
);

CREATE TABLE tbl_ARP (
idArp INT(6) auto_increment primary key,
numArp VARCHAR(8) NOT NULL,
dataAssinaturaArp date,
inicioVigenciaArp date,
fimVigenciaArp date,
superintendente VARCHAR(8) NOT NULL,
representanteFornecedor VARCHAR(8) NOT NULL,
valorARP decimal(9,2) NOT NULL
);

CREATE TABLE tbl_CONTRATO (
idArp INT(6) auto_increment primary key,
numContrato VARCHAR(8) NOT NULL,
dataAssinaturaContrato date,
inicioVigenciaContrato date,
fimVigenciaContrato date,
valorContrato decimal(9,2) NOT NULL
);

CREATE TABLE tbl_ITEM (
idItem INT(6) auto_increment primary key,
numItem VARCHAR(8) NOT NULL,
nomeItem VARCHAR(50) NOT NULL,
marcaItem VARCHAR(50),
unidadeItem VARCHAR(10) NOT NULL,
descricaoItem VARCHAR(250) NOT NULL,
valorUnitarioItem decimal(9,2) NOT NULL
);

CREATE TABLE tbl_FORNECEDOR (
idFornecedor INT(6) auto_increment primary key,
nomeFornecedor VARCHAR(150) NOT NULL,
CNPJFornecedor VARCHAR(18) NOT NULL,
enderecoFornecedor VARCHAR(100) NOT NULL,
telefoneFornecedor VARCHAR(14) NOT NULL,
emailFornecedor VARCHAR(30) NOT NULL
);

CREATE TABLE tbl_REPRESENTANTE_FORNECEDOR (
idRepresentante INT(6) auto_increment primary key,
nomeRepresentante VARCHAR(150) NOT NULL,
CPFRepresentante VARCHAR(18) NOT NULL,
enderecoRepresentante VARCHAR(100) NOT NULL,
telefoneRepresentante VARCHAR(14) NOT NULL,
emailRepresentante VARCHAR(30) NOT NULL,
idFornecedor INT(6),
   CONSTRAINT fk_FORNECEDOR 
   FOREIGN KEY (idFornecedor) 
	REFERENCES tbl_FORNECEDOR(idFornecedor)
);


SELECT * FROM  tbl_PREGAO;
SELECT * FROM  tbl_ARP;
SELECT * FROM  tbl_CONTRATO;
SELECT * FROM  tbl_ITEM;
SELECT * FROM  tbl_FORNECEDOR;
SELECT * FROM  tbl_REPRESENTANTE_FORNECEDOR;


DROP TABLE  tbl_PREGAO;
DROP TABLE  tbl_ARP;
DROP TABLE  tbl_CONTRATO;
DROP TABLE  tbl_ITEM;
DROP TABLE  tbl_FORNECDOR;
DROP TABLE  tbl_REPRESENTANTE_FORNECEDOR;