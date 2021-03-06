package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Aluno;
import models.Disciplina;
import models.Professor;
import models.Turma;
import models.Turma;

public class TurmaDAO {

private Connection connection;
	
	public TurmaDAO () {
		connection = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Turma turma) {
		String sql = "insert into turmas (nome, disciplina_id, professor_id) values (?, ?, ?);";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, turma.getNome());
			stmt.setLong(2, turma.getDisciplina().getId());
			stmt.setLong(3, turma.getProfessor().getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Turma> getLista(){
		try {

			List<Turma> turmas = new ArrayList<Turma>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from turmas;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Turma turma = new Turma();
				turma.setId(rs.getInt("id"));
				turma.setNome(rs.getString("nome"));
				
				turma.setProfessor(new ProfessorDAO().getProfessorByID(rs.getLong("professor_id")));
				turma.setDisciplina(new DisciplinaDAO().getDisciplinaByID(rs.getLong("disciplina_id")));
				
				turmas.add(turma);
			}
			rs.close();
			stmt.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean alterar(Turma turma) {
		String sql = "update turmas set nome=?, disciplina_id=?, professor_id=? where id=?;";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, turma.getNome());
			stmt.setInt(2, turma.getDisciplina().getId());
			stmt.setInt(3, turma.getProfessor().getId());
			stmt.setInt(4, turma.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
}

	public Turma getTurmaByID(int id) {
		try {

			Turma turma = null;
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from turmas where id=?;");
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				turma = new Turma();
				turma.setId(rs.getInt("id"));
				turma.setNome(rs.getString("nome"));
				Disciplina disciplina = new Disciplina();
				turma.setDisciplina(disciplina);
				Professor professor = new Professor();
				turma.setProfessor(professor);
			}
			rs.close();
			stmt.close();
			return turma;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}