package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoLogin {
	
	private static final String URL = "jdbc:mysql://localhost:3306/login";
	private static final String USER = "root";
	private static final String SENHA = "daniel123";
	
	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection(URL, USER, SENHA);
		}catch (ClassNotFoundException e) {
			throw new SQLException("Driver JDBC não encontrado.", e);
		}
	}

}
