package com.example.domain.repository;

import com.example.domain.entity.FabricanteModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FabricanteRepository extends JpaRepository<FabricanteModel,Long> {
}
