package com.curso.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.curso.database.entities.GradeCurricular;

public interface GradeCurricularRepository extends JpaRepository<GradeCurricular, Integer> {

}
