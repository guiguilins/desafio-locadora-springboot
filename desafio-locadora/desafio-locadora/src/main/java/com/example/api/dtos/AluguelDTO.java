package com.example.api.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.domain.entity.AluguelModel;

public record AluguelDTO(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal) {
    public AluguelDTO(AluguelModel aluguel) {
        this(aluguel.getDataPedido(), aluguel.getDataEntrega(), aluguel.getDataDevolucao(), aluguel.getValorTotal());
    }
}
