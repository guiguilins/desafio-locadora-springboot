package com.example.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.CarroModel;
import com.example.repository.CarroRepository;
import com.example.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public List<CarroModel> listarCarros() {
        return this.carroRepository.findAll();
    }
}
