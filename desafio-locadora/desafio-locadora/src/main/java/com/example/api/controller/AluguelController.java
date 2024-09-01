package com.example.api.controller;

import java.util.List;

import com.example.api.dtos.AluguelRequestDTO;
import com.example.domain.entity.AluguelModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.api.dtos.AluguelDTO;
import com.example.domain.service.AluguelService;


@RestController
@RequestMapping("/aluguel")
public class AluguelController {

    @Autowired
    private AluguelService aluguelService;

    @GetMapping("/listar")
    public ResponseEntity<List<AluguelDTO>> listarAlugueis() {
        List<AluguelDTO> aluguelDTOs = aluguelService.listarAlugueis();
        return new ResponseEntity<>(aluguelDTOs, HttpStatus.OK);
    }

    @DeleteMapping(value = "/deletar/{id}")
    public ResponseEntity<String> deletarAluguel(@PathVariable("id") Long id) {
        try {
            aluguelService.deletarAluguel(id);
            return ResponseEntity.status(HttpStatus.OK).body("Aluguel deletado com sucesso!");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluguel não encontrado.");
        }
    }

    @PostMapping("/create")
    public ResponseEntity<AluguelModel> contratoAluguel(@RequestBody AluguelRequestDTO aluguelRequestDTO) {
        AluguelModel aluguel = aluguelService.contratoAluguel(aluguelRequestDTO);
        return new ResponseEntity<>(aluguel, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<AluguelModel> atualizarAluguel(@PathVariable Long id, @RequestBody AluguelRequestDTO aluguelRequestDTO) {
        AluguelModel aluguelAtualizado = aluguelService.updateAluguel(id, aluguelRequestDTO);
        return new ResponseEntity<>(aluguelAtualizado, HttpStatus.OK);
    }
}