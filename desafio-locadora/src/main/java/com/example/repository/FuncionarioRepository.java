package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.FuncionarioModel;

public interface FuncionarioRepository extends JpaRepository <FuncionarioModel, Long> {

}
