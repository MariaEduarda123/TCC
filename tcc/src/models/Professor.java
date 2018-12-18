package models;

import java.util.List;

public class Professor {
	private int id;
	private String Nome;
	private String Matricula;
	private List<Turma> turmas;
	
	public int getId() {
		return id;
	}

	public void setId(int iD) {
		id = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getMatricula() {
		return Matricula;
	}

	public void setMatricula(String matricula) {
		Matricula = matricula;
	}

	public List<Turma> getTurmas() {
		return turmas;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}
}
