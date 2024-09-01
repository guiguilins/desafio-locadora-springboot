package com.example.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.domain.entity.ApoliceSeguroModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ApoliceSeguroRepository extends JpaRepository<ApoliceSeguroModel, Long> {
}
