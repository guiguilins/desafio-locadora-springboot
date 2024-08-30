package com.example.api.controller;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.service.serviceimpl.MotoristaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("locadora/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaServiceImpl motoristaService;

    @GetMapping("/listar")
    public ResponseEntity<List<MotoristaDTO>> listarMotorista() {
        List<MotoristaDTO> motoristaDTOs = motoristaService.listarMotoristas();
        return new ResponseEntity<>(motoristaDTOs, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<MotoristaModel> createMotorista(@RequestBody MotoristaModel motoristaModel){
        MotoristaModel motorista = this.motoristaService.createMotorista(motoristaModel);
        return new ResponseEntity<MotoristaModel>(motorista, HttpStatus.CREATED);
    }

}
