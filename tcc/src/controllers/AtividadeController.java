package controllers;
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
@RequestMapping("/atividades")
public class AtividadeController {
	
	@RequestMapping("/adicionarAtividade")
	public ModelAndView form() {
		ModelAndView model = new ModelAndView("atividades/adicionarAtividade");
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> turmalista = turmaDAO.getLista();
		model.addObject("turmas", turmalista);
		return model;
	}
	
	@PostMapping
	public String adicionar(Atividade atividade) {
		System.out.println(atividade);
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		atividadeDAO.adicionar(atividade);
		return "redirect:atividades";
	}
	
	@GetMapping("/listaAtividadesParaFazer")
	public ModelAndView listarAbertos() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		List<Atividade> lista = atividadeDAO.getLista();
		ModelAndView model = new ModelAndView("atividades/listaAtividadesParaFazer");
		model.addObject("atividades", lista);
		return model;
	}
	
	@GetMapping
	public ModelAndView listar() {
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		List<Atividade> lista = atividadeDAO.getLista();
		ModelAndView model = new ModelAndView("atividades/listaAtividades");
		TurmaDAO turmaDAO = new TurmaDAO();
		List<Turma> turmalista = turmaDAO.getLista();
		EntregaDAO entregadao = new EntregaDAO();
		entregadao.getLista();
		model.addObject("atividades", lista);
		model.addObject("turmas", turmalista);
		
		return model;
	}

	@RequestMapping("/selecionarAtividade")
	public ModelAndView selecionar (int id) {
		System.out.println("chamou o método selecionar");
		AtividadeDAO atividadeDAO = new AtividadeDAO();
		Atividade atividade = atividadeDAO.getAtividadeByID(id);
		ModelAndView model = new ModelAndView("atividades/entregarAtividade");
		model.addObject("atividade", atividade);
		
		return model;
	}
	
}
