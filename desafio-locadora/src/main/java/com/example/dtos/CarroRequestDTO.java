package com.example.dtos;

import java.math.BigDecimal;
import java.util.List;

import com.example.entity.AcessoriosModel;
import com.example.entity.AluguelModel;
import com.example.entity.ModeloCarroModel;

public record CarroRequestDTO(String placa, String chassi, String cor, BigDecimal valorDiaria, List<AcessoriosModel> acessorios,
                              ModeloCarroModel modelo, List<AluguelModel> alugueis) {
}