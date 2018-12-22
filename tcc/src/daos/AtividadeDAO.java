package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Turma;
import models.Aluno;
import models.Atividade;
import models.Disciplina;
import models.Professor;
import models.Turma;

public class AtividadeDAO {

	private Connection connection;
	
	public AtividadeDAO() {
		connection = ConnectionFactory.getConnetion();
	}
	
	public boolean adicionar (Atividade atividade) {
		
		String sql = "insert into atividades (descricao, dataEntrega, turma_id) values (?, ?, ?);";
		
		try {
			
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);

			Calendar data = Calendar.getInstance();
			Long dataT = data.getTimeInMillis();

			stmt.setString(1, atividade.getDescricao());
			stmt.setDate(2, new java.sql.Date(dataT));
			stmt.setLong(3, atividade.getTurma().getID());

			stmt.execute();
			stmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
			return true;
		}
		
		return false;
	}
	
	public List<Atividade> getAtividades() {
		List<Atividade> atividades = new ArrayList<>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from atividades;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Atividade atividade = new Atividade();
				Turma turma = new TurmaDAO().getTurmaByID(rs.getLong("id"));
				atividade.setTurma(turma);

				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEntrega"));
				atividade.setDataEntrega(data);

				if (rs.getDate("dataEntrega") != null) {
					data.setTime(rs.getDate("dataEntrega"));

					atividade.setDataEntrega(data);

				} else {
					atividade.setDataEntrega(null);
				}

				atividades.add(atividade);
			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return atividades;
	}

	public List<Atividade> getAtividadesAtrasadas() {
		List<Atividade> result = new ArrayList<>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from atividades where dataEntrega IS NULL and dataEntrega < ?;");
			Calendar data = Calendar.getInstance();
			stmt.setDate(1, new Date(data.getTimeInMillis() - 14 * 24 * 60 * 60 * 1000));
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Atividade atividade = new Atividade();
				Calendar dataEntregao = Calendar.getInstance();
				dataEntregao.setTime(rs.getDate("dataEntrega"));
//				atividade.setDataEntrega("dataEntrega");
				Turma turma = new TurmaDAO().getTurmaByID(rs.getLong("id"));
				atividade.setTurma(turma);

				result.add(atividade);


			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public List<Atividade> getEmprestimosAtivos() {
		List<Atividade> atividades = new ArrayList<>();

		try {
			PreparedStatement stmt = (PreparedStatement) this.connection.prepareStatement("select * from atividade where dataEntrega IS NULL;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				Atividade atividade = new Atividade();
				Turma turma = new TurmaDAO().getTurmaByID(rs.getLong("id"));
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEntrega"));
//				atividade.setDataEmprestimo(data);
				atividade.setTurma(turma);

				atividades.add(atividade);

			}
			rs.close();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return atividades;
	}
		
		public void remover (Atividade atividade) {
			try {
				PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("delete from atividades where id=?;");
				stmt.setLong(1, atividade.getId());
				stmt.execute();
				stmt.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}

		}

	

}
