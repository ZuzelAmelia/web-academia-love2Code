package com.love2code.springdemo.service;

import java.util.List;

import com.love2code.springdemo.entity.Alumno;

public interface AlumnoService {

	List<Alumno> getAlumnos();

	void guardarAlumno(Alumno elAlumno);

	Alumno getAlumno(int theId);

	void eliminarAlumno(int elId);

	List<Alumno> buscarAlumnos(String theSearchName);

}
