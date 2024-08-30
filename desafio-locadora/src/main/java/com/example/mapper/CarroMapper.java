package com.example.mapper;

import com.example.dtos.CarroDTO;
import com.example.entity.CarroModel;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CarroMapper {

    @Autowired
    private ModelMapper modelMapper;

    public CarroDTO convertToCarroDTO(CarroModel carroModel) {
        return modelMapper.map(carroModel, CarroDTO.class);
    }
}
