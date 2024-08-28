package com.example.api.dtos;

import com.example.domain.enums.Sexo;

import java.util.Date;

public record PessoaRequestDTO (String nome, String cpf, Date dataNascimente,Sexo sexo){
}
