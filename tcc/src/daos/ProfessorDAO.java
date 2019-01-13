package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Professor;
import models.Professor;

public class ProfessorDAO {

private Connection connection;
	
	public ProfessorDAO () {
		connection = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Professor professor) {
		String sql = "insert into professores (nome, matricula) values (?, ?);";
		
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getMatricula());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public List<Professor> getLista(){
		try {

			List<Professor> professores = new ArrayList<Professor>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from professores;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Professor professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));

				professores.add(professor);
			}
			rs.close();
			stmt.close();
			return professores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public boolean alterar (Professor professor) {
		String sql = "update professores set nome=?, matricula=? where id=?;";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, professor.getNome());
			stmt.setString(2, professor.getMatricula());
			stmt.setInt(3, professor.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
}

	public Professor getProfessorByID(long id) {
		try {

			Professor professor = null;
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from professores where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				professor = new Professor();
				professor.setId(rs.getInt("id"));
				professor.setNome(rs.getString("nome"));
				professor.setMatricula(rs.getString("matricula"));
				
			}
			
			rs.close();
			stmt.close();
			
			return professor;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}