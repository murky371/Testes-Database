package com.curso.database;


import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.curso.database.entities.Aluno;
import com.curso.database.entities.Curso;
import com.curso.database.entities.GradeCurricular;
import com.curso.database.entities.Materia;
import com.curso.database.repositories.AlunoRepository;
import com.curso.database.repositories.CursoRepository;
import com.curso.database.repositories.GradeCurricularRepository;
import com.curso.database.repositories.MateriaRepository;

@SpringBootApplication
public class TesteDatabaseApplication implements CommandLineRunner {
	
	 @Autowired
	 private CursoRepository cursoRepository;
	 
	 @Autowired
	 private MateriaRepository materiaRepository;
	 
	 @Autowired
	 private AlunoRepository alunoRepository;
	 
	 @Autowired
	 private GradeCurricularRepository gradeCurricularRepository;
	 
	 public static void main(String[] args) {
			SpringApplication.run(TesteDatabaseApplication.class, args);
		}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Curso curso1 = new Curso("Graduaçao em TI", "Exatas");
		Curso curso2 = new Curso("Graduaçao em Economia", "Humanas");
		Curso curso3 = new Curso("Graduaçao em Administraçao", "Humanas");
		Curso curso4 = new Curso("Graduaçao em Educaçao fisica", "Humanas");
		Curso curso5 = new Curso("Graduaçao em Educaçao continuada", "Humanas");
		Curso curso6 = new Curso("Graduaçao em Fisica", "Exatas");
		
		cursoRepository.save(curso1);
		cursoRepository.save(curso2);  //Com o Repository ja se coloca os inserts do banco automaticamente.
		cursoRepository.save(curso3);
		cursoRepository.save(curso4);
		cursoRepository.save(curso5);
		cursoRepository.save(curso6);
		
		Aluno aluno1 = new Aluno("Jose", curso1);
		Aluno aluno2 = new Aluno("Aline", curso1);
		Aluno aluno3 = new Aluno ("Humberto", curso4);
		
		alunoRepository.save(aluno1);
		alunoRepository.save(aluno2);
		alunoRepository.save(aluno3);
		
		GradeCurricular grade1 = new GradeCurricular("Graduaçao em games", aluno1);
		GradeCurricular grade2 = new GradeCurricular("Graduaçao em academia", aluno2);
		
		gradeCurricularRepository.save(grade1);
		gradeCurricularRepository.save(grade2);
		
		Set<GradeCurricular> gradesMateria1 = new HashSet<>();
		gradesMateria1.add(grade1);
	    Materia materia1 = new Materia("Design",gradesMateria1);
	    Materia materia2 = new Materia("Cultura e moda",gradesMateria1);
	    
	    materiaRepository.save(materia1);
	    materiaRepository.save(materia2);
	}     
	
}
