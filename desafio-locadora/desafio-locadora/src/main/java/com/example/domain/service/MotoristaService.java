package com.example.domain.service;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;

import java.util.List;

public interface MotoristaService {
    public MotoristaModel createMotorista(MotoristaModel motorista);

    public List<MotoristaDTO> listarMotoristas();

    public MotoristaDTO updateMotorista(MotoristaDTO motoristaDTO);

    public MotoristaDTO deleteMotorista(MotoristaDTO motoristaDTO);
}
