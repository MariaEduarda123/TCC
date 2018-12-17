package models;
public class Turma {
	private int id;
	private String Nome;
	private Professor professor;
	private Disciplina disciplina;

	public int getID() {
		return id;
	}

	public void setID(int iD) {
		id = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	
}
