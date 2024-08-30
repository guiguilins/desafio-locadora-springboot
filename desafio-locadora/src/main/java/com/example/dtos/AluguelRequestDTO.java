package com.example.dtos;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.entity.ApoliceSeguroModel;
import com.example.entity.CarroModel;
import com.example.entity.MotoristaModel;

public record AluguelRequestDTO(Calendar dataPedido, Date dataEntrega, Date dataDevolucao, BigDecimal valorTotal, CarroModel carro, ApoliceSeguroModel apolice, MotoristaModel motorista) {
}