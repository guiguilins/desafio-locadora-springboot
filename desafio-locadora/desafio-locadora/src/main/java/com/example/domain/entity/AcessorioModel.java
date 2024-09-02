package com.example.domain.entity;

import java.util.List;

import com.example.api.dtos.AcessorioRequestDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    }
}
