package com.example.domain.entity;

import com.example.api.dtos.MotoristaRequestDTO;
import com.example.api.dtos.PessoaRequestDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Table(name = "motorista")
public class MotoristaModel extends PessoaModel {

    private String numeroCNH;

    public MotoristaModel(MotoristaRequestDTO data) {
        super(new PessoaRequestDTO(data.nome(), data.cpf(), data.dataNascimente(), data.sexo()));
        this.numeroCNH = data.numeroCNH();
    }
}
