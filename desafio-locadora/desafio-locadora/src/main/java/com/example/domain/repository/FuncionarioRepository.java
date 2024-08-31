package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entity.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository<FuncionarioModel, Long> {
}
