package com.example.domain.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "acessorios")
public class AcessoriosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String acessorios;
    @ManyToMany(mappedBy = "acessorios")
    private List<CarroModel> carro;

    public AcessoriosModel(String acessorios){
        this.acessorios = acessorios;
    }
}
