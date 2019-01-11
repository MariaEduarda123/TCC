package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.AlunoDAO;
import daos.DisciplinaDAO;
import models.Aluno;
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
	
	@RequestMapping("/selecionarDisciplina")
	public ModelAndView selecionar (Disciplina disciplina) {
		System.out.println("chamou o método selecionar");
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplina = disciplinaDAO.getDisciplinaByID((long) disciplina.getId());
		
		ModelAndView model = new ModelAndView("disciplinas/alterarDisciplina");
		model.addObject("disciplina", disciplina);
		
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Disciplina disciplina) {
		System.out.println("chamou o método alterar");
		System.out.println(disciplina);
		DisciplinaDAO disciplinaDAO = new DisciplinaDAO();
		disciplinaDAO.alterar(disciplina);
		
		return "redirect:/disciplinas";
}



}
