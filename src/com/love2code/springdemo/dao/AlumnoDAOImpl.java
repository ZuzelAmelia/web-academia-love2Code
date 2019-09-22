package com.love2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.love2code.springdemo.entity.Alumno;



@Repository
public class AlumnoDAOImpl implements AlumnoDAO {

	// inyectamos la session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Alumno> getAlumnos(){
		
		// obtener the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// obtenemos el listado de alumnos ordenador por el primer apellido
	
				Query<Alumno> theQuery = 
						currentSession.createQuery("from Alumno order by primerApellido",
													Alumno.class);
		
		// execute query and get result list
		List<Alumno> alumnos = theQuery.getResultList();
				
		// retornamos el resultado, un listado de alumnos		
		return alumnos;
	}

	@Override
	public void guardarAlumno(Alumno elAlumno) {
		
		
		// obtenemos current hibernate session
				Session currentSession = sessionFactory.getCurrentSession();
				
				// guardamos/actualizamos el alumno
				
				currentSession.saveOrUpdate(elAlumno);
				
	}

	@Override
	public Alumno getAlumno(int theId) {
		
		// obtenemos current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Recuperamos el alumno con el id recibido y lo devolvemos al método del controlador 
		//para mostrarlo en el formulario de alumno-form
		
		Alumno elAlumno=currentSession.get(Alumno.class, theId);
		
	
		return elAlumno;
		
	
	}

	@Override
	public void eliminarAlumno(int elId) {
				
		// obtenemos current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
				
		// eliminamos de la base de datos el alumno cuyo id coincida con el parámetro elId
			Query theQuery = 
					currentSession.createQuery("delete from Alumno where id=:alumnoId");
			theQuery.setParameter("alumnoId", elId);
			
			theQuery.executeUpdate();	
			
			
		
	}

		
	@Override
    public List<Alumno> buscarAlumnos(String theSearchName) {

        // get the current hibernate session
        Session currentSession = sessionFactory.getCurrentSession();
        
        Query theQuery = null;
        
        //
        //  solo busca por el nombre si el campo theSearchName no está vacío
        //
        if (theSearchName != null && theSearchName.trim().length() > 0) {

            // busca por nombre o primer apellido ... case insensitive
        	System.out.println("El nombre no está vacio "+theSearchName);
            theQuery =currentSession.createQuery("from Alumno where lower(nombre) like :elNombre or lower(primerApellido) like :elNombre or lower(segundoApellido) like :elNombre", Alumno.class);
            theQuery.setParameter("elNombre", "%" + theSearchName.toLowerCase() + "%");

        }
        else {
            // theSearchName está vacío ... por lo tanto devuelve todos los alumnos
            theQuery =currentSession.createQuery("from Alumno", Alumno.class);            
        }
        
        // execute query and get result list
        List<Alumno> alumnos = theQuery.getResultList();
                      
        // return the results        
        return alumnos;
        
    }

		
}
