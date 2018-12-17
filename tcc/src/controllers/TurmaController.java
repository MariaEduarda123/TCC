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
	
	@RequestMapping("/turmas/form")
	public String form() {
		return "turmas/form";
	}
	
	@PostMapping("/turmas")
	public String adicionar(Turma turma) {
		TurmaDAO turmaDAO = new TurmaDAO();
		turmaDAO.adicionar(turma);
		
		return "redirect:turmas";
	}
	
	@GetMapping("/turmas")
	public ModelAndView listar() {
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> lista = turmaDAO.getLista();
		ModelAndView model = new ModelAndView("turmas/listaTurmas");
		model.addObject("turmas", lista);

		return model;
	}
	
	@RequestMapping("/turmas/remover")
	public ModelAndView remover(Turma turma) {
		TurmaDAO turmaDAO = new TurmaDAO();
		turmaDAO.remover(turma);
		
		return listar();
	}


}
