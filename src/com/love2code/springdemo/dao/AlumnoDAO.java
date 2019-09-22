package com.love2code.springdemo.dao;

import java.util.List;

import com.love2code.springdemo.entity.Alumno;


public interface AlumnoDAO {

	List<Alumno> getAlumnos();

	public void guardarAlumno(Alumno elAlumno);

	Alumno getAlumno(int theId);

	void eliminarAlumno(int elId);

	List<Alumno> buscarAlumnos(String theSearchName);

}
