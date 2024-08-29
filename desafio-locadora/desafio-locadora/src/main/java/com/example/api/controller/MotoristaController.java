package com.example.api.controller;

import com.example.domain.entity.MotoristaModel;
import com.example.domain.service.serviceimpl.MotoristaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("locadora/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaServiceImpl motoristaService;
    @PostMapping("/create")
    public ResponseEntity<MotoristaModel> createMotorista(@RequestBody MotoristaModel motoristaModel){
        MotoristaModel motorista = this.motoristaService.createMotorista(motoristaModel);
        return new ResponseEntity<MotoristaModel>(motorista, HttpStatus.CREATED);
    }
}
