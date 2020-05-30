package com.spring_arquitetura.spring_arquitetura.repository;
import com.spring_arquitetura.spring_arquitetura.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {}