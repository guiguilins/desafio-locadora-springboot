package com.example.domain.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "funcionario")
public class FuncionarioModel extends PessoaModel {

    @NotBlank
    private String matricula;
}