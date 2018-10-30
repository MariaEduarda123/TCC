package daos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import models.Aluno;
import models.Atividade;
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
	
	public List<Atividade> getAtividadesParaFazer() {
		
		List<Atividade> atividades = new ArrayList<Atividade>();
		
		try {
				
			PreparedStatement stmt = (PreparedStatement) connection.prepareStatement("select * from atividades where dataEntrega is null;");
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				
				Atividade atividade = new Atividade();
				Turma turma = new TurmaDAO().getTurmaByID(rs.getLong("turma_id"));
				Aluno aluno = new AlunoDAO().getAlunoByID(rs.getLong("aluno_id"));

				atividade.setTurma(turma);
				Calendar data = Calendar.getInstance();
				data.setTime(rs.getDate("dataEntrega"));
				atividade.setDataEntrega(data);

				if (rs.getDate("dataEntrega") != null) {
					Calendar dataEntrega = Calendar.getInstance();
					dataEntrega.setTime(rs.getDate("dataEntrega"));
					atividade.setDataEntrega(dataEntrega);
				}

				atividades.add(atividade);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return atividades;
		
	}
}