package com.example.domain.service;

import java.util.List;

import com.example.api.dtos.AluguelDTO;
import com.example.api.dtos.AluguelRequestDTO;
import com.example.domain.entity.AluguelModel;

public interface AluguelService {
    List<AluguelDTO> listarAlugueis();

    void deletarAluguel(Long id);

    AluguelModel contratoAluguel(AluguelRequestDTO data);

    AluguelModel updateAluguel(Long id, AluguelRequestDTO data);
}