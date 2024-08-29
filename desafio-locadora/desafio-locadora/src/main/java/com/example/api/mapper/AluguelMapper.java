package com.example.api.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.api.dtos.AluguelDTO;
import com.example.domain.entity.AluguelModel;

@Component
public class AluguelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AluguelDTO convertToAluguelDTO (AluguelModel aluguelModel) {
        return modelMapper.map(aluguelModel, AluguelDTO.class);
    }
}