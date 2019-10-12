package com.love2code.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import com.love2code.springdemo.entity.Curso;

public interface CursoService {

	List<Curso> getCursos();

	void guardarCurso(@Valid Curso elCurso);

	Curso getCurso(int elId);

	void eliminarCurso(int elId);

	List<Curso> buscarCursos(String theSearchName);

	List<Curso> getCursosInstructor(int elId);


}
