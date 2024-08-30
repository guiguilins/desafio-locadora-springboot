package com.example.domain.repository;

import com.example.domain.entity.AcessorioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcessorioRepository extends JpaRepository<AcessorioModel,Long> {
}
