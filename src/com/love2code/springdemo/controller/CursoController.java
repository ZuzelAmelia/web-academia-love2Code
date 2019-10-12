package com.love2code.springdemo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.love2code.springdemo.entity.Curso;
import com.love2code.springdemo.entity.Instructor;
import com.love2code.springdemo.service.CursoService;
import com.love2code.springdemo.service.InstructorService;

@Controller
@RequestMapping("/curso")
public class CursoController {

	// se inyecta el cursoService en este controlador
	@Autowired
	private CursoService cursoService;

	
	// Inyectamos el instructorService al controlador 
	@Autowired
	private InstructorService instructorService;
	
	
	// Método para listar todos los cursos de la base de datos
	@GetMapping("/listado")
	public String listadoCursos(Model theModel) {

		// Recuperamos los cursos del servicio CursoService

		List<Curso> losCursos = cursoService.getCursos();

		// Añadimos los cursos al modelo de spring mvc, el modelo tiene como nombre de
		// atributo cursos

		theModel.addAttribute("cursos", losCursos);

		return "list-cursos";
	}

	// método para mostrar el formulario para añadir un nuevo curso
	@GetMapping("/mostrarFormAgregarCurso")
	public String mostrarFormAgregarCurso(@RequestParam("instructorId") int elIdInstructor, Model theModel) {

		// Crear model attribute para enlazarlo con los datos del formulario

		Curso elCurso = new Curso();
		
		//Obtenemos el Instructor con el id seleccionado en el formulario de elegir instructor
		
		Instructor elInstructor=instructorService.getInstructor(elIdInstructor);
		
		elCurso.setInstructor(elInstructor);
					
		theModel.addAttribute("curso", elCurso);

		return "curso-form";

	}
	
	//método que devuelve la lista de todos los instructores para mostrarlos en un select dentro del jsp elegir-instructor-form
	@GetMapping("/mostrarFormElegirInstructor")
	public String listadoInstructoresSelect(Model theModel) {		
						
	// Recuperamos los cursos del servicio cursoService
				
	List<Instructor> losInstructores= instructorService.getInstructores();
				
	//Añadimos los instructores al modelo de spring mvc
				
	theModel.addAttribute("instructores", losInstructores);
				
	return "elegir-instructor-form";
			}

	// método que llama a la capa de servicio para guardar un nuevo curso
	@PostMapping("/guardarCurso")
	public String guardarCurso(@Valid @ModelAttribute("curso") Curso elCurso, BindingResult theBindingResult) {

		if (theBindingResult.hasErrors()) {

			// si se han producido errores de validación se vuelve a mostrar el formulario
			// de añadir cursoId
			return "curso-form";
		} else {

			// Si no se han producido errores de validación guardamos el curso usando la
			// capa de servicio cursoService
			cursoService.guardarCurso(elCurso);			
			return "redirect:/curso/listado";
		}

	}

	// método que muestra el formulario con los datos del curso seleccionado
	@GetMapping("/mostrarFormForUpdate")
	public String mostrarFormForUpdate(@RequestParam("cursoId") int elId, Model theModel) {

		// busca el curso desde nuestro servicio cursoService

		Curso elCurso = cursoService.getCurso(elId);

		// el curso lo configuramos como un model attribute para rellenar el formulario
		// con los datos del curso

		theModel.addAttribute("curso", elCurso);

		// devuelve la información al formulario curso-form.jsp, el formulario debe tener el atributo modelAttribute="curso"

		return "curso-form";

	}

	// método para eliminar el curso seleccionado del listado
	@GetMapping("/eliminarCurso")
	public String eliminarAlumno(@RequestParam("cursoId") int elId) {

		// Eliminar el curso seleccionado
		cursoService.eliminarCurso(elId);

		return "redirect:/curso/listado";
	}

	@GetMapping("/buscarCursos")
	public String buscarCursos(@RequestParam("theSearchName") String theSearchName, Model theModel) {

		// busca cursos desde el servicio cursoService

		List<Curso> losCursos = cursoService.buscarCursos(theSearchName);

		// añadimos los cursos al modelo

		theModel.addAttribute("cursos", losCursos);

		return "list-cursos";
	}

}
