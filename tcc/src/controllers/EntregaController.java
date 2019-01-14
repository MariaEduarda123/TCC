package controllers;

import java.util.Calendar;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import daos.AlunoDAO;
import daos.AtividadeDAO;
import daos.EntregaDAO;
import daos.TurmaDAO;
import models.Aluno;
import models.Atividade;
import models.Entrega;
import models.Turma;

@Controller
@RequestMapping("/entregas")
public class EntregaController {

	@RequestMapping("/entregarAtividade")
	public ModelAndView form(Atividade atividade) {
		
		ModelAndView model = new ModelAndView("entregas/entregarAtividade");
		AlunoDAO alunoDAO = new AlunoDAO();
		List<Aluno> alunolista = alunoDAO.getLista();
		
		model.addObject("alunos", alunolista);
		
		return model;
	}
	
	@PostMapping
	public String adicionar(Entrega entrega) {
		entrega.setDataDeEntrega(Calendar.getInstance());
		System.out.println(entrega);
		EntregaDAO entregaDAO = new EntregaDAO();
		entregaDAO.adicionar(entrega);
		
//		return "redirect:atividades/listaAtividadesParaFazer";
		return "redirect:entregas/listaEntrega";
	}
	
	@GetMapping("/listaEntrega")
	public ModelAndView listar(Atividade atividade) {
		EntregaDAO entregaDAO = new EntregaDAO();
		List<Entrega> lista = entregaDAO.getLista(atividade);
		ModelAndView model = new ModelAndView("entregas/listaEntrega");
		model.addObject("entregas", lista);

		return model;
	}

	
	
	
}
