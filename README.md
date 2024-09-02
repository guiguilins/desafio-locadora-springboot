# Desafio Locadora de Veículos - Spring Boot - Squad 10

### Participantes

- Gerson Fragoso
- Guilherme
- João Victor
- Daniel
- Samuel

## Estrutura do Motorista

### 1. **Modelo (`MotoristaModel`)**

A classe `MotoristaModel` estende a `PessoaModel` e representa as informações de um motorista no sistema. Atributos principais incluem:

- **`numeroCNH`**: Número da CNH.

### 2. **Serviço (`MotoristaServiceImpl`)**

A classe `MotoristaServiceImpl` implementa a interface `MotoristaService` e contém a lógica de negócio para as operações com motoristas, como:

- **Criar motorista**: Salva um novo motorista no banco de dados.
- **Listar motoristas**: Retorna todos os motoristas registrados.
- **Atualizar motorista**: Modifica as informações de um motorista existente.
- **Deletar motorista**: Remove um motorista do banco de dados.

### 3. **Repositório (`MotoristaRepository`)**

O `MotoristaRepository` é uma interface que estende `JpaRepository` e permite a manipulação dos dados dos motoristas, como buscas e persistências. Um método útil incluído:

- **`findByCpf`**: Busca um motorista pelo CPF.

### 4. **DTOs**

Utilizamos DTOs para transferir dados entre as camadas da aplicação:

- **`MotoristaRequestDTO`**: Utilizado para capturar os dados necessários ao criar ou atualizar um motorista.
- **`MotoristaDTO`**: Usado para expor os dados dos motoristas ao cliente, como nome, CPF, data de nascimento, sexo e CNH.

### 5. **Controlador REST (`MotoristaController`)**

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