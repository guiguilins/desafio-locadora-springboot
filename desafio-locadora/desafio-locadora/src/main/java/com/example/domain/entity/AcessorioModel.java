package com.example.domain.entity;

import com.example.api.dtos.AcessorioRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "acessorios")
public class AcessorioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String acessorios;

    @ManyToMany(mappedBy = "acessorios")
    @JsonIgnore
    private List<CarroModel> carros;

    public AcessorioModel(AcessorioRequestDTO data) {
        this.acessorios = data.acessorio();
    }
}
