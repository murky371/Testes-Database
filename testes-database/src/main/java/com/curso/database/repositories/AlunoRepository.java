package com.curso.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.database.entities.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
