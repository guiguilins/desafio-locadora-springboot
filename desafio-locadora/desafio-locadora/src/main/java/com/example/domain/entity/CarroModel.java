package com.example.domain.entity;

import com.example.api.dtos.CarroRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "carro")
public class CarroModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String placa;

    @NotBlank
    private String chassi;

    @NotBlank
    private String cor;

    @NotNull
    private BigDecimal valorDiaria;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "equipado", joinColumns = @JoinColumn(name = "carro_id", foreignKey = @ForeignKey(name
            = "equipado_carro_id_fk")), inverseJoinColumns = @JoinColumn(name = "acessorio_id", foreignKey = @ForeignKey(name
            = "equipado_acessorio_id_fk")))
    private List<AcessorioModel> acessorios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "modelo_id")
    private ModeloCarroModel modelo;

    @OneToMany(mappedBy = "carro")
    @JsonIgnore
    private List<AluguelModel> alugueis = new ArrayList<>();

    private Boolean carroDisponivel = true;

    public CarroModel(CarroRequestDTO data) {
        this.placa = data.placa();
        this.cor = data.cor();
        this.chassi = data.chassi();
        this.valorDiaria = data.valorDiaria();
        this.acessorios = data.acessorios();
        this.modelo = data.modelo();
        this.alugueis = data.alugueis();
    }
}
