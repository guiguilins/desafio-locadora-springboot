package com.example.api.dtos;

import com.example.domain.entity.PessoaModel;
import com.example.domain.enums.Sexo;

import java.util.Date;

public record PessoaDTO(Long id, String nome, String cpf, Date dataNascimento, Sexo sexo) {
    public PessoaDTO(PessoaModel pessoa){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(),pessoa.getDataNascimento(),pessoa.getSexo());
    }
}
