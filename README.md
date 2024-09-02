## Desafio Locadora de Veículos - Spring Boot - Squad 10

**Desafio Locadora de Veículos**, desenvolvido pela **Squad 10** com o objetivo de criar uma aplicação completa de gerenciamento de locadora de veículos utilizando **Spring Boot**.

## Participantes

- Gerson Fragoso
- Guilherme
- João Victor
- Daniel
- Samuel


## Estrutura do Projeto

O sistema é dividido em módulos que representam as principais entidades da aplicação: **Motorista**, **Carro**, **Aluguel** e **Apólice de Seguro**. Cada módulo é composto por um modelo de dados, serviços para manipulação desses dados, repositórios para acesso ao banco de dados, DTOs para transferência de dados entre as camadas, e controladores REST que expõem APIs para operações CRUD.

## Tecnologias Utilizadas

- **Spring Boot**: Framework principal para o desenvolvimento da aplicação.
- **MySQL**: Banco de dados utilizado para persistência das informações.
- **Swagger**: Documentação automática da API REST.

## Estrutura do Motorista

### **Modelo (`MotoristaModel`)**

A classe `MotoristaModel` estende a `PessoaModel` e representa as informações de um motorista no sistema. Atributos principais incluem:

- **`numeroCNH`**: Número da CNH.

### **Serviço (`MotoristaServiceImpl`)**

A classe `MotoristaServiceImpl` implementa a interface `MotoristaService` e contém a lógica de negócio para as operações com motoristas, como:

- **Criar motorista**: Salva um novo motorista no banco de dados.
- **Listar motoristas**: Retorna todos os motoristas registrados.
- **Atualizar motorista**: Modifica as informações de um motorista existente.
- **Deletar motorista**: Remove um motorista do banco de dados.

### **Repositório (`MotoristaRepository`)**

O `MotoristaRepository` é uma interface que estende `JpaRepository` e permite a manipulação dos dados dos motoristas, como buscas e persistências. Um método útil incluído:

- **`findByCpf`**: Busca um motorista pelo CPF.

###  **DTOs**

Utilizamos DTOs para transferir dados entre as camadas da aplicação:

- **`MotoristaRequestDTO`**: Utilizado para capturar os dados necessários ao criar ou atualizar um motorista.
- **`MotoristaDTO`**: Usado para expor os dados dos motoristas ao cliente, como nome, CPF, data de nascimento, sexo e CNH.

### **Controlador REST (`MotoristaController`)**

O `MotoristaController` expõe uma API REST que permite operações CRUD (Create, Read, Update, Delete) sobre os motoristas. Os principais endpoints são:

- **`GET /listar`**: Retorna uma lista de todos os motoristas.
- **`POST /create`**: Cria um novo motorista.
- **`PUT /update`**: Atualiza um motorista existente.
- **`DELETE /deletar`**: Deleta um motorista do sistema.

## Estrutura do Carro

### Model
- **CarroModel**: Entidade representando um carro no sistema.
    - **Campos:**
        - `placa`
         - `chassi`
         - `cor`
         - `valorDiaria`
         - `acessorios`
         - `modelo`
         - `alugueis`

### DTO (Data Transfer Object)
- **CarroDTO**: Representa os dados de um carro.    
  
    - **Construtor:** Inicializa os campos a partir de um objeto `CarroModel`.
- **CarroDisponivelDTO**: Representa os dados de um carro disponível para aluguel.
  - **Campos:**
    - `fabricante`
    - `modelo`
    - `categoria`
    - `acessorios`

### Repository
- **CarroRepository**: Interface para operações de repositório da entidade `CarroModel`.
  - **Métodos:**
    - `findByModeloCategoria`
    - `findByChassi`
    - `findByAcessorios`
    - `findCarrosDisponiveis`

### Service
- **CarroService**: Interface para operações relacionadas a carros.

    - **CarroServiceImpl**: Implementação da interface `CarroService`.
  - **Métodos:**
    - `salvarCarro`
    - `listarCarros`
    - `filtrarCarros`
    - `listarCarrosDisponiveisParaAluguel`
    - `atualizarCarro`
    - `deletarPorId`

### Controller
- **CarroController**: Controlador REST para gerenciar operações relacionadas a carros.
  - **Endpoints:**
    - `listarCarros`: Lista todos os carros.
    - `criarCarro`: Cria um novo carro.
    - `filtrarCarros`: Filtra carros por categoria e acessórios.
    - `listarCarrosDisponiveisParaAluguel`: Lista carros disponíveis para aluguel com filtros opcionais.
    - `atualizarCarro`: Atualiza um carro existente.
    - `deletarPorId`: Deleta um carro por ID.

## Estrutura do Aluguel

### **Modelo (`AluguelModel`)**

A classe `AluguelModel` representa as informações de um aluguel no sistema. Ela encapsula dados como:

