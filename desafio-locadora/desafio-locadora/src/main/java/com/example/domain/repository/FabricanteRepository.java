package com.example.domain.repository;

import com.example.domain.entity.FabricanteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FabricanteRepository extends JpaRepository<FabricanteModel,Long> {
}
