package com.patriciocontreras.SistEscuela.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.patriciocontreras.SistEscuela.app.models.dao.IEscuelaDao;

@Controller
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
}
