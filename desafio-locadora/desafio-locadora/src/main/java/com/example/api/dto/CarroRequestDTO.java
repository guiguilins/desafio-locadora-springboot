package com.example.api.dto;

import java.math.BigDecimal;

public record CarroRequestDTO(String placa, String chassi, String cor, BigDecimal valorDiaria) {
}
