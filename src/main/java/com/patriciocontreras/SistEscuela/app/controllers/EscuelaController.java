package com.patriciocontreras.SistEscuela.app.controllers;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.patriciocontreras.SistEscuela.app.models.dao.IEscuelaDao;
import com.patriciocontreras.SistEscuela.app.models.entity.Escuela;

@Controller
@SessionAttributes("escuela")//se guarda el objeto del formulario dentro del sessionAtributes
public class EscuelaController {
	//se crea el metodo listar, para listar los colegios
	//se importa Model para pasar datos a la vista
	//con @Autowired se hace inyeccion de dependencia
	@Autowired //busca un componente registrado en el contenedor,busca un bean con esa interface
	@Qualifier("escuelaDaoJPA")//se indica nombre de componente para seleccionar bean concreto
	private IEscuelaDao escuelaDao;
	
	@RequestMapping(value="/listar",method=RequestMethod.GET)//se da la ruta de la vista
	public String listar (Model model) {
		model.addAttribute("titulo", "Listado de Colegios");
		model.addAttribute("escuelas",escuelaDao.findAll());//se pasa el listado de colegios a la vista
		return "listar";//se retorna nombre de la vista
	}
	
	@RequestMapping(value="/form")//el metodo get se encarga de mostrar el formulario al usuario
	public String crear(Map<String, Object> model) {//Object tipo del objeto porque guarda cualquier cosa
		Escuela escuela = new Escuela();//se crea instancia de nuevo objeto escuela
		model.put("escuela", escuela);//se pasa el objeto cliente a la vista
		model.put("titulo", "Formulario de Colegio");
		return "form";
		//la primera fase es mostrar el formulario al usuario
		//la segunda fase es cuando el suaurio envia en el submit los datos
		//del formulario, se hace un metodo aca en el controlador que procesa los datos
	}
	//@PathVariable es para que inyecte el valor del parametro de la ruta
	@RequestMapping(value="/form/{id}")
	public String editar(@PathVariable(value="id") Long id, Map<String, Object> model) {
		
		Escuela escuela = null;
		if(id > 0) {
			escuela = escuelaDao.findOne(id);
		} else {
			return "redirect:/listar";
		}
		model.put("escuela", escuela);
		model.put("titulo", "Editar Colegio");
		return "form";
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public String guardar(@Valid Escuela escuela, BindingResult result, Model model, SessionStatus status) {
		
		if(result.hasErrors()) {//si el resultado de la evaluacion del BindingREsult tiene error
			model.addAttribute("titulo", "Formulario de Colegio");
			return "form";
		}
		escuelaDao.save(escuela);
		status.setComplete();//elimina el objeto escuela de la session
		return "redirect:listar";
	}
	
	@RequestMapping(value="/eliminar/{id}")
	public String eliminar(@PathVariable(value="id") Long id) {
		if(id > 0) {
			escuelaDao.delete(id);
		}
		return "redirect:/listar";
	}
}
