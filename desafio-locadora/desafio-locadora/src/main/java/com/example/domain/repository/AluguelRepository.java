package com.example.domain.repository;

import com.example.domain.entity.AluguelModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository extends JpaRepository<AluguelModel,Long> {
}