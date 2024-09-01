package com.example.api.dtos;

import java.math.BigDecimal;

public record ApoliceSeguroRequestDTO(
        BigDecimal valorFranquia,
        boolean protecaoTerceiro,
        boolean protecaoCausasNaturais,
        boolean protecaoRoubo) {
}