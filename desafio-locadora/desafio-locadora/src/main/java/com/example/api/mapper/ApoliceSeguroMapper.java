package com.example.api.mapper;

import com.example.api.dtos.ApoliceSeguroDTO;
import com.example.domain.entity.ApoliceSeguroModel;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApoliceSeguroMapper {
    public ApoliceSeguroDTO convertToApoliceSeguroDTO(ApoliceSeguroModel apoliceSeguroModel) {
        return new ApoliceSeguroDTO(apoliceSeguroModel.getValorFranquia(),
                apoliceSeguroModel.isProtecaoTerceiro(),
                apoliceSeguroModel.isProtecaoCausasNaturais(),apoliceSeguroModel.isProtecaoRoubo());
    }
}
