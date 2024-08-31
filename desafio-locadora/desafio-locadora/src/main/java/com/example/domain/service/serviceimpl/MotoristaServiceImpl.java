package com.example.domain.service.serviceimpl;

import com.example.api.dtos.MotoristaDTO;
import com.example.api.mapper.MotoristaMapper;
import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.repository.MotoristaRepository;
import com.example.domain.service.MotoristaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MotoristaServiceImpl implements MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;
    @Autowired
    private MotoristaMapper motoristaMapper;

    @Override
    public MotoristaModel createMotorista(MotoristaModel motoristaModel) {
        return this.motoristaRepository.save(motoristaModel);
    }

    @Override
    public List<MotoristaDTO> listarMotoristas() {
        List<MotoristaModel> motoristas = motoristaRepository.findAll();

        return motoristas.stream()
                .map(motoristaMapper::convertToMotoristaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MotoristaDTO updateMotorista(MotoristaDTO motoristaDTO) {
        MotoristaModel motoristaExistente = motoristaRepository.findByCpf(motoristaDTO.cpf())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado com o CPF: " + motoristaDTO.cpf()));

        if (motoristaDTO.nome() != null && !motoristaDTO.nome().isEmpty()) {
            motoristaExistente.setNome(motoristaDTO.nome());
        }
        if (motoristaDTO.dataNascimento() != null) {
            motoristaExistente.setDataNascimento(motoristaDTO.dataNascimento());
        }
        if (motoristaDTO.sexo() != null) {
            motoristaExistente.setSexo(motoristaDTO.sexo());
        }
        if (motoristaDTO.cnh() != null && !motoristaDTO.cnh().isEmpty()) {
            motoristaExistente.setNumeroCNH(motoristaDTO.cnh());
        }
        MotoristaModel motoristaAtualizado = motoristaRepository.save(motoristaExistente);

        return motoristaMapper.convertToMotoristaDTO(motoristaAtualizado);
    }

    @Override
    public MotoristaDTO deleteMotorista(MotoristaDTO motoristaDTO) {
        MotoristaModel motoristaExistente = motoristaRepository.findByCpf(motoristaDTO.cpf())
                .orElseThrow(() -> new RuntimeException("Motorista não encontrado com o CPF: " + motoristaDTO.cpf()));
        motoristaRepository.delete(motoristaExistente);
        return motoristaMapper.convertToMotoristaDTO(motoristaExistente);
    }
}