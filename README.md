# desafio-locadora-springboot

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

