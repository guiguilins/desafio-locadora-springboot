package com.example.dtos;

import java.util.Date;

import com.example.enums.Sexo;

public record MotoristaRequestDTO(String nome, String cpf, Date dataNascimento, Sexo sexo, String numeroCNH){
    public MotoristaRequestDTO(PessoaRequestDTO pessoaRequest, String numeroCNH) {
        this(pessoaRequest.nome(), pessoaRequest.cpf(), pessoaRequest.dataNascimento(), pessoaRequest.sexo(), numeroCNH);
    }
}
