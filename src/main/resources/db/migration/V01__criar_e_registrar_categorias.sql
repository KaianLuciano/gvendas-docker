CREATE TABLE categoria {
    codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(50) NOT NULL,
} ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria (nome) values ('Tecnologia')
INSERT INTO categoria (nome) values ('Acessórios para Veículos')
INSERT INTO categoria (nome) values ('Esporte e Lazer')
INSERT INTO categoria (nome) values ('Casa e eletrodomésticos')
INSERT INTO categoria (nome) values ('Joias e Relógios')