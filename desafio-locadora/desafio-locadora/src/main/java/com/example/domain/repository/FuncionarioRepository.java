package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entity.FuncionarioModel;
import org.springframework.stereotype.Repository;

@Repository
public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
