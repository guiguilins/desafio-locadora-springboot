package com.example.domain.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.api.dtos.AluguelRequestDTO;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "aluguel")
public class AluguelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private Calendar dataPedido;
    private Date dataEntrega;
    private Date dataDevolucao;
    private BigDecimal valorTotal;

    @ManyToOne
    private CarroModel carro;

    public AluguelModel(AluguelRequestDTO data) {
        this.dataPedido = data.dataPedido();
        this.dataEntrega = data.dataEntrega();
        this.dataDevolucao = data.dataDevolucao();
        this.valorTotal = data.valorTotal();
    }
}