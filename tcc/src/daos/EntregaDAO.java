package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import models.Aluno;
import models.Atividade;
import models.Entrega;

public class EntregaDAO {
	private Connection connection;
	
	public EntregaDAO() {
		connection = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar(Entrega entrega) {

		String sql = "insert into entregas (descricao, dataDaEntrega, atividade_id, aluno_id) values (?, ?, ?, ?);";

		try {
			java.sql.PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setString(1, entrega.getDescricao());
			stmt.setTimestamp(2, new java.sql.Timestamp(entrega.getDataDeEntrega().getTimeInMillis()));
			stmt.setLong(3, entrega.getAtividade().getId());
			stmt.setLong(4, entrega.getAluno().getId());

			stmt.execute();
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

		return true;
	}

	public List<Entrega> getLista() {
		try {

			List<Entrega> entregas = new ArrayList<Entrega>();
			PreparedStatement stmt = connection.prepareStatement("select * from entregas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Entrega entrega = new Entrega();
				entrega.setId(rs.getInt("id"));
				
				entrega.setDescricao("descricao");
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno_id"));
				entrega.setAluno(aluno);
				Atividade atividade = new AtividadeDAO().getAtividadeByID(rs.getInt("atividade_id"));
				entrega.setAtividade(atividade);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("dataDaEntrega"));
				entrega.setDataDeEntrega(data);

				entregas.add(entrega);
			}
			rs.close();
			stmt.close();
			return entregas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public List<Entrega> getLista(Atividade atividade) {
		try {

			List<Entrega> entregas = new ArrayList<Entrega>();
			PreparedStatement stmt = connection.prepareStatement("select * from entregas where atividade_id = ?;");
			stmt.setLong(1, atividade.getId());
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Entrega entrega = new Entrega();
				entrega.setId(rs.getInt("id"));
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno_id"));
				entrega.setAluno(aluno);
				Atividade a = new AtividadeDAO().getAtividadeByID(rs.getInt("atividade_id"));
				entrega.setAtividade(a);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getTimestamp("dataDaEntrega"));
				entrega.setDataDeEntrega(data);

				entregas.add(entrega);
			}
			rs.close();
			stmt.close();
			return entregas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public boolean entregar(Entrega entrega) {
		
		String sql = "update atividades set dataDaEntrega=? where aluno_id=? and atividade_id=?;";
		try {
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
			stmt.setDate(1, new java.sql.Date(Calendar.getInstance().getTimeInMillis()));			
			stmt.setLong(2, entrega.getAluno().getId());
			stmt.setLong(3, entrega.getAtividade().getId());

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}