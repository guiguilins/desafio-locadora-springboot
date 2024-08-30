package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FabricanteModel;

public interface FabricanteRepository extends JpaRepository<FabricanteModel,Long> {
}
