package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Professor;

public class ProfessorDAO {

private Connection con;
	
	public ProfessorDAO () {
		con = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Professor professor) {
		String sql = "insert into professores (nome, matricula) values (?, ?);";
		
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
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
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from professores;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Professor professor = new Professor();
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
	
	public void remover(Professor professor) {
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("delete from professores where id=?;");
			stmt.setLong(1, professor.getID());
			
			stmt.execute();
			stmt.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
