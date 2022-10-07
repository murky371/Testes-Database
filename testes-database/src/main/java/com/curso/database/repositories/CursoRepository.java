package com.curso.database.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.curso.database.entities.Curso;

public interface CursoRepository extends JpaRepository<Curso, Integer> {
	List<Curso> findCursoByNome(String nome);

	List<Curso> findByNomeContaining(String valor);

	List<Curso> findByNomeLike(String valor);

	List<Curso> findByNomeLikeIgnoreCase(String valor);
	
	@Query(value = "Select c From Curso c")
	List<Curso> findQueryNome();

	@Query(value = "Select nome_do_curso From Curso curso_faculdade where area = 'Exatas", nativeQuery = true)
	List<String> findByQueryNomePorArea();
	
	@Query(value = "Select nome_do_curso From Curso curso_faculdade where area = :area", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area")String area);
	
	@Query(value = "Select nome_do_curso From Curso curso_faculdade where area = :area and nome_do_curso = :nome", nativeQuery = true)
	List<String> findByQueryNomePorAreaInformada(@Param("area")String area, @Param ("nome") String nome);
	
	@Query(value = "Select nome_do_curso From Curso curso_faculdade where area = ?1 and nome_do_curso = ?2", nativeQuery = true)
	List<String> findByQueryNomePorAreaParametros(String area, String nome);
}
