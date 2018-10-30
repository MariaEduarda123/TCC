package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

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
	
	public void remover(Disciplina disciplina) {
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("delete from disciplinas where id=?;");
			stmt.setLong(1, disciplina.getID());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
