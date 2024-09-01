package com.example.domain.service.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import com.example.api.dtos.AluguelRequestDTO;
import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.ApoliceSeguroRepository;
import com.example.domain.repository.CarroRepository;
import com.example.domain.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.api.dtos.AluguelDTO;
import com.example.api.mapper.AluguelMapper;
import com.example.domain.entity.AluguelModel;
import com.example.domain.repository.AluguelRepository;
import com.example.domain.service.AluguelService;

@Service
public class AluguelServiceImpl implements AluguelService {

    @Autowired
    private AluguelRepository aluguelRepository;

    @Autowired
    private AluguelMapper aluguelMapper;

    @Autowired
    private CarroRepository carroRepository;

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private ApoliceSeguroRepository apoliceRepository;

    @Override
    public List<AluguelDTO> listarAlugueis() {
        List<AluguelModel> alugueis = aluguelRepository.findAll();

        return alugueis.stream()
                .map(aluguelMapper::convertToAluguelDTO)
                .collect(Collectors.toList());
    }

    public void deletarAluguel(Long id) {
        if (aluguelRepository.findById(id).isEmpty()) {
            throw new RuntimeException();
        }

        aluguelRepository.deleteById(id);
    }

    public AluguelModel contratoAluguel(AluguelRequestDTO data) {
        CarroModel carro = carroRepository.findByChassi(data.carro().getChassi())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        MotoristaModel motorista = motoristaRepository.findByCpf(data.motorista().getCpf())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

//        ApoliceSeguroModel apolice = apoliceRepository.findById(data.apolice().getId())
//                .orElseThrow(() -> new RuntimeException("Apólice não encontrada"));

        AluguelModel aluguel = new AluguelModel();
        aluguel.setDataPedido(data.dataPedido());
        aluguel.setDataEntrega(data.dataEntrega());
        aluguel.setDataDevolucao(data.dataDevolucao());
        aluguel.setValorTotal(data.valorTotal());
        aluguel.setCarro(carro);
        aluguel.setApolice(null);
        aluguel.setMotorista(motorista);

        return aluguelRepository.save(aluguel);
    }

    public AluguelModel updateAluguel(Long id, AluguelRequestDTO data) {
        AluguelModel aluguel = aluguelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));

        CarroModel carro = carroRepository.findByChassi(data.carro().getChassi())
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        MotoristaModel motorista = motoristaRepository.findByCpf(data.motorista().getCpf())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado"));

//        ApoliceSeguroModel apolice = apoliceRepository.findById(data.apolice().getId())
//              .orElseThrow(() -> new RuntimeException("Apólice não encontrada"));

        aluguel.setDataPedido(data.dataPedido());
        aluguel.setDataEntrega(data.dataEntrega());
        aluguel.setDataDevolucao(data.dataDevolucao());
        aluguel.setValorTotal(data.valorTotal());
        aluguel.setCarro(carro);
        aluguel.setApolice(null);
        aluguel.setMotorista(motorista);

        return aluguelRepository.save(aluguel);
    }
}