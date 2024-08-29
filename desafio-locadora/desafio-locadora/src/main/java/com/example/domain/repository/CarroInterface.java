package com.example.domain.repository;

import com.example.domain.entity.CarroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarroInterface extends JpaRepository<CarroModel,Long> {
}
