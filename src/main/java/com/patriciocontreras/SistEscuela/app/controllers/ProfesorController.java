package com.patriciocontreras.SistEscuela.app.controllers;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.patriciocontreras.SistEscuela.app.models.entity.Profesor;
import com.patriciocontreras.SistEscuela.app.models.service.IProfesorService;

@Controller
@SessionAttributes("profesor")
public class ProfesorController {
	
	@Autowired
	private IProfesorService profesorService;
	
	@RequestMapping(value="listarprofes",method=RequestMethod.GET)
	public String listar (Model model) {
		model.addAttribute("titulo", "Listado Profesores");
		model.addAttribute("profesores",profesorService.findAll());
		return "listarprofes";
		
	}
	
	@RequestMapping(value="/formprofe")
	public String crearProfe(Map<String, Object> model) {
		Profesor profesor = new Profesor();
		model.put("profesor", profesor);
		model.put("titulo", "Formulario de Profesor");
		return "formprofe";
	}
	

}
