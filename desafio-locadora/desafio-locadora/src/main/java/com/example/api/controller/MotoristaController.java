package com.example.api.controller;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locadora/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping("/listar")
    public ResponseEntity<List<MotoristaDTO>> listarMotorista() {
        List<MotoristaDTO> motoristaDTOs = motoristaService.listarMotoristas();
        return new ResponseEntity<>(motoristaDTOs, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<MotoristaModel> createMotorista(@RequestBody MotoristaModel motoristaModel) {
        MotoristaModel motorista = this.motoristaService.createMotorista(motoristaModel);
        return new ResponseEntity<MotoristaModel>(motorista, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<MotoristaDTO> updateMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motoristaAtualizado = motoristaService.updateMotorista(motoristaDTO);
        return new ResponseEntity<>(motoristaAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/deletar")
    public ResponseEntity<MotoristaDTO> deletarMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motoristaDel = motoristaService.deleteMotorista(motoristaDTO);
        return new ResponseEntity<>(motoristaDel, HttpStatus.OK);
    }
}
