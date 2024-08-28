package com.example.api.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record AluguelRequestDTO(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
}
