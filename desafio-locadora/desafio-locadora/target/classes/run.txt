-- Select the Database
DROP DATABASE `locadora-carros`;
CREATE DATABASE `locadora-carros`;
USE `locadora-carros`;

-- Create Pessoa Table
CREATE TABLE pessoa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    dataNascimento DATE DEFAULT '2000-01-01' NULL,
    cpf VARCHAR(11) NOT NULL,
    sexo ENUM('MASCULINO', 'FEMININO') NOT NULL
);

-- Create Motorista Table
CREATE TABLE motorista (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    numeroCNH VARCHAR(20) NOT NULL,
    pessoa_id BIGINT,
    CONSTRAINT fk_motorista_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

-- Create Funcionario Table
CREATE TABLE funcionario (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    matricula VARCHAR(50) NOT NULL,
    pessoa_id BIGINT,
    CONSTRAINT fk_funcionario_pessoa FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
);

-- Create Fabricante Table
CREATE TABLE fabricante (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

-- Create ModeloCarro Table
CREATE TABLE modelo_carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    categoria ENUM('HATCH_COMPACTO', 'HATCH_MEDIO', 'SEDAN_COMPACTO', 'SEDAN_MEDIO', 'SEDAN_GRANDE', 'MINIVAN', 'ESPORTIVO', 'UTILITARIO_COMERCIAL') NOT NULL,
    fabricante_id BIGINT,
    CONSTRAINT fk_modelo_carro_fabricante FOREIGN KEY (fabricante_id) REFERENCES fabricante(id)
);

-- Create Carro Table
CREATE TABLE carro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    placa VARCHAR(7) NOT NULL,
    chassi VARCHAR(17) NOT NULL,
    cor VARCHAR(20) NOT NULL,
    valorDiaria DECIMAL(10, 2) DEFAULT 0.00 NULL,
    modelo_id BIGINT,
    CONSTRAINT fk_carro_modelo_carro FOREIGN KEY (modelo_id) REFERENCES modelo_carro(id)
);

-- Create Aluguel Table
CREATE TABLE aluguel (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
		dataPedido DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dataEntrega DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dataDevolucao DATE,
    valorTotal DECIMAL(10, 2) NULL DEFAULT 0.00,
    motorista_id BIGINT,
    carro_id BIGINT,
    CONSTRAINT fk_aluguel_motorista FOREIGN KEY (motorista_id) REFERENCES motorista(id),
    CONSTRAINT fk_aluguel_carro FOREIGN KEY (carro_id) REFERENCES carro(id)
);

-- Create ApoliceSeguro Table
CREATE TABLE apolice_seguro (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valorFranquia DECIMAL(10, 2) DEFAULT 0.00 NULL,
    protecaoTerceiro BOOLEAN NOT NULL DEFAULT FALSE,
    protecaoCausasNaturais BOOLEAN NOT NULL DEFAULT FALSE,
    protecaoRoubo BOOLEAN NOT NULL DEFAULT FALSE,
    aluguel_id BIGINT,
    CONSTRAINT fk_apolice_seguro_aluguel FOREIGN KEY (aluguel_id) REFERENCES aluguel(id)
);

-- Create Acessorio Table
CREATE TABLE acessorio (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    acessorios VARCHAR(255) NOT NULL
);

-- Create Carro_Acessorio Table (Many-to-Many Relationship)
CREATE TABLE carro_acessorio (
    carro_id BIGINT,
    acessorio_id BIGINT,
		PRIMARY KEY (carro_id, acessorio_id),
    CONSTRAINT fk_carro_acessorio_carro FOREIGN KEY (carro_id) REFERENCES carro(id),
    CONSTRAINT fk_carro_acessorio_acessorio FOREIGN KEY (acessorio_id) REFERENCES acessorio(id)
);










