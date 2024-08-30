package com.example.api.mapper;

import com.example.api.dtos.ApoliceSeguroDTO;
import com.example.domain.entity.ApoliceSeguroModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApoliceSeguroMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ApoliceSeguroDTO convertToApoliceSeguroDTO(ApoliceSeguroModel apoliceSeguroModel) {
        return modelMapper.map(apoliceSeguroModel, ApoliceSeguroDTO.class);
    }
}
