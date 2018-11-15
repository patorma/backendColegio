package com.patriciocontreras.SistEscuela.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.patriciocontreras.SistEscuela.app.models.entity.Asignatura;
import com.patriciocontreras.SistEscuela.app.models.service.IAsignaturaService;

@Controller
@SessionAttributes("asignatura")
public class AsignaturaController {
	
	@Autowired
	private IAsignaturaService asignaturaService;
	
	@RequestMapping(value="/asignaturas",method=RequestMethod.GET)
	public String listar(Model model) {
		
		model.addAttribute("titulo", "Lista de Asignaturas");
		model.addAttribute("asignaturas",asignaturaService.findAll());
		return "/asignaturas";
	}
	
	@RequestMapping(value="/registrar-asignatura")
	public String crear(Map<String, Object> model) {
		Asignatura asignatura = new Asignatura();
		model.put("asignatura", asignatura);
		model.put("titulo", "Formulario de Asignatura");
		return "registrar-asignatura";
	}
	
	@RequestMapping(value="/registrar-asignatura/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Asignatura asignatura = null;
		
		if(id > 0) {
			asignatura = asignaturaService.findOne(id);
		} else {
			return "redirect:/asignaturas";
		}
		model.put("asignatura", asignatura);
		model.put("titulo", "Editar Asignatura");
		
		return "registrar-asignatura";
	}
	
	@RequestMapping(value="/registrar-asignatura",method=RequestMethod.POST)
	public String guardar(@Valid Asignatura asignatura, BindingResult result ,Model model, SessionStatus status) {
		
		if(result.hasErrors()) {
			model.addAttribute("titulo","Formulario de Asignatura" );
			return "registrar-asignatura";
		}
		asignaturaService.save(asignatura);
		status.setComplete();
		return "redirect:/asignaturas";
	}
	
	@RequestMapping(value="/eliminarA/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		
		if(id > 0) {
			asignaturaService.delete(id);
		}
		return "redirect:/asignaturas";
	}

}
