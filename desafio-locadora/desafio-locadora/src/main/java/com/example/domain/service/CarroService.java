package com.example.domain.service;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroDisponivelDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.enums.Categoria;


import java.util.List;

public interface CarroService {
    List<CarroDTO> listarCarros();

    CarroDTO salvarCarro(CarroRequestDTO data);

    List<CarroDTO> filtrarCarros(Categoria categoria, List<Long> acessoriosIds);

    List<CarroDisponivelDTO> listarCarrosDisponiveisParaAluguel(String fabricante, String modelo, Categoria categoria, List<Long> acessorios);

    CarroDTO atualizarCarro(Long id, CarroDTO carroDTO);

    void deletarPorId(Long id);
}
