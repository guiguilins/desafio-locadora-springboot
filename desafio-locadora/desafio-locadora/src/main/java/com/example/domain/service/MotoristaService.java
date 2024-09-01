package com.example.domain.service;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;

import java.util.List;

public interface MotoristaService {
    MotoristaModel createMotorista(MotoristaModel motorista);

    List<MotoristaDTO> listarMotoristas();

    MotoristaDTO updateMotorista(MotoristaDTO motoristaDTO);

    MotoristaDTO deleteMotorista(MotoristaDTO motoristaDTO);
}
