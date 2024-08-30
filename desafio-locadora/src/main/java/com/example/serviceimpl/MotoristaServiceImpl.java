package com.example.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.MotoristaDTO;
import com.example.entity.MotoristaModel;
import com.example.mapper.MotoristaMapper;
import com.example.repository.MotoristaRepository;
import com.example.service.MotoristaService;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private MotoristaMapper motoristaMapper;

    @Override
    public MotoristaModel createMotorista(MotoristaModel motoristaModel) {
        return this.motoristaRepository.save(motoristaModel);
    }

    @Override
    public List<MotoristaDTO> listarMotoristas() {
        List<MotoristaModel> motoristas = motoristaRepository.findAll();

        return motoristas.stream()
                .map(motoristaMapper::convertToMotoristaDTO)
                .collect(Collectors.toList());
    }
}