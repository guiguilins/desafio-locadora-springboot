package com.example.api.dtos;

import com.example.domain.entity.PessoaModel;
import com.example.domain.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public record MotoristaDTO(
        String nome,
        String cpf,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dataNascimento,
        Sexo sexo,
        String cnh) {

    public MotoristaDTO(PessoaModel pessoa, String cnh){
        this(pessoa.getNome(), pessoa.getCpf(), pessoa.getDataNascimento(), pessoa.getSexo(), cnh);
    }
}
