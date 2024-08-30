package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dtos.AluguelDTO;
import com.example.serviceimpl.AluguelServiceImpl;

import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/aluguel")
public class AluguelController {
    
    @Autowired
    private AluguelServiceImpl aluguelService;

    @GetMapping("/listar")
    public ResponseEntity<List<AluguelDTO>> listarAlugueis() {
        List<AluguelDTO> aluguelDTOs = aluguelService.listarAlugueis();
        return new ResponseEntity<>(aluguelDTOs, HttpStatus.OK) ;
    }
}