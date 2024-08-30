package com.example.mapper;

import com.example.dtos.MotoristaDTO;
import com.example.entity.MotoristaModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

    @Autowired
    private ModelMapper modelMapper;

    public MotoristaDTO convertToMotoristaDTO(MotoristaModel motoristaModel){
        return new MotoristaDTO(
                motoristaModel.getNome(),
                motoristaModel.getCpf(),
                motoristaModel.getDataNascimento(),
                motoristaModel.getSexo(),
                motoristaModel.getNumeroCNH()
        );
    }
}