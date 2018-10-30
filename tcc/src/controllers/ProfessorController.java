package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.ProfessorDAO;
import models.Professor;

@Controller
public class ProfessorController {

	@RequestMapping("/professores/adicionarProfessor")
	public String form() {
		return "professores/adicionarProfessor";
	}
	
	@PostMapping("/professores")
	public String adicionar(Professor professor) {
		System.out.println(professor);
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.adicionar(professor);
		
		return "redirect:professores";
	}
	
	@GetMapping("/prefossores")
	public ModelAndView listar() {
		ProfessorDAO professorDAO = new ProfessorDAO();
		List<Professor> lista = professorDAO.getLista();
		ModelAndView model = new ModelAndView("professores/listaProfessores");
		model.addObject("professores", lista);

		return model;
	}
	
	@RequestMapping("/professores/remover")
	public ModelAndView remover(Professor professor) {
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.remover(professor);
		
		return listar();
	}

	
}
