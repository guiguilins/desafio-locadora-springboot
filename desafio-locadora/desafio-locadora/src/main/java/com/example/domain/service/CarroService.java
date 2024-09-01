package com.example.domain.service;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroDisponivelDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.domain.enums.Categoria;


import java.util.List;

public interface CarroService {
    public List<CarroDTO> listarCarros();

    public CarroDTO salvarCarro(CarroRequestDTO data);

    public List<CarroDTO> filtrarCarros(Categoria categoria, List<Long> acessoriosIds);

    public List<CarroDisponivelDTO> listarCarrosDisponiveisParaAluguel(String fabricante, String modelo, Categoria categoria, List<Long> acessorios);

    public CarroDTO atualizarCarro(CarroDTO carroDTO);

    public CarroDTO deletarPorChassi(CarroDTO carroDTO);
}
