package com.love2code.springdemo.service;

import java.util.List;

import javax.validation.Valid;

import com.love2code.springdemo.entity.Instructor;


public interface InstructorService {

	List<Instructor> getInstructores();

	void guardarInstructor(@Valid Instructor elInstructor);

	Instructor getInstructor(int theId);

	void eliminarInstructor(int elId);

	List<Instructor> buscarInstructores(String theSearchName);

	

}
