package com.example.domain.service;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.entity.CarroModel;
import com.example.domain.enums.Categoria;


import java.util.List;

public interface CarroService {
    public List<CarroDTO> listarCarros();

    public CarroModel salvarCarro(CarroRequestDTO data);

    public List<CarroModel> filtrarCarros(Categoria categoria, List<Long> acessoriosIds);
}
