package com.example.api.mapper;

import com.example.api.dtos.MotoristaDTO;
import com.example.domain.entity.MotoristaModel;
import org.springframework.stereotype.Component;

@Component
public class MotoristaMapper {

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