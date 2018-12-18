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
@RequestMapping("/disciplinas")
public class DisciplinaController {
	
	@RequestMapping("/adicionarDisciplina")
	public String form() {
		return "disciplinas/adicionarDisciplina";
	}
	
	@PostMapping
	public String adicionar(Disciplina disciplina) {
		System.out.println(disciplina);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.adicionar(disciplina);
		
		return "redirect:disciplinas";
	}
	
	@GetMapping
	public ModelAndView listar() {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		List<Disciplina> lista = disciplinaDAO.getLista();
		ModelAndView model = new ModelAndView("disciplinas/listaDisciplinas");
		model.addObject("disciplinas", lista);

		return model;
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Disciplina disciplina) {
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.remover(disciplina);
		
		return listar();
	}


}
