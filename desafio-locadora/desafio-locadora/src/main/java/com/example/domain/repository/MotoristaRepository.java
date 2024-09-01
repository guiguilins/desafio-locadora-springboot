package com.example.domain.repository;

import com.example.domain.entity.MotoristaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MotoristaRepository extends JpaRepository<MotoristaModel,Long> {
    Optional<MotoristaModel> findByCpf(String cpf);
}
