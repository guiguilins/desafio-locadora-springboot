package com.example.dtos;

import com.example.entity.PessoaModel;
import com.example.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

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
