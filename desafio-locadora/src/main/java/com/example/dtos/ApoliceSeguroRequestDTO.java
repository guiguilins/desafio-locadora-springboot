package com.example.dtos;

import java.math.BigDecimal;

public record ApoliceSeguroRequestDTO(BigDecimal valorFranquia, boolean protecaoTerceiro, boolean protecaoCausasNaturais, boolean protecaoRoubo) {
}