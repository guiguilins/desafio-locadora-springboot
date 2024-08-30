package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.ModeloCarroModel;

public interface ModeloCarroRepository extends JpaRepository<ModeloCarroModel,Long> {
}
