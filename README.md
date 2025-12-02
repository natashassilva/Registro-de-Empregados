# CRUD de Empregados (Java)  
**Descrição:** Aplicação de exemplo para cadastro e gestão de empregados, departamentos, dependentes, projetos e associação trabalha_em. Projeto didático para demonstrar arquitetura simples em Java usando JDBC, DAO e interface gráfica (Swing conforme implementado).

---

## Tecnologias
- Java 8+ 
- JDBC
- MySQL 
- GUI: Swing 
- Padrões: MVC, DAO
- Versionamento: Git

---

## Estrutura do projeto
- `conexao/Conexao.java` — gerencia conexão JDBC ao banco.
- `RegistroEmpregados/Modelo/` — classes de domínio (Empregado, Departamento, Dependente, Projeto, Trabalha_em).
- `RegistroEmpregados/DAO/` — classes DAO para CRUD nas tabelas.
- `RegistroEmpregados/GUI/` — telas para cadastrar, consultar, atualizar e deletar.
- `RegistroEmpregados/Principal.java` — ponto de entrada da aplicação.
- `sql/schema.sql` — script para criar o banco e tabelas (exemplo).
- `docs/` — diagramas e prints da aplicação.

---

## Script de criação do banco (MySQL)


```sql
CREATE DATABASE IF NOT EXISTS db_empregados;
USE db_empregados;

CREATE TABLE departamento (
  id_departamento INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  localizacao VARCHAR(100)
);

CREATE TABLE projeto (
  id_projeto INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  descricao TEXT
);

CREATE TABLE empregado (
  id_empregado INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150) NOT NULL,
  rua VARCHAR(150),
  bairro VARCHAR(100),
  telefone VARCHAR(30),
  datanasc DATE,
  dataadm DATE,
  funcao VARCHAR(100),
  salario DOUBLE,
  comissao DOUBLE,
  departamento_id_departamento INT,
  FOREIGN KEY (departamento_id_departamento) REFERENCES departamento(id_departamento)
);

CREATE TABLE dependente (
  id_dependente INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(150),
  parentesco VARCHAR(50),
  datanasc DATE,
  empregado_id INT,
  FOREIGN KEY (empregado_id) REFERENCES empregado(id_empregado)
);

CREATE TABLE trabalha_em (
  id INT AUTO_INCREMENT PRIMARY KEY,
  empregado_id INT,
  projeto_id INT,
  papel_no_projeto VARCHAR(100),
  FOREIGN KEY (empregado_id) REFERENCES empregado(id_empregado),
  FOREIGN KEY (projeto_id) REFERENCES projeto(id_projeto)
);
