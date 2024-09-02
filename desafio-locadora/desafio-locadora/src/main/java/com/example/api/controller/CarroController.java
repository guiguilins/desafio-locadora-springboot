package com.example.api.controller;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroDisponivelDTO;
import com.example.api.dtos.CarroRequestDTO;
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

    @GetMapping("/geral")
    public ResponseEntity<List<CarroDTO>> listarCarros() {
        List<CarroDTO> carrosDisponiveis = carroService.listarCarros();
        return new ResponseEntity<>(carrosDisponiveis, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<CarroDTO> criarCarro(@RequestBody CarroRequestDTO carroRequestDTO) {
        CarroDTO carro = carroService.salvarCarro(carroRequestDTO);
        return new ResponseEntity<>(carro, HttpStatus.CREATED);
    }

    @GetMapping("/filtros")
    public ResponseEntity<List<CarroDTO>> filtrarCarros(
            @RequestParam(required = false) Categoria categoria,
            @RequestParam(required = false) List<Long> acessoriosIds) {

        List<CarroDTO> carrosFiltrados = carroService.filtrarCarros(categoria, acessoriosIds);
        return new ResponseEntity<>(carrosFiltrados, HttpStatus.OK);
    }

    @GetMapping("/aluguel/disponiveis")
    public ResponseEntity<List<CarroDisponivelDTO>> listarCarrosDisponiveisParaAluguel(
            @RequestParam(required = false) String fabricante,
            @RequestParam(required = false) String modelo,
            @RequestParam(required = false) Categoria categoria,
            @RequestParam(required = false) List<Long> acessorios) {

        List<CarroDisponivelDTO> carrosDisponiveis = carroService.listarCarrosDisponiveisParaAluguel(fabricante, modelo, categoria, acessorios);
        return new ResponseEntity<>(carrosDisponiveis, HttpStatus.OK);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<CarroDTO> atualizarCarro(@PathVariable Long id, @RequestBody CarroDTO carroDTO) {
        CarroDTO carroAtualizado = carroService.atualizarCarro(id, carroDTO);
        return new ResponseEntity<>(carroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<String> deletarPorId(@PathVariable("id") Long id) {
        carroService.deletarPorId(id);
        return ResponseEntity.status(HttpStatus.OK).body("Carro deletado com sucesso!");
    }
}
