package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.TurmaDAO;
import models.Turma;

@Controller
@RequestMapping("/turmas")
public class TurmaController {
	
	@RequestMapping("/adicionarTurma")
	public String form() {
		return "turmas/adicionarTurma";
	}
	
	@PostMapping
	public String adicionar(Turma turma) {
		TurmaDAO turmaDAO = new TurmaDAO();
		
		System.out.println("Turma: " + turma.getNome());
		System.out.println("Professor id: " + turma.getProfessor());
		System.out.println("Disciplina id: " + turma.getDisciplina());
		turmaDAO.adicionar(turma);
		
		return "redirect:turmas";
	}
	
	@GetMapping
	public ModelAndView listar() {
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> lista = turmaDAO.getLista();
		ModelAndView model = new ModelAndView("turmas/listaTurmas");
		model.addObject("turmas", lista);

		return model;
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Turma turma) {
		TurmaDAO turmaDAO = new TurmaDAO();
		turmaDAO.remover(turma);
		
		return listar();
	}


}
