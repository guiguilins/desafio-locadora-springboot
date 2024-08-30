package com.example.controller;

import com.example.entity.CarroModel;
import com.example.serviceimpl.CarroServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroServiceImpl carroService;

    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroModel>> listarCarrosDisponiveis() {
        List<CarroModel> carrosDisponiveis = carroService.listarCarros();
        return ResponseEntity.ok(carrosDisponiveis);
    }
}
