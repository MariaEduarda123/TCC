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
		
		AlunoDAO alunoDAO = new AlunoDAO();
		ModelAndView model = new ModelAndView("entregas/entregarAtividade");
		List<Aluno> alunolista = alunoDAO.getLista();
		model.addObject("alunos", alunolista);
		
		
		return model;
	}
	
	@PostMapping
	public ModelAndView adicionar(Entrega entrega) {
		AlunoDAO alunoDAO = new AlunoDAO();
		EntregaDAO entregaDAO = new EntregaDAO();
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		entrega.setDescricao(entrega.getDescricao());
		entrega.setDataDeEntrega(Calendar.getInstance());
		entrega.setAluno(alunoDAO.getAlunoByID((long) entrega.getAluno().getId()));
		entrega.setAtividade(atividadeDAO.getAtividadeByID(entrega.getAtividade().getId()));
		
		System.out.println(entrega);
		entregaDAO.adicionar(entrega);
		return listar(entrega.getAtividade());
//		return "redirect:atividades/listaAtividadesParaFazer";
		
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
