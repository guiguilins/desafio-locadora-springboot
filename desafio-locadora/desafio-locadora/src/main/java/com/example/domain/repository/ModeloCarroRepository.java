package com.example.domain.repository;

import com.example.domain.entity.ModeloCarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeloCarroRepository extends JpaRepository<ModeloCarroModel,Long> {
}
