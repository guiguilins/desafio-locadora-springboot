package com.example.api.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.domain.entity.AluguelModel;
import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.fasterxml.jackson.annotation.JsonFormat;

public record AluguelDTO(
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Calendar dataPedido,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dataEntrega,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd") Date dataDevolucao,
        BigDecimal valorTotal,
        CarroModel carro,
        ApoliceSeguroModel apolice,
        MotoristaModel motorista) {

    public AluguelDTO(AluguelModel aluguel, CarroModel carro, ApoliceSeguroModel apolice, MotoristaModel motorista) {
        this(aluguel.getDataPedido(), aluguel.getDataEntrega(), aluguel.getDataDevolucao(), aluguel.getValorTotal(), carro, apolice, motorista);
    }
}