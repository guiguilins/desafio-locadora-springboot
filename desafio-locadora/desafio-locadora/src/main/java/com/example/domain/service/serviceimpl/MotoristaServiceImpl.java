package com.example.domain.service.serviceimpl;

import com.example.api.dtos.MotoristaDTO;
import com.example.api.mapper.MotoristaMapper;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.MotoristaRepository;
import com.example.domain.service.MotoristaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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