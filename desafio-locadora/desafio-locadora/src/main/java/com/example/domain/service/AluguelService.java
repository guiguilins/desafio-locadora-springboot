package com.example.domain.service;

import java.util.List;

import com.example.api.dtos.AluguelDTO;
import com.example.api.dtos.AluguelRequestDTO;
import com.example.domain.entity.AluguelModel;

public interface AluguelService {
    public List<AluguelDTO> listarAlugueis();

    public void deletarAluguel(Long id);

    public AluguelModel contratoAluguel(AluguelRequestDTO data);

    public AluguelModel updateAluguel(Long id, AluguelRequestDTO data);
}