package com.example.domain.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.api.dtos.CarroDisponivelDTO;
import com.example.domain.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.dtos.CarroDTO;
import com.example.api.dtos.CarroRequestDTO;
import com.example.api.mapper.CarroMapper;
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
    public CarroDTO salvarCarro(CarroRequestDTO data) {

        FabricanteModel fabricante = new FabricanteModel();
        fabricante.setNome(data.modelo().getFabricante().getNome());
        fabricante = fabricanteRepository.save(fabricante);

        ModeloCarroModel modelo = new ModeloCarroModel();
        modelo.setDescricao(data.modelo().getDescricao());
        modelo.setCategoria(data.modelo().getCategoria());
        modelo.setFabricante(fabricante);
        modelo = modeloCarroRepository.save(modelo);

        List<AcessorioModel> acessorios = data.acessorios().stream()
                .map(acessorioModel -> {
                    AcessorioModel acessorio = new AcessorioModel();
                    acessorio.setAcessorios(acessorioModel.getAcessorios());
                    return acessorioRepository.save(acessorio);
                })
                .collect(Collectors.toList());

        CarroModel carro = new CarroModel();
        carro.setPlaca(data.placa());
        carro.setCor(data.cor());
        carro.setChassi(data.chassi());
        carro.setValorDiaria(data.valorDiaria());
        carro.setModelo(modelo);
        carro.setAcessorios(acessorios);

        carro = carroRepository.save(carro);

        return carroMapper.convertToCarroDTO(carro);
    }

    public List<CarroDTO> listarCarros() {
        List<CarroModel> carros = carroRepository.findAll();
        return carros.stream()
                .map(carroMapper::convertToCarroDTO)
                .collect(Collectors.toList());
    }



    @Override
    public List<CarroDTO> filtrarCarros(Categoria categoria, List<Long> acessoriosIds) {
        List<CarroModel> carrosFiltrados;

        if (categoria != null && acessoriosIds != null && !acessoriosIds.isEmpty()) {
            carrosFiltrados = carroRepository.findByAcessorios(acessoriosIds, acessoriosIds.size());
        } else if (categoria != null) {
            carrosFiltrados = carroRepository.findByModeloCategoria(categoria);
        } else if (acessoriosIds != null && !acessoriosIds.isEmpty()) {
            carrosFiltrados = carroRepository.findByAcessorios(acessoriosIds, acessoriosIds.size());
        } else {
            carrosFiltrados = carroRepository.findAll();
        }
        return carrosFiltrados.stream()
                .map(carroMapper::convertToCarroDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<CarroDisponivelDTO> listarCarrosDisponiveisParaAluguel(String fabricante, String modelo, Categoria categoria, List<Long> acessorios) {
        List<CarroModel> carrosDisponiveis = carroRepository.findCarrosDisponiveis(fabricante, modelo, categoria, acessorios);
        return carrosDisponiveis.stream()
                .filter(CarroModel::getCarroDisponivel)
                .map(CarroDisponivelDTO::new)
                .collect(Collectors.toList());
        }

    @Override
    public CarroDTO atualizarCarro(CarroDTO carroDTO) {
        CarroModel carroExistente = carroRepository.findByChassi(carroDTO.chassi())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com o chassi: " + carroDTO.chassi()));

        if(carroDTO.placa() != null) {
            carroExistente.setPlaca(carroDTO.placa());
        }
        if (carroDTO.cor() != null) {
            carroExistente.setCor(carroDTO.cor());
        }
        if (carroDTO.valorDiaria()!= null) {
            carroExistente.setValorDiaria(carroDTO.valorDiaria());
        }
        CarroModel carroAtualizado = carroRepository.save(carroExistente);
        return carroMapper.convertToCarroDTO(carroAtualizado);
    }

    @Override
    public CarroDTO deletarPorChassi(CarroDTO carroDTO) {
        CarroModel carroExistente = carroRepository.findByChassi(carroDTO.chassi())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado com o chassi: " + carroDTO.chassi()));
        carroRepository.delete(carroExistente);
        return carroMapper.convertToCarroDTO(carroExistente);
    }
}


