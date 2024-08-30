package com.example.domain.entity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import com.example.api.dtos.AluguelRequestDTO;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Calendar dataPedido;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataEntrega;

    @NotNull
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date dataDevolucao;

    @NotNull
    private BigDecimal valorTotal;

    @ManyToOne
    @JoinColumn(name = "carro_id", referencedColumnName = "id")
    @JsonIgnore
    private CarroModel carro;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "apolice_id", referencedColumnName = "id")
    private ApoliceSeguroModel apolice;

    @ManyToOne
    @JoinColumn(name = "motorista_id", referencedColumnName = "id")
    private MotoristaModel motorista;

    public AluguelModel(AluguelRequestDTO data) {
        this.dataPedido = data.dataPedido();
        this.dataEntrega = data.dataEntrega();
        this.dataDevolucao = data.dataDevolucao();
        this.valorTotal = data.valorTotal();
        this.carro = data.carro();
        this.apolice = data.apolice();
        this.motorista = data.motorista();
    }
}