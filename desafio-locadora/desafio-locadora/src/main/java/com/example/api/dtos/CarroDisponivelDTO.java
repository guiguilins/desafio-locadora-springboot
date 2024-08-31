package com.example.api.dtos;

import com.example.domain.entity.AcessorioModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.enums.Categoria;

import java.util.List;
import java.util.stream.Collectors;

public record CarroDisponivelDTO(
       String fabricante,
       String modelo,
       Categoria categoria,
       List<String> acessorios) {

    public CarroDisponivelDTO(CarroModel carro) {
        this(carro.getModelo().getFabricante().getNome(),
                carro.getModelo().getDescricao(),
                carro.getModelo().getCategoria(),
                carro.getAcessorios().stream().map(AcessorioModel::getAcessorios).collect(Collectors.toList())
        );
    }
}