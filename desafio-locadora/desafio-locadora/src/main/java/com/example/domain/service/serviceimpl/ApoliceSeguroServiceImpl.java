package com.example.domain.service.serviceimpl;

import com.example.api.dtos.ApoliceSeguroDTO;
import com.example.api.mapper.ApoliceSeguroMapper;
import com.example.domain.entity.ApoliceSeguroModel;
import com.example.domain.repository.ApoliceSeguroRepository;
import com.example.domain.service.ApoliceSeguroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApoliceSeguroServiceImpl implements ApoliceSeguroService {

    @Autowired
    private ApoliceSeguroRepository apoliceSeguroRepository;

    @Autowired
    private ApoliceSeguroMapper apoliceSeguroMapper;

    @Override
    public ApoliceSeguroModel createApoliceSeguro(ApoliceSeguroModel apoliceSeguro) {
        return this.apoliceSeguroRepository.save(apoliceSeguro);
    }

    @Override
    public List<ApoliceSeguroDTO> listarApoliceSeguro() {
        List<ApoliceSeguroModel> apolices = apoliceSeguroRepository.findAll();
        return apolices.stream()
                .map(apoliceSeguroMapper::convertToApoliceSeguroDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ApoliceSeguroDTO updateApoliceSeguro(Long id, ApoliceSeguroDTO apoliceSeguroDTO) {
        ApoliceSeguroModel apoliceExistente = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apólice de Seguro não encontrada com o ID: " + id));

        if (apoliceSeguroDTO.valorFranquia() != null) {
            apoliceExistente.setValorFranquia(apoliceSeguroDTO.valorFranquia());
        }
        apoliceExistente.setProtecaoTerceiro(apoliceSeguroDTO.protecaoTerceiro());
        apoliceExistente.setProtecaoCausasNaturais(apoliceSeguroDTO.protecaoCausasNaturais());
        apoliceExistente.setProtecaoRoubo(apoliceSeguroDTO.protecaoRoubo());

        ApoliceSeguroModel apoliceAtualizada = apoliceSeguroRepository.save(apoliceExistente);

        return apoliceSeguroMapper.convertToApoliceSeguroDTO(apoliceAtualizada);
    }

    @Override
    public void deleteApoliceSeguro(Long id) {
        ApoliceSeguroModel apoliceSeguro = apoliceSeguroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Apólice de Seguro não encontrada com o ID: " + id));
        apoliceSeguroRepository.delete(apoliceSeguro);
    }
}
