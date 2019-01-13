package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Aluno;
import models.Disciplina;

public class DisciplinaDAO {

private Connection connection;
	
	public DisciplinaDAO () {
		connection = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Disciplina disciplina) {
		String sql = "insert into disciplinas (nome) values (?);";
		
		try {
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, disciplina.getNome());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Disciplina> getLista(){
		try {

			List<Disciplina> disciplinas = new ArrayList<Disciplina>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from disciplinas;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Disciplina disciplina = new Disciplina();
				disciplina.setId(rs.getInt("id"));
				disciplina.setNome(rs.getString("nome"));

				disciplinas.add(disciplina);
			}
			
			rs.close();
			stmt.close();
			
			return disciplinas;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean alterar(Disciplina disciplina) {
		String sql = "update disciplinas set nome=? where id=?;";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, disciplina.getNome());
			stmt.setInt(2, disciplina.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Disciplina getDisciplinaByID(long id) {
		try {

			Disciplina disciplina = null;
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from disciplinas where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				disciplina = new Disciplina();
				disciplina.setId(rs.getInt("id"));
				disciplina.setNome(rs.getString("nome"));
				
			}
			
			rs.close();
			stmt.close();
			
			return disciplina;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}