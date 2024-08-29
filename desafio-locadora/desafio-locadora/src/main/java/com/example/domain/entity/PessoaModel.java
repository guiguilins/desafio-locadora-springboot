package com.example.domain.entity;

import com.example.api.dtos.PessoaRequestDTO;
import com.example.domain.enums.Sexo;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @NotNull
    private Date dataNascimento;
    @NotNull
    @Enumerated
    private Sexo sexo;

    public PessoaModel(PessoaRequestDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dataNascimento = data.dataNascimente();
        this.sexo = data.sexo();
    }
}
