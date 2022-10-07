package com.curso.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.database.entities.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Integer> {

}
