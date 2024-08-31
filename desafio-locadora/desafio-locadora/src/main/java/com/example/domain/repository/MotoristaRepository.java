package com.example.domain.repository;

import com.example.domain.entity.MotoristaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MotoristaRepository extends JpaRepository<MotoristaModel, Long> {
    Optional<MotoristaModel> findByCpf(String cpf);
}
