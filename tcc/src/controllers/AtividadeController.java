package controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.AtividadeDAO;
import models.Atividade;

@Controller
@RequestMapping("/atividades")
public class AtividadeController {

	@RequestMapping("/adicionarAtividade")
	public String form() {
		return "atividades/adicionarAtividade";
	}
	
	@PostMapping
	public String adicionar(Atividade atividade) {
		System.out.println(atividade);
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.adicionar(atividade);
		
		return "redirect:atividades";
	}
	
	@GetMapping
	public ModelAndView listar() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		List<Atividade> lista = atividadeDAO.getLista();
		ModelAndView model = new ModelAndView("atividades/listaAtividades");
		model.addObject("atividades", lista);

		return model;
	}
	
	@RequestMapping("/remover")
	public ModelAndView remover(Atividade atividade) {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.remover(atividade);
		
		return listar();
	}

	
}
