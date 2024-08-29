package com.example.domain.entity;

import com.example.api.dtos.PessoaRequestDTO;
import com.example.domain.enums.Sexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@Entity
@Table(name = "pessoa")
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@EqualsAndHashCode(of = "id")
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private Sexo sexo;

    public PessoaModel(PessoaRequestDTO data){
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dataNascimento = data.dataNascimente();
        this.sexo = data.sexo();
    }
}
