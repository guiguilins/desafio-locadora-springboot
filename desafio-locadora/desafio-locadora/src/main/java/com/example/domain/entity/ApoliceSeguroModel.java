package com.example.domain.entity;

import java.math.BigDecimal;

import com.example.api.dtos.ApoliceSeguroRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "apolice_seguro")
public class ApoliceSeguroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private BigDecimal valorFranquia;

    @NotNull
    private boolean protecaoTerceiro;

    @NotNull
    private boolean protecaoCausasNaturais;

    @NotNull
    private boolean protecaoRoubo;

    @OneToOne(mappedBy = "apolice")
    @JsonIgnore
    private AluguelModel aluguel;

    public ApoliceSeguroModel(ApoliceSeguroRequestDTO data) {
        this.valorFranquia = data.valorFranquia();
        this.protecaoTerceiro = data.protecaoTerceiro();
        this.protecaoCausasNaturais = data.protecaoCausasNaturais();
        this.protecaoRoubo = data.protecaoRoubo();
    }
}