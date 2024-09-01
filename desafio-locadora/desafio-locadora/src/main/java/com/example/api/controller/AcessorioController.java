package com.example.api.controller;

import com.example.domain.entity.AcessorioModel;
import com.example.domain.service.serviceimpl.AcessorioServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/acessorio")
public class AcessorioController {

    @Autowired
    private AcessorioServiceImpl acessorioService;

    @PostMapping("/create")
    public ResponseEntity<AcessorioModel> createAcessorio(@RequestBody AcessorioModel acessorioModel){
        AcessorioModel acessorio = this.acessorioService.createAcessorio(acessorioModel);
        return new ResponseEntity<AcessorioModel>(acessorio, HttpStatus.CREATED);
    }

}
