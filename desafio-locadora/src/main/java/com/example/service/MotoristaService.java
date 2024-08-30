package com.example.service;

import java.util.List;

import com.example.dtos.MotoristaDTO;
import com.example.entity.MotoristaModel;

public interface MotoristaService {
    public MotoristaModel createMotorista(MotoristaModel motorista);
    public List<MotoristaDTO> listarMotoristas();
}
