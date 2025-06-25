package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.ConexaoLogin;

public class LoginDAO {

	public static boolean validarLogin(String usuario, String senha) {
		String sql = "SELECT * FROM usuarios WHERE usuario = ? AND senha = ?";
		
		try (Connection conn = ConexaoLogin.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)){
			
			stmt.setString(1, usuario);
			stmt.setString(2, senha);
			
			ResultSet rs = stmt.executeQuery();
			return rs.next(); //Se tiver resultado, o login é válido.
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
