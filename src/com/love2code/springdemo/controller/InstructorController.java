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
@RequestMapping("/instructor")
public class InstructorController {
	
		//se inyecta el instructor DAO en este controlador	
		@Autowired
		private InstructorService instructorService;
		
		// se inyecta el cursoService en este controlador
		@Autowired
		private CursoService cursoService;
		
		//Método para listar todos los instructores de la base de datos
		
		@GetMapping("/listado")
		public String listadoInstructores(Model theModel) {		
					
			// Recuperamos los cursos del servicio cursoService
			
			List<Instructor> losInstructores= instructorService.getInstructores();
			
			//Añadimos los instructores al modelo de spring mvc
			
			theModel.addAttribute("instructores", losInstructores);
			
			return "list-instructores";
		}
		
		//código nuevo
		@GetMapping("/listadoInstructores")
		public String listadoInstructoresSelect(Model theModel) {		
					
			// Recuperamos los cursos del servicio cursoService
			
			List<Instructor> losInstructores= instructorService.getInstructores();
			
			//Añadimos los instructores al modelo de spring mvc
			
			theModel.addAttribute("instructores", losInstructores);
			
			return "elegir-instructor-form";
		}
		
		//método para mostrar el listado de cursos de un instructor seleccionado
				@GetMapping("/listadoCursosInstructor")
				public String listadoCursosInstructor(@RequestParam("instructorId") int elId, Model theModel) {
					
					// buscamos los cursos del instructor cuyo id coincida con el parámetro elId
					System.out.println("El id del instructor es: "+elId);
					List<Curso> losCursos= cursoService.getCursosInstructor(elId);
					System.out.println("Los cursos del instructor son: "+losCursos);
									
					theModel.addAttribute("cursos", losCursos);				
					
					
					return "list-cursos-instructor-seleccionado";
				}
				
		// método para mostrar el formulario para añadir un nuevo curso
				@GetMapping("/mostrarFormAgregarInstructor")
				public String mostrarFormAgregarInstructor(Model theModel) {
					
					// Crear model attribute para enlazarlo con los datos del formulario
					Instructor elInstructor=new Instructor();
					
					theModel.addAttribute("instructor", elInstructor);

					return "instructor-form";

					
				}
				
				@PostMapping("/guardarInstructor")
				public String guardarInstructor(@Valid @ModelAttribute("instructor") Instructor elInstructor,
						BindingResult theBindingResult) {
					
					if (theBindingResult.hasErrors()) {
						
						// si se han producido errores de validación se vuelve a mostrar el formulario de añadir instructor
						return "instructor-form";
					}
					else {
						
						//Si no se han producido errores de validación guardamos el instructor usando la capa de servicio instructorService
						instructorService.guardarInstructor(elInstructor);
						return "redirect:/instructor/listado";
					}
					

					
				}
				// método que muestra el formulario con los datos del alumno seleccionado
				@GetMapping("/mostrarFormForUpdate")
				public String mostrarFormForUpdate(@RequestParam("instructorId") int theId,
						Model theModel) {

						// busca el instructor desde nuestro servicio instructorService 
					
						Instructor elInstructor=instructorService.getInstructor(theId);
						
							
						// el instructor lo configuramos como un model attribute para rellenar el formulario con los datos del instructor
						
						theModel.addAttribute("instructor",elInstructor);			

						// devuelve la información al formulario instructor-form.jsp

						return "instructor-form";


						}
				
				// método para eliminar el alumno seleccionado del listado
				@GetMapping("/eliminarInstructor")
				public String eliminarInstructor(@RequestParam("instructorId") int elId) {
					
					// Eliminar el alumno seleccionado
					instructorService.eliminarInstructor(elId);
					
					return "redirect:/instructor/listado";
				}
				
				
				@GetMapping("/buscarInstructores")
			    public String buscarInstructores(@RequestParam("theSearchName") String theSearchName,
			                                    Model theModel) {

			        // busca instructores desde el servicio alumnoService
					
			        List<Instructor> losInstructores = instructorService.buscarInstructores(theSearchName);
			                
			        // añadimos los alumnos al modelo 
			        
			        theModel.addAttribute("instructores", losInstructores);

			        return "list-instructores";        
			    }
				

}
