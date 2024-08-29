package com.example.domain.service.serviceimpl;

import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.MotoristaRepository;
import com.example.domain.service.CreateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoristaServiceImpl implements CreateObject {
    @Autowired
    MotoristaRepository motoristaRepository;

    @Override
    public MotoristaModel createMotorista(MotoristaModel motoristaModel) {
        MotoristaModel motoristaSave = this.motoristaRepository.save(motoristaModel);
        return motoristaSave;
    }
}
