package com.example.api.mapper;

import org.springframework.stereotype.Component;

import com.example.api.dtos.AluguelDTO;
import com.example.domain.entity.AluguelModel;

@Component
public class AluguelMapper {

	public AluguelDTO convertToAluguelDTO(AluguelModel aluguelModel) {
		return new AluguelDTO(aluguelModel.getDataPedido(), aluguelModel.getDataEntrega(),
				aluguelModel.getDataDevolucao(), aluguelModel.getValorTotal(), aluguelModel.getCarro(),
				aluguelModel.getApolice(), aluguelModel.getMotorista());
	}

}