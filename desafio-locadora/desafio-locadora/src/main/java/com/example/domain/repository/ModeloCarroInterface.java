package com.example.domain.repository;

import com.example.domain.entity.ModeloCarroModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModeloCarroInterface extends JpaRepository<ModeloCarroModel,Long> {
}
