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
@RequestMapping("/alunos")
public class AlunoController {

	@RequestMapping("/adicionarAluno")
	public String form() {
		return "alunos/adicionarAluno";
	}
	
	@PostMapping
	public String adicionar(Aluno aluno) {
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.adicionar(aluno);
		
		return "redirect:alunos";
	}
	
	@GetMapping
	public ModelAndView listar() {
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> lista = alunoDAO.getLista();
		ModelAndView model = new ModelAndView("alunos/listaAlunos");
		model.addObject("alunos", lista);

		return model;
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Aluno aluno) {
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.remover(aluno);
		
		return listar();
	}
	
	@RequestMapping("/selecionarAluno")
	public ModelAndView selecionar (Aluno aluno) {
		System.out.println("chamou o método selecionar");
		AlunoDAO alunoDAO = new AlunoDAO();
		aluno = alunoDAO.getAlunoByID((long) aluno.getId());
		
		ModelAndView model = new ModelAndView("alunos/alterarAluno");
		model.addObject("aluno", aluno);
		
		return model;
	}
	
	@PostMapping("/alterar")
	public String alterar(Aluno aluno) {
		System.out.println("chamou o método alterar");
		System.out.println(aluno);
		AlunoDAO alunoDAO = new AlunoDAO();
		alunoDAO.alterar(aluno);
		
		return "redirect:/alunos";
	}

	
}
