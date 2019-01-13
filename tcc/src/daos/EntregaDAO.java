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

	public List<Entrega> getLista() {
		try {

			List<Entrega> entregas = new ArrayList<Entrega>();
			PreparedStatement stmt = connection.prepareStatement("select * from entregas");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Entrega entrega = new Entrega();

				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno_id"));
				entrega.setAluno(aluno);
				Atividade atividade = new AtividadeDAO().getAtividadeByID(rs.getInt("atividade_id"));
				entrega.setAtividade(atividade);
				
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEntrega"));
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
		
		String sql = "update atividades set dataEntrega=? where aluno_id=? and atividade_id=?;";
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