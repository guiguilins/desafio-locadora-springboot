package com.example.api.controller;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroDisponivelDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.entity.CarroModel;
import com.example.domain.enums.Categoria;
import com.example.domain.service.CarroService;
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
    public ResponseEntity<List<CarroDTO>> listarCarros() {
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

    @GetMapping("/filtros/disponiveis")
    public ResponseEntity<List<CarroDisponivelDTO>> listarCarrosDisponiveisParaAluguel(
            @RequestParam(required = false) String fabricante,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) Categoria categoria,
            @RequestParam(required = false) List<Long> acessorios) {

        List<CarroDisponivelDTO> carrosDisponiveis = carroService.listarCarrosDisponiveisParaAluguel(fabricante, modelo, categoria, acessorios);
        return new ResponseEntity<>(carrosDisponiveis, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirPorId(@PathVariable Long id) {
        carroService.excluirPorId(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
