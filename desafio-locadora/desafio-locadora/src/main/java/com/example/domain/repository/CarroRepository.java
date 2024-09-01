package com.example.domain.repository;

import com.example.domain.entity.CarroModel;
import com.example.domain.entity.MotoristaModel;
import com.example.domain.enums.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarroRepository extends JpaRepository<CarroModel, Long> {

    List<CarroModel>findByModeloCategoria(Categoria categoria);
    
    Optional<CarroModel> findByChassi(String chassi);

    @Query("SELECT c FROM CarroModel c JOIN c.acessorios a WHERE a.id IN :acessoriosIds GROUP BY c HAVING COUNT(DISTINCT a.id) = :acessoriosCount")
    List<CarroModel> findByAcessorios(@Param("acessoriosIds") List<Long> acessoriosIds, @Param("acessoriosCount") long acessoriosCount);

    @Query("SELECT DISTINCT c FROM CarroModel c " +
            "JOIN c.modelo m " +
            "JOIN m.fabricante f " +
            "LEFT JOIN c.acessorios a " +
            "WHERE (:fabricante IS NULL OR LOWER(f.nome) = LOWER(:fabricante)) " +
            "AND (:modelo IS NULL OR LOWER(m.descricao) = LOWER(:modelo)) " +
            "AND (:categoria IS NULL OR m.categoria = :categoria) " +
            "AND (:acessorios IS NULL OR a.acessorios IN :acessorios)")
    List<CarroModel> findCarrosDisponiveis(@Param("fabricante") String fabricante,
                                                   @Param("modelo") String modelo,
                                                   @Param("categoria") Categoria categoria,
                                                   @Param("acessorios") List<Long> acessorios);
}