package com.example.domain.service.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.domain.entity.AcessorioModel;
import com.example.domain.repository.AcessorioRepository;
import com.example.domain.service.AcessorioService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AcessorioServiceImpl implements AcessorioService {

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Override
    public AcessorioModel createAcessorio(AcessorioModel acessorioModel) {
        return this.acessorioRepository.save(acessorioModel);
    }
}
