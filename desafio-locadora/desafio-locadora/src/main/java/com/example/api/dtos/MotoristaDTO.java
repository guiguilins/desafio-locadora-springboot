package com.example.api.dtos;

import com.example.domain.entity.MotoristaModel;
import com.example.domain.entity.PessoaModel;
import com.example.domain.enums.Sexo;

import java.util.Date;

public record MotoristaDTO(Long id, String nome, String cpf, Date dataNascimento, Sexo sexo, String cnh) {
    public MotoristaDTO(PessoaModel pessoa,String cnh){
        this(pessoa.getId(), pessoa.getNome(), pessoa.getCpf(),pessoa.getDataNascimento(),pessoa.getSexo(),cnh);
    }
}
