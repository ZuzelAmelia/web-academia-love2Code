package com.love2code.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.love2code.springdemo.dao.InstructorDAO;
import com.love2code.springdemo.entity.Instructor;

@Service
public class InstructorServiceImpl implements InstructorService {

	// inyectamos el instructorDAO

	@Autowired
	private InstructorDAO instructorDAO;

	@Override
	@Transactional
	public List<Instructor> getInstructores() {

		return instructorDAO.getInstructores();
	}

	@Override
	@Transactional
	public void guardarInstructor(@Valid Instructor elInstructor) {
		instructorDAO.guardarInstructor(elInstructor);

	}

	@Override
	@Transactional
	public Instructor getInstructor(int theId) {
		// TODO Auto-generated method stub
		return instructorDAO.getInstructor(theId);
	}

	@Override
	@Transactional
	public void eliminarInstructor(int elId) {
		instructorDAO.eliminarInstructor(elId);

	}

	@Override
	@Transactional
	public List<Instructor> buscarInstructores(String theSearchName) {

		return instructorDAO.buscarInstructores(theSearchName);
	}

}
