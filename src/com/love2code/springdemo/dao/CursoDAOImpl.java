package com.love2code.springdemo.dao;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.love2code.springdemo.entity.Curso;

@Repository
public class CursoDAOImpl implements CursoDAO {

	// inyectamos la session factory
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Curso> getCursos() {

		// obtener the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// obtenemos el listado de cursos ordenados por el titulo

		Query<Curso> theQuery = currentSession.createQuery("from Curso order by titulo", Curso.class);

		// execute query and get result list
		List<Curso> cursos = theQuery.getResultList();

		// retornamos el resultado, un listado de cursos
		return cursos;
	}

	// método para guardar o actualizar un curso
	@Override
	public void guardarCurso(@Valid Curso elCurso) {

		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// guardamos/actualizamos el curso

		currentSession.saveOrUpdate(elCurso);

	}

	@Override
	public Curso getCurso(int elId) {

		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Curso elCurso = currentSession.get(Curso.class, elId);
		return elCurso;
	}

	@Override
	public void eliminarCurso(int elId) {
		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		// eliminamos de la base de datos el curso cuyo id coincida con el parámetro
		// elId
		Query theQuery = currentSession.createQuery("delete from Curso where id=:cursoId");
		theQuery.setParameter("cursoId", elId);

		theQuery.executeUpdate();

	}

	@Override
	public List<Curso> buscarCursos(String theSearchName) {
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();

		Query theQuery = null;

		//
		// solo busca por el nombre si el campo theSearchName no está vacío
		//
		if (theSearchName != null && theSearchName.trim().length() > 0) {

			// busca por titulo... case insensitive

			theQuery = currentSession.createQuery("from Curso where lower(titulo) like :elNombre", Curso.class);
			theQuery.setParameter("elNombre", "%" + theSearchName.toLowerCase() + "%");

		} else {
			// theSearchName está vacío ... por lo tanto devuelve todos los cursos
			theQuery = currentSession.createQuery("from Curso", Curso.class);
		}

		// execute query and get result list
		List<Curso> cursos = theQuery.getResultList();

		// return the results
		return cursos;

	}

}
