package com.example.domain.service.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.api.mapper.CarroMapper;
import com.example.domain.entity.AcessorioModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.FabricanteModel;
import com.example.domain.entity.ModeloCarroModel;
import com.example.domain.enums.Categoria;
import com.example.domain.repository.AcessorioRepository;
import com.example.domain.repository.CarroRepository;
import com.example.domain.repository.FabricanteRepository;
import com.example.domain.repository.ModeloCarroRepository;
import com.example.domain.service.CarroService;

@Service
public class CarroServiceImpl implements CarroService {

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private CarroMapper carroMapper;

    @Autowired
    private ModeloCarroRepository modeloCarroRepository;

    @Autowired
    private AcessorioRepository acessorioRepository;

    @Autowired
    private FabricanteRepository fabricanteRepository;


    @Override
    public CarroModel salvarCarro(CarroRequestDTO data) {

        FabricanteModel fabricante = new FabricanteModel();
        fabricante.setNome(data.modelo().getFabricante().getNome());

        fabricante = fabricanteRepository.save(fabricante);

        ModeloCarroModel modelo = new ModeloCarroModel();
        modelo.setDescricao(data.modelo().getDescricao());
        modelo.setCategoria(data.modelo().getCategoria());
        modelo.setFabricante(fabricante);

        modelo = modeloCarroRepository.save(modelo);

        List<AcessorioModel> acessorios = new ArrayList<>();
        for (AcessorioModel acessorioModel: data.acessorios()) {
            AcessorioModel acessorio = new AcessorioModel();
            acessorio.setAcessorios(acessorioModel.getAcessorios());

            acessorio = acessorioRepository.save(acessorio);

            acessorios.add(acessorio);
        }

        CarroModel carro = new CarroModel();
        carro.setPlaca(data.placa());
        carro.setCor(data.cor());
        carro.setChassi(data.chassi());
        carro.setValorDiaria(data.valorDiaria());
        carro.setModelo(modelo);
        carro.setAcessorios(acessorios);

        return carroRepository.save(carro);
    }

    public List<CarroDTO> listarCarros() {
        List<CarroModel> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::convertToCarroDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarroModel> filtrarCarros(Categoria categoria, List<Long> acessoriosIds) {
        if (categoria != null && acessoriosIds != null && !acessoriosIds.isEmpty()) {
            return carroRepository.findByAcessorios(acessoriosIds, acessoriosIds.size());
        } else if (categoria != null) {
            return carroRepository.findByModeloCategoria(categoria);
        } else if (acessoriosIds != null && !acessoriosIds.isEmpty()) {
            return carroRepository.findByAcessorios(acessoriosIds, acessoriosIds.size());
        } else {
            return carroRepository.findAll();
        }
    }

}
