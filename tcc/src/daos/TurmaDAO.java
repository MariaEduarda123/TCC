package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Turma;
import models.Turma;

public class TurmaDAO {

private Connection con;
	
	public TurmaDAO () {
		con = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Turma turma) {
		String sql = "insert into turmas (nome) values (?);";
		
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement(sql);
			
			stmt.setString(1, turma.getNome());
			
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
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("select * from turmas;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Turma turma = new Turma();
				turma.setNome(rs.getString("nome"));

				turmas.add(turma);
			}
			rs.close();
			stmt.close();
			return turmas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void remover(Turma turma) {
		try {
			PreparedStatement stmt = (PreparedStatement) con.prepareStatement("delete from turmas where id=?;");
			stmt.setLong(1, turma.getID());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Turma getTurmaByID(Long id) {
		try {

			Turma turma = null;
			PreparedStatement stmt = (PreparedStatement) this.con.prepareStatement("select * from turmas where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				turma = new Turma();
				turma.setID(rs.getInt("id"));
				turma.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
			return turma;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
