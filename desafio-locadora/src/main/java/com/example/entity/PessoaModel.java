package com.example.entity;

import com.example.dtos.PessoaRequestDTO;
import com.example.enums.Sexo;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataNascimento;
    @NotNull
    @Enumerated
    private Sexo sexo;

    public PessoaModel(PessoaRequestDTO data) {
        this.nome = data.nome();
        this.cpf = data.cpf();
        this.dataNascimento = data.dataNascimento();
        this.sexo = data.sexo();
    }
}
