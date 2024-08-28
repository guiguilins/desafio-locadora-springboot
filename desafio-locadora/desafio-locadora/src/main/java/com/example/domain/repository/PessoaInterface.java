package com.example.domain.repository;

import com.example.domain.entity.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaInterface extends JpaRepository<PessoaModel,Long> {
}
