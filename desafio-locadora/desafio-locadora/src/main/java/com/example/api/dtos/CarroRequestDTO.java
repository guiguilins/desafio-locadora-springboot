package com.example.api.dtos;

import com.example.domain.entity.AcessoriosModel;
import com.example.domain.entity.AluguelModel;
import com.example.domain.entity.ModeloCarroModel;

import java.math.BigDecimal;
import java.util.List;

public record CarroRequestDTO(String placa, String chassi, String cor, BigDecimal valorDiaria, List<AcessoriosModel> acessorios,
                              ModeloCarroModel modelo, List<AluguelModel> alugueis) {
}