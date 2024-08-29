package com.example.api.mapper;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MotoristaDTO convertToMotoristaDTO(MotoristaModel motoristaModel){
        return modelMapper.map(motoristaModel, MotoristaDTO.class);
    }
}
