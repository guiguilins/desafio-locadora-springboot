package com.example.domain.service.serviceimpl;

import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.CarroRepository;
import com.example.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroModel> listarCarros() {
        return this.carroRepository.findAll();
    }
}
