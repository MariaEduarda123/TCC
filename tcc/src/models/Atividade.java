package models;

import java.util.Calendar;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Atividade {
	private int id;
	private String Descricao;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	private Calendar DataEntrega;
	private Turma turma;
	private List<Entrega> entregas;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
	}

	public Calendar getDataEntrega() {
		return DataEntrega;
	}

	public void setDataEntrega(Calendar dataEntrega) {
		DataEntrega = dataEntrega;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public List<Entrega> getEntregas() {
		return entregas;
	}

	public void setEntregas(List<Entrega> entregas) {
		this.entregas = entregas;
	}


}
