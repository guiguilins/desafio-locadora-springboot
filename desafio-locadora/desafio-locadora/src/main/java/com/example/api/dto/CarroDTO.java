package com.example.api.dto;

import com.example.domain.entity.CarroModel;

import java.math.BigDecimal;

public record CarroDTO(String placa, String chassi, String cor, BigDecimal valorDiaria) {

public CarroDTO(CarroModel carro) {
    this(carro.getPlaca(), carro.getChassi(), carro.getCor(), carro.getValorDiaria());
}

}
