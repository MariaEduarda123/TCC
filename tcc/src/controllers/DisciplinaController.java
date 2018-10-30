package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.DisciplinaDAO;
import models.Disciplina;

@Controller
public class DisciplinaController {
	
	@RequestMapping("/disciplinas/form")
	public String form() {
		return "disciplinas/form";
	}
	
	@PostMapping("/disciplinas")
	public String adicionar(Disciplina disciplina) {
		System.out.println(disciplina);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.adicionar(disciplina);
		
		return "redirect:disciplinas";
	}
	
	@GetMapping("/disciplinas")
	public ModelAndView listar() {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		List<Disciplina> lista = disciplinaDAO.getLista();
		ModelAndView model = new ModelAndView("disciplinas/listaDisciplinas");
		model.addObject("disciplinas", lista);

		return model;
	}
	
	@RequestMapping("/disciplinas/remover")
	public ModelAndView remover(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.remover(disciplina);
		
		return listar();
	}


}
