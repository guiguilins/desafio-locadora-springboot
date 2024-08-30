package com.example.api.controller;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.service.serviceimpl.CarroServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroServiceImpl carroService;

    @GetMapping("/disponiveis")
    public ResponseEntity<List<CarroDTO>> listarCarrosDisponiveis() {
        List<CarroDTO> carrosDisponiveis = carroService.listarCarros();
        return new ResponseEntity<>(carrosDisponiveis, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CarroModel> criarCarro(@RequestBody CarroRequestDTO carroRequestDTO) {
        CarroModel carro = carroService.salvarCarro(carroRequestDTO);
        return new ResponseEntity<CarroModel>(carro, HttpStatus.CREATED);
    }
}
