package models;

import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;

public class Entrega {
	private int id;
	@DateTimeFormat(pattern = "dd/mm/yyyy")
	private Calendar DataDeEntrega;
	private String descricao;
	private Atividade atividade;
	private Aluno aluno;

	public Calendar getDataDeEntrega() {
		return DataDeEntrega;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setDataDeEntrega(Calendar dataDeEntrega) {
		DataDeEntrega = dataDeEntrega;
	}

	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
