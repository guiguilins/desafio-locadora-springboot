package com.example.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.api.dtos.AluguelDTO;
import com.example.domain.service.AluguelService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


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
}