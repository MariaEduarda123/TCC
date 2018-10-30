package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static Connection con = null;
	private static final String banco = "borboletas";
	private static final String user = "root";
	private static final String password = "lab02";

	public static Connection getConnetion() {
		if (con == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/" + banco, user, password);

			} catch (SQLException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection c = ConnectionFactory.getConnetion();
		System.out.println(c);
	}

}
