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

import com.love2code.springdemo.service.CursoService;


@Controller
@RequestMapping("/curso")
public class CursoController {
	
	//se inyecta el curso DAO en este controlador
	
	@Autowired
	private CursoService cursoService;
	

		
	
	//Método para listar todos los cursos de la base de datos
	@GetMapping("/listado")
	public String listadoCursos(Model theModel) {		
				
		// Recuperamos los cursos del servicio CursoService
		
		List<Curso> losCursos= cursoService.getCursos();
		
		//Añadimos los cursos al modelo de spring mvc, el modelo tiene como nombre de atributo cursos
		
		theModel.addAttribute("cursos", losCursos);
		
		return "list-cursos";
	}
	
	// método para mostrar el formulario para añadir un nuevo curso
		@GetMapping("/mostrarFormAgregarCurso")
		public String mostrarFormAgregarCurso(Model theModel) {
			
			// Crear model attribute para enlazarlo con los datos del formulario

			Curso elCurso=new Curso();
			
				
			theModel.addAttribute("curso", elCurso);
			
				

			return "curso-form";

			
		}
		
			
		// método que llama a la capa de servicio para guardar un nuevo curso
		@PostMapping("/guardarCurso")
		public String guardarCurso(@Valid @ModelAttribute("curso") Curso elCurso,
				BindingResult theBindingResult) { 
			
			if (theBindingResult.hasErrors()) {
				
				// si se han producido errores de validación se vuelve a mostrar el formulario de añadir curso
				return "curso-form";
			}
			else {
				
				//Si no se han producido errores de validación guardamos el curso usando la capa de servicio cursoService
				cursoService.guardarCurso(elCurso);
				
				/*int cursoId=elCurso.getId();
				
				
				
				return "redirect:/instructor/listadoInstructores?cursoId="+cursoId;*/
				return "redirect:/curso/listado";
			}
			
					
		}
		
		
						
		// método que muestra el formulario con los datos del curso seleccionado
		@GetMapping("/mostrarFormForUpdate")
		public String mostrarFormForUpdate(@RequestParam("cursoId") int elId,
				Model theModel) {

				// busca el alumno desde nuestro servicio alumnoService 
			
				Curso elCurso=cursoService.getCurso(elId);
				
					
				// el alumno lo configuramos como un model attribute para rellenar el formulario con los datos del curso
				
				theModel.addAttribute("curso",elCurso);			

				// devuelve la información al formulario curso-form.jsp

				return "curso-form";


				}
		
			// método para eliminar el curso seleccionado del listado
		@GetMapping("/eliminarCurso")
		public String eliminarAlumno(@RequestParam("cursoId") int elId) {
			
			// Eliminar el alumno seleccionado
			cursoService.eliminarCurso(elId);
			
			return "redirect:/curso/listado";
		}
	

		@GetMapping("/buscarCursos")
		 public String buscarCursos(@RequestParam("theSearchName") String theSearchName,
                 Model theModel) {

			// busca alumnos desde el servicio alumnoService

			List<Curso> losCursos = cursoService.buscarCursos(theSearchName);

			// añadimos los cursos al modelo 

			theModel.addAttribute("cursos", losCursos);

			return "list-cursos";        
}

}
