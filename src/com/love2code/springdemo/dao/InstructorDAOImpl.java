package com.love2code.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.love2code.springdemo.entity.Instructor;

@Repository
public class InstructorDAOImpl implements InstructorDAO {

	// inyectamos la session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Instructor> getInstructores() {

		// obtener the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// obtenemos el listado de instructores ordenados por el primer apellido

		Query<Instructor> theQuery = currentSession.createQuery("from Instructor order by primerApellido",
				Instructor.class);

		// execute query and get result list
		List<Instructor> instructores = theQuery.getResultList();

		// retornamos el resultado, un listado de alumnos
		return instructores;
	}

	@Override
	public void guardarInstructor(@Valid Instructor elInstructor) {

		Session currentSession = sessionFactory.getCurrentSession();

		currentSession.saveOrUpdate(elInstructor);

	}

	@Override
	public Instructor getInstructor(int theId) {
		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// Recuperamos el alumno con el id recibido y lo devolvemos al método del
		// controlador
		// para mostrarlo en el formulario de alumno-form

		Instructor elInstructor = currentSession.get(Instructor.class, theId);

		return elInstructor;
	}

	@Override
	public void eliminarInstructor(int elId) {

		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// eliminamos de la base de datos el Instructor cuyo id coincida con el
		// parámetro elId
		Query theQuery = currentSession.createQuery("delete from Instructor where id=:instructorId");
		theQuery.setParameter("instructorId", elId);

		theQuery.executeUpdate();
	}

	@Override
	public List<Instructor> buscarInstructores(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// solo busca por el nombre si el campo theSearchName no está vacío
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// busca por nombre o primer apellido o segundo apellido ... case insensitive

			theQuery = currentSession.createQuery(
					"from Instructor where lower(nombre) like :elNombre or lower(primerApellido) like :elNombre or lower(segundoApellido) like :elNombre",
					Instructor.class);
			theQuery.setParameter("elNombre", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName está vacío ... por lo tanto devuelve todos los alumnos
			theQuery = currentSession.createQuery("from Instructor", Instructor.class);
		}

		// execute query and get result list
		List<Instructor> instructores = theQuery.getResultList();

		// return the results
		return instructores;
	}

}
