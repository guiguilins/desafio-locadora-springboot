package com.example.domain.service;

import com.example.api.dtos.ApoliceSeguroDTO;
import com.example.domain.entity.ApoliceSeguroModel;

import java.util.List;

public interface ApoliceSeguroService {
    ApoliceSeguroModel createApoliceSeguro(ApoliceSeguroModel apoliceSeguro);
    List<ApoliceSeguroDTO> listarApoliceSeguro();
    ApoliceSeguroDTO updateApoliceSeguro(Long id, ApoliceSeguroDTO apoliceSeguroDTO);
    void deleteApoliceSeguro(Long id);
}
