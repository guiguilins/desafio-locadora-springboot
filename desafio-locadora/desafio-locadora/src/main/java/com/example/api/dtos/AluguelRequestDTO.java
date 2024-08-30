package com.example.api.dtos;

import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

public record AluguelRequestDTO(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, CarroModel carro, ApoliceSeguroModel apolice, MotoristaModel motorista) {
}