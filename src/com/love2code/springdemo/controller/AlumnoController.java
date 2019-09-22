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

import com.love2code.springdemo.entity.Alumno;
import com.love2code.springdemo.service.AlumnoService;


@Controller
@RequestMapping("/alumno")
public class AlumnoController {
	
	//se inyecta el alumno DAO en este controlador
	
	@Autowired
	private AlumnoService alumnoService;
	
	//Método para listar todos los alumnos de la base de datos
	@GetMapping("/listado")
	public String listadoAlumnos(Model theModel) {		
				
		// Recuperamos los alumnos del servicio AlumnoService
		
		List<Alumno> losAlumnos= alumnoService.getAlumnos();
		
		//Añadimos los alumnos al modelo de spring mvc
		
		theModel.addAttribute("alumnos", losAlumnos);
		
		return "list-alumnos";
	}
	
	
	// método para mostrar el formulario para añadir un nuevo alumno
	@GetMapping("/mostrarFormAgregarAlumno")
	public String mostrarFormAgregarAlumno(Model theModel) {
		
		// Crear model attribute para enlazarlo con los datos del formulario

		Alumno elAlumno=new Alumno();
		
		theModel.addAttribute("alumno", elAlumno);

		return "alumno-form";

		
	}

	// método que llama a la capa de servicio para guardar un nuevo alumno
	@PostMapping("/guardarAlumno")
	public String guardarAlumno(@Valid @ModelAttribute("alumno") Alumno elAlumno,
			BindingResult theBindingResult) { 
		
		if (theBindingResult.hasErrors()) {
			
			// si se han producido errores de validación se vuelve a mostrar el formulario de añadir alumno
			return "alumno-form";
		}
		else {
			
			//Si no se han producido errores de validación guardamos el alumno usando la capa de servicio alumnoService
			alumnoService.guardarAlumno(elAlumno);
			return "redirect:/alumno/listado";
		}
		
		
		
		
	}


	// método que muestra el formulario con los datos del alumno seleccionado
	@GetMapping("/mostrarFormForUpdate")
	public String mostrarFormForUpdate(@RequestParam("alumnoId") int theId,
			Model theModel) {

			// busca el alumno desde nuestro servicio alumnoService 
		
			Alumno elAlumno=alumnoService.getAlumno(theId);
			
				
			// el alumno lo configuramos como un model attribute para rellenar el formulario con los datos del alumno
			
			theModel.addAttribute("alumno",elAlumno);			

			// devuelve la información al formulario alumno-form.jsp

			return "alumno-form";


			}
	
	// método para eliminar el alumno seleccionado del listado
	@GetMapping("/eliminarAlumno")
	public String eliminarAlumno(@RequestParam("alumnoId") int elId) {
		
		// Eliminar el alumno seleccionado
		alumnoService.eliminarAlumno(elId);
		
		return "redirect:/alumno/listado";
	}
	
	
	@GetMapping("/buscarAlumnos")
    public String buscarAlumnos(@RequestParam("theSearchName") String theSearchName,
                                    Model theModel) {

        // busca alumnos desde el servicio alumnoService
		
        List<Alumno> losAlumnos = alumnoService.buscarAlumnos(theSearchName);
                
        // añadimos los alumnos al modelo 
        
        theModel.addAttribute("alumnos", losAlumnos);

        return "list-alumnos";        
    }
	
	
}
