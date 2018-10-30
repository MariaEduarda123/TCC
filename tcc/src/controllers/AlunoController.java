package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.AlunoDAO;
import models.Aluno;

@Controller
public class AlunoController {

	@RequestMapping("/alunos/adicionarAluno")
	public String form() {
		return "alunos/adicionarAluno";
	}
	
	@PostMapping("/alunos")
	public String adicionar(Aluno aluno) {
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adicionar(aluno);
		
		return "redirect:alunos";
	}
	
	@GetMapping("/alunos")
	public ModelAndView listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("alunos/listaAlunos");
		model.addObject("alunos", lista);

		return model;
	}
	
	@RequestMapping("/alunos/remover")
	public ModelAndView remover(Aluno aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.remover(aluno);
		
		return listar();
	}

	
}
