package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Aluno;

public class AlunoDAO {
	private Connection connection;

	public AlunoDAO() {
		connection = ConnectionFactory.getConnetion();
	}

	public boolean adicionar(Aluno aluno) {

		String sql = "insert into alunos (nome, matricula) values (?, ?);";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Aluno> getLista() {
		try {

			List<Aluno> alunos = new ArrayList<Aluno>();
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from alunos;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));

				alunos.add(aluno);
			}

			rs.close();
			stmt.close();

			return alunos;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public boolean alterar(Aluno aluno) {
		String sql = "update alunos set nome=?, matricula=? where id=?;";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			stmt.setInt(3, aluno.getId());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public Aluno getAlunoByID(Long id) {

		try {

			Aluno aluno = null;
			PreparedStatement stmt = (PreparedStatement) this.connection
					.prepareStatement("select * from alunos where id=?;");
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				aluno = new Aluno();
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setMatricula(rs.getString("matricula"));

			}

			rs.close();
			stmt.close();

			return aluno;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}