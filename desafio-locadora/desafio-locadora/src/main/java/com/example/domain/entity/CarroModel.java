package com.example.domain.entity;

import com.example.api.dto.CarroRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class CarroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String placa;
    private String chassi;
    private String cor;
    private BigDecimal valorDiaria;

    public CarroModel(CarroRequestDTO data) {
        this.placa = data.placa();
        this.cor = data.cor();
        this.chassi = data.chassi();
        this.valorDiaria = data.valorDiaria();

    }
}
