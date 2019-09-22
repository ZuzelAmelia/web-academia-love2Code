package com.love2code.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.love2code.springdemo.dao.CursoDAO;
import com.love2code.springdemo.entity.Curso;

@Service
public class CursoServiceImpl implements CursoService {
	
	// inyectamos el cursoDAO
			@Autowired
			private CursoDAO cursoDAO;
			

		@Override
		@Transactional
		public List<Curso> getCursos() {
			return cursoDAO.getCursos();
		}


		@Override
		@Transactional
		public void guardarCurso(@Valid Curso elCurso) {
			cursoDAO.guardarCurso(elCurso);
			
		}


		@Override
		@Transactional
		public Curso getCurso(int elId) {
			
			return cursoDAO.getCurso(elId);
		}


		@Override
		@Transactional
		public void eliminarCurso(int elId) {
			cursoDAO.eliminarCurso(elId);
			
		}


		@Override
		@Transactional
		public List<Curso> buscarCursos(String theSearchName) {
			
			return cursoDAO.buscarCursos(theSearchName);
		}




}
