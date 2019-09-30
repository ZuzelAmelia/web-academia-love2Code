package com.love2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springdemo.dao.AlumnoDAO;
import com.love2code.springdemo.entity.Alumno;

@Service
public class AlumnoServiceImpl implements AlumnoService {

	// inyectamos el alumnoDAO
	@Autowired
	private AlumnoDAO alumnoDAO;

	@Override
	@Transactional
	public List<Alumno> getAlumnos() {
		return alumnoDAO.getAlumnos();
	}

	@Override
	@Transactional
	public void guardarAlumno(Alumno elAlumno) {
		alumnoDAO.guardarAlumno(elAlumno);

	}

	@Override
	@Transactional
	public Alumno getAlumno(int theId) {
		return alumnoDAO.getAlumno(theId);
	}

	@Override
	@Transactional
	public void eliminarAlumno(int elId) {
		alumnoDAO.eliminarAlumno(elId);

	}

	@Override
	@Transactional
	public List<Alumno> buscarAlumnos(String theSearchName) {

		return alumnoDAO.buscarAlumnos(theSearchName);
	}
}
