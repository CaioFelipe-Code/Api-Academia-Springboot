package com.caio.academia.repository;

import com.caio.academia.model.Aluno;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    List<Aluno> findByNomeContainingIgnoreCase(String nome);

    List<Aluno> findByIdadeBetween(Integer idadeInicial, Integer idadeFinal);
}
