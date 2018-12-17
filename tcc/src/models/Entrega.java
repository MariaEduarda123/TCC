package models;
public class Entrega {
	private String Data;
	private Atividade atividade;
	private Aluno aluno;

	public String getData() {
		return Data;
	}

	public void setData(String data) {
		Data = data;
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
}
