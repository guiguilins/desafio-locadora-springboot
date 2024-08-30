package com.example.api.dtos;

import com.example.domain.entity.AcessorioModel;

public record AcessorioDTO(String acessorio) {
    public AcessorioDTO(AcessorioModel acessorioModel) {
        this(acessorioModel.getAcessorios());
    }

}
