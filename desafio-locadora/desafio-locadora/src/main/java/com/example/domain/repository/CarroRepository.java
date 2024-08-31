package com.example.domain.repository;

import com.example.domain.entity.CarroModel;
import com.example.domain.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel,Long> {

    List<CarroModel> findByModeloCategoria(Categoria categoria);

    @Query("SELECT c FROM CarroModel c JOIN c.acessorios a WHERE a.id IN :acessoriosIds GROUP BY c HAVING COUNT(DISTINCT a.id) = :acessoriosCount")
    List<CarroModel> findByAcessorios(@Param("acessoriosIds") List<Long> acessoriosIds, @Param("acessoriosCount") long acessoriosCount);
}
