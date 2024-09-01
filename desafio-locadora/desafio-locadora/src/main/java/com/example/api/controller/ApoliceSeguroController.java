package com.example.api.controller;

import com.example.api.dtos.ApoliceSeguroDTO;
import com.example.api.dtos.ApoliceSeguroRequestDTO;
import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.service.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/locadora/apolice")
public class ApoliceSeguroController {

    @Autowired
    private ApoliceSeguroService apoliceSeguroService;

    @GetMapping("/listar")
    public ResponseEntity<List<ApoliceSeguroDTO>> listarApoliceSeguro() {
        List<ApoliceSeguroDTO> apoliceSeguroDTOs = apoliceSeguroService.listarApoliceSeguro();
        return new ResponseEntity<>(apoliceSeguroDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ApoliceSeguroModel> createApoliceSeguro(@RequestBody ApoliceSeguroModel apoliceSeguro) {
        ApoliceSeguroModel createdApolice = apoliceSeguroService.createApoliceSeguro(apoliceSeguro);
        return new ResponseEntity<>(createdApolice, HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ApoliceSeguroDTO> updateApoliceSeguro(@PathVariable Long id, @RequestBody ApoliceSeguroDTO apoliceSeguroDTO) {
        ApoliceSeguroDTO apoliceSeguroAtualizado = apoliceSeguroService.updateApoliceSeguro(id, apoliceSeguroDTO);
        return new ResponseEntity<>(apoliceSeguroAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<Void> deletarApoliceSeguro(@PathVariable Long id) {
        apoliceSeguroService.deleteApoliceSeguro(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
