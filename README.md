# Desafio Locadora de Veículos - Spring Boot - Squad 10

### Participantes

- Gerson Fragoso
- Guilherme
- João Victor
- Karen
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

# Exemplos de Uso


```sh
Criar um motorista:
POST /locadora/motorista/create
{
  "nome": "João da Silva",
  "cpf": "12345678900",
  "dataNascimento": "1990-01-01",
  "sexo": "MASCULINO",
  "numeroCNH": "123456789"
}


Listar motorista:
GET /locadora/motorista/listar
 {
    "nome": "string",
    "cpf": "string",
    "dataNascimento": "2024-09-02",
    "sexo": "MASCULINO",
    "cnh": "string"
  }

Deletar motorista:
DELETE /locadora/motorista/deletar
{
  "cpf": "12345678900"
}

Atualizar motorista:
PUT /locadora/motorista/update
{
      "cpf": "12345678900"
      //E os campos que deseja atualizar
}
```

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

# Exemplos de Uso

```sh
Criar um carro:
POST /carro/create

{
    "placa": "XAOC-5422",
    "chassi": "XYZ987654321",
    "cor": "Amarelo",
    "valorDiaria": 250.00,
    "acessorios": [
        {
            "acessorio": "Ar-condicionado"
        },
        {
            "acessorio": "Direção hidráulica"
        }
    ],
    "modelo": {
        "descricao": "Uno",
        "categoria": "HATCH_MEDIO",
        "fabricante": {
            "nome": "Fiat"
        }
    }
   
}

Listar carros com todas as descrições:
GET /carro/geral
 {
      {
        "placa": "ABC1234",
        "chassi": "534764",
        "cor": "Azul",
        "valorDiaria": 123.00,
        "acessorios": [
            {
                "acessorio": "Ar-condicionado"
            },
            {
                "acessorio": "Direção hidráulica"
            }
        ],
        "modelo": {
            "descricao": "Picape",
            "categoria": "ESPORTIVO",
            "fabricante": {
                "nome": "Volkswagen"
            }
          }
      }
  }

Listar carros disponíveis para aluguel

GET /carro/aluguel/disponiveis

{
        "fabricante": "Volkswagen",
        "modelo": "Picape",
        "categoria": "ESPORTIVO",
        "acessorios": [
            "Ar-condicionado",
            "Direção hidráulica"
        ]
    }

Filtrar carros de acordo com seus acessoriosId ou sua categoria

GET /carros/filtros

Categoria: /carros/filtros?categoria=ESPORTIVO

acessoriosId: /carros/filtros?acessoriosId=1,2


Deletar carro:
DELETE /carro/deletar/{id}
{
  Carro deletado com sucesso!
}

Atualizar carro:
PUT /carro/atualizar/{id}
{
        "placa": "XAOC-5422",
        "cor": "Amarelo",
        "valorDiaria": 250.00
      //E os campos que deseja atualizar
}
```