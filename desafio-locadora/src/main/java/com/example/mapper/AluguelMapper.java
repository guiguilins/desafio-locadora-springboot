package com.example.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.dtos.AluguelDTO;
import com.example.entity.AluguelModel;

@Component
public class AluguelMapper {

    @Autowired
    private ModelMapper modelMapper;

    public AluguelDTO convertToAluguelDTO (AluguelModel aluguelModel) {
        return new AluguelDTO(
            aluguelModel.getDataPedido(),
            aluguelModel.getDataEntrega(),
            aluguelModel.getDataDevolucao(),
            aluguelModel.getValorTotal(),
            aluguelModel.getCarro(),
            aluguelModel.getApolice(),
            aluguelModel.getMotorista()
        );
    }
}