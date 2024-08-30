package com.example.dtos;

import java.util.Date;

import com.example.enums.Sexo;

public record PessoaRequestDTO (String nome, String cpf, Date dataNascimento,Sexo sexo){
}
