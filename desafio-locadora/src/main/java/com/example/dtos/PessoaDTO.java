package com.example.dtos;

import com.example.entity.PessoaModel;
import com.example.enums.Sexo;

import java.util.Date;

public record PessoaDTO(Long id, String nome, String cpf, Date dataNascimento, Sexo sexo) {
    public PessoaDTO(PessoaModel pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(),pessoa.getDataNascimento(),pessoa.getSexo());
    }
}
