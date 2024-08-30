package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.AluguelModel;

public interface AluguelRepository extends JpaRepository<AluguelModel,Long> {
}