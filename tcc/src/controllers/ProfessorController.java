package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.AlunoDAO;
import daos.ProfessorDAO;
import models.Aluno;
import models.Professor;

@Controller
@RequestMapping("/professores")
public class ProfessorController {

	@RequestMapping("/adicionarProfessor")
	public String form() {
		return "professores/adicionarProfessor";
	}
	
	@PostMapping
	public String adicionar(Professor professor) {
		System.out.println(professor);
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.adicionar(professor);
		
		return "redirect:professores";
	}
	
	@GetMapping
	public ModelAndView listar() {
		ProfessorDAO professorDAO = new ProfessorDAO();
		List<Professor> lista = professorDAO.getLista();
		ModelAndView model = new ModelAndView("professores/listaProfessores");
		model.addObject("professores", lista);

		return model;
	}
	
	@RequestMapping("/selecionarProfessor")
	public ModelAndView selecionar (Professor professor) {
		System.out.println("chamou o método selecionar");
		ProfessorDAO professorDAO = new ProfessorDAO();
		professor = professorDAO.getProfessorByID((long) professor.getId());
		
		ModelAndView model = new ModelAndView("professores/alterarProfessor");
		model.addObject("professor", professor);
		
		return model;		
	}
	
	@PostMapping("/alterar")
	public String alterar(Professor professor) {
		System.out.println("chamou o método alterar");
		System.out.println(professor);
		ProfessorDAO professorDAO = new ProfessorDAO();
		professorDAO.alterar(professor);
		
		return "redirect:/professores";
	}

	
}
