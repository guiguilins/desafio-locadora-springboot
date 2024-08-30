package com.example.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dtos.AluguelDTO;
import com.example.entity.AluguelModel;
import com.example.mapper.AluguelMapper;
import com.example.repository.AluguelRepository;
import com.example.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private AluguelMapper aluguelMapper;

    @Override
    public List<AluguelDTO> listarAlugueis() {
        List<AluguelModel> alugueis = aluguelRepository.findAll();

        return alugueis.stream()
                .map(aluguelMapper::convertToAluguelDTO)
                .collect(Collectors.toList());
    }
}