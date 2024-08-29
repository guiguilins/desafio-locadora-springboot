package com.example.api.dtos;

import com.example.domain.enums.Sexo;

import java.util.Date;

public record MotoristaRequestDTO(String nome, String cpf, Date dataNascimente, Sexo sexo, String numeroCNH){
    public MotoristaRequestDTO(PessoaRequestDTO pessoaRequest, String numeroCNH) {
        this(pessoaRequest.nome(), pessoaRequest.cpf(), pessoaRequest.dataNascimente(), pessoaRequest.sexo(), numeroCNH);
    }
}
