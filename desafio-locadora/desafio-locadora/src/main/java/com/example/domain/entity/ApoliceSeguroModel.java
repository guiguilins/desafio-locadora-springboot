package com.example.domain.entity;

import java.math.BigDecimal;

import com.example.api.dtos.ApoliceSeguroRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "apolice_seguro")
public class ApoliceSeguroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private BigDecimal valorFranquia;

    @NotNull
    private Boolean protecaoTerceiro;

    @NotNull
    private Boolean protecaoCausasNaturais;

    @NotNull
    private Boolean protecaoRoubo;

    @OneToOne(mappedBy = "apolice")
    @JsonIgnore
    private AluguelModel aluguel;

    public ApoliceSeguroModel(ApoliceSeguroRequestDTO data) {
        this.valorFranquia = data.valorFranquia();
        this.protecaoTerceiro = data.protecaoTerceiro();
        this.protecaoCausasNaturais = data.protecaoCausasNaturais();
        this.protecaoRoubo = data.protecaoRoubo();
    }
    
    public ApoliceSeguroModel(BigDecimal valorFranquia, Boolean protecaoTerceiro, Boolean protecaoCausasNaturais, Boolean protecaoRoubo) {
        this.valorFranquia = valorFranquia;
        this.protecaoTerceiro = protecaoTerceiro;
        this.protecaoCausasNaturais = protecaoCausasNaturais;
        this.protecaoRoubo = protecaoRoubo;
    }
}