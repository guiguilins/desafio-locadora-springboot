package com.example.api.controller;

import com.example.domain.entity.CarroModel;
import com.example.domain.service.serviceimpl.CarroServiceImpl;
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
