package com.example.api.dtos;

import java.math.BigDecimal;

import com.example.domain.entity.ApoliceSeguroModel;

public record ApoliceSeguroDTO(BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {

    public ApoliceSeguroDTO(ApoliceSeguroModel apolice) {
        this(apolice.getValorFranquia(), apolice.isProtecaoTerceiro(), apolice.isProtecaoCausasNaturais(), apolice.isProtecaoRoubo());
    }
}