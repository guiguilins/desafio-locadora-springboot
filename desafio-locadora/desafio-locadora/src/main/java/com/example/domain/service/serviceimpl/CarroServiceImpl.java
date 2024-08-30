package com.example.domain.service.serviceimpl;

import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.CarroRepository;
import com.example.domain.service.CreateObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CreateObject {

    @Autowired
    private CarroRepository carroRepository;

    @Override
    public Object createMotorista(MotoristaModel motoristaModel) {
        return null;
    }

    @Override
    public List<CarroModel> listarCarros() {
        return this.carroRepository.findAll();
    }
}
