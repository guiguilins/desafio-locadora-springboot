package com.example.api.controller;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.entity.CarroModel;
import com.example.domain.enums.Categoria;
import com.example.domain.service.CarroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carros")
public class CarroController {

    @Autowired
    private CarroService carroService;

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

    @GetMapping("/filtros")
    public ResponseEntity<List<CarroModel>> filtrarCarros(
            @RequestParam(required = false) Categoria categoria,
            @RequestParam(required = false) List<Long> acessoriosIds) {

        List<CarroModel> carrosFiltrados = carroService.filtrarCarros(categoria, acessoriosIds);
        return new ResponseEntity<>(carrosFiltrados, HttpStatus.OK);
    }
}
