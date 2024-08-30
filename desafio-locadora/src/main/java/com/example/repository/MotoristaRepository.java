package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.MotoristaModel;


public interface MotoristaRepository extends JpaRepository<MotoristaModel, Long> {

}
