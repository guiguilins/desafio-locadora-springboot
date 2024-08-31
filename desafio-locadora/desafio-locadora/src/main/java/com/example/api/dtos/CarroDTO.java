package com.example.api.dtos;

import com.example.domain.entity.AcessorioModel;
import com.example.domain.entity.AluguelModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.ModeloCarroModel;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public record CarroDTO(
        String placa,
        String chassi,
        String cor,
        BigDecimal valorDiaria,
        List<AcessorioDTO> acessorios,
        ModeloCarroModel modelo,
        List<AluguelModel> alugueis) {

    public CarroDTO(CarroModel carro) {
        this(carro.getPlaca(),
                carro.getChassi(),
                carro.getCor(),
                carro.getValorDiaria(),
                carro.getAcessorios().stream().map(AcessorioDTO::new).collect(Collectors.toList()),
                carro.getModelo(),
                carro.getAlugueis());
    }
}