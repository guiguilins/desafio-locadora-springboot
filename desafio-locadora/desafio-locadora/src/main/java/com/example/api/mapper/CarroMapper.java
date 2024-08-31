package com.example.api.mapper;

import com.example.api.dtos.AcessorioDTO;
import com.example.api.dtos.CarroDTO;
import com.example.domain.entity.CarroModel;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CarroMapper {

    public CarroDTO convertToCarroDTO(CarroModel carroModel){
        return new CarroDTO(
                carroModel.getPlaca(),
                carroModel.getChassi(),
                carroModel.getCor(),
                carroModel.getValorDiaria(),
                carroModel.getAcessorios().stream().map(AcessorioDTO::new).collect(Collectors.toList()),
                carroModel.getModelo(),
                carroModel.getAlugueis());
    }
}


