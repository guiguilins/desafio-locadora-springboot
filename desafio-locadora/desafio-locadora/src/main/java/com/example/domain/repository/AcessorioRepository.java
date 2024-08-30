package com.example.domain.repository;

import com.example.domain.entity.AcessoriosModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessorioRepository extends JpaRepository<AcessoriosModel,Long> {
}