- `dataPedido`: Data em que o pedido de aluguel foi feito.
- `dataEntrega`: Data prevista para a entrega do carro.
- `dataDevolucao`: Data em que o carro foi devolvido.
- `valorTotal`: Valor total do aluguel.
- `CarroModel`: Carro alugado.
- `ApoliceModel`: Apólice de seguro associada ao aluguel.
- `MotoristaModel`: Motorista que realizou o aluguel.

### **Serviço (`AluguelServiceImpl`)**

A classe `AluguelServiceImpl` implementa a interface `AluguelService` e contém a lógica de negócio para as operações com aluguéis, incluindo:

- **Criar aluguel**: Salva um novo aluguel no banco de dados.
- **Listar aluguéis**: Retorna todos os aluguéis registrados.
- **Atualizar aluguel**: Modifica as informações de um aluguel existente.
- **Deletar aluguel**: Remove um aluguel do banco de dados.

### **Repositório (`AluguelRepository`)**

O `AluguelRepository` é uma interface que estende `JpaRepository` e permite a manipulação dos dados de aluguéis, como buscas e persistências. Um método útil incluído:

### **DTOs**

Utilizamos DTOs para transferir dados entre as camadas da aplicação:

- **`AluguelRequestDTO`**: Utilizado para capturar os dados necessários ao criar ou atualizar um aluguel.
- **`AluguelDTO`**: Usado para expor os dados dos aluguéis ao cliente, como datas, valor total, carro, apólice e motorista.

### **Controlador REST (`AluguelController`)**

O `AluguelController` expõe uma API REST que permite operações CRUD (Create, Read, Update, Delete) sobre os aluguéis. Os principais endpoints são:

- **`GET /listar`**: Retorna uma lista de todos os aluguéis.
- **`POST /create`**: Cria um novo aluguel.
- **`PUT /update`**: Atualiza um aluguel existente.
- **`DELETE /deletar`**: Deleta um aluguel do sistema.

## Estrutura da Apólice de Seguro

### **Modelo (`ApoliceSeguroModel`)**

A classe `ApoliceSeguroModel` possui uma relação `OneToOne` com a entidade `AluguelModel` e representa as informações de seguro de um veículo no sistema. Atributos principais incluem:

- **`valorFranquia`**: Representa o valor da franquia do seguro.
- **`protecaoTerceiro`**: Indica se há proteção para terceiros.
- **`protecaoCausasNaturais`**: Indica se há proteção contra causas naturais.
- **`protecaoRoubo`**: Indica se há proteção contra roubo.

### **Serviço (`ApoliceSeguroServiceImpl`)**

A classe `ApoliceSeguroServiceImpl` implementa a interface `ApoliceSeguroService` e contém a lógica de negócio para as operações relacionadas às apólices de seguro, como:

- **`createApoliceSeguro`**: Cria uma nova apólice de seguro no banco de dados.
- **`listarApoliceSeguro`**: Retorna uma lista com todas as apólices de seguro registradas.
- **`updateApoliceSeguro`**: Atualiza uma apólice de seguro existente com base em seu ID.
- **`deleteApoliceSeguro`**: Deleta uma apólice de seguro com base em seu ID.

### **Repositório (`ApoliceSeguroRepository`)**

O `ApoliceSeguroRepository` é uma interface que estende `JpaRepository` e permite a manipulação dos dados das apólices de seguro, como buscas e persistências.

### **DTOs**

Utilizamos DTOs para transferir dados entre as camadas da aplicação:

- **`ApoliceSeguroRequestDTO`**: Utilizado para capturar os dados necessários ao criar ou atualizar uma apólice de seguro.
- **`ApoliceSeguroDTO`**: Usado para expor os dados das apólices de seguro ao cliente, como `valorFranquia`, `protecaoTerceiro`, `protecaoCausasNaturais`, e `protecaoRoubo`.

### **Controlador REST (`ApoliceSeguroController`)**

O `ApoliceSeguroController` expõe uma API REST que permite operações CRUD (Create, Read, Update, Delete) sobre as apólices de seguro. Os principais endpoints são:

- **`GET /listar`**: Retorna uma lista com todas as apólices de seguro.
- **`POST /create`**: Cria uma nova apólice de seguro.
- **`PUT /update`**: Atualiza uma apólice de seguro existente.
- **`DELETE /deletar`**: Deleta uma apólice de seguro com base no seu ID.

## Documentação
### Swagger

[Documentação em Swagger](http://localhost:9090/swagger-ui/index.html#/)

## MySQL

### Altere dentro de application.properties seus valores para conexão do banco de dados
- **`server.port=9090`**
- **`spring.datasource.url=jdbc:mysql://localhost:3306/locadora-carros`**
- **`spring.datasource.username=root`**
- **`spring.datasource.password=123456789`**






