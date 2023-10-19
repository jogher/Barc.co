package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DLL.Conexion;

public interface validador {
	
	public default boolean ValidarContrasena(String contrasena)	{
		for (int i = 0; i < contrasena.length(); i++) {
			if (!Character.isAlphabetic(contrasena.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public default boolean ValidarMail(String usuario) {
		
		if(usuario.contains("@") && usuario.contains(".com")) {
			return true;
		} else {
			return false;
		}
	}
	
	public default boolean ValidarNombre(String nombre) {
		
		if(nombre != null && !nombre.trim().isEmpty()) { // ultilizo para verificar que el nombre no sea nulo y 
			return true; // va ser un nombre valido        que no este vacio o contenga solo espacios
		} else {
			return false;
		}
		
	}
	
	
	Conexion conexion = new Conexion(); 
	Connection con = conexion.conectar();
	PreparedStatement stmt;
	
	public default boolean IniciarSesion(String email, String contrasena, String rol) {
		String sql = "select email, contrasena from "+rol+" where email=? and contrasena=?";
		boolean devolver = false; 
		try {
			stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, contrasena);
			ResultSet resultado = stmt.executeQuery();
			while(resultado.next()) {
				if (resultado.getString("email")==email && resultado.getString("contrasena")==contrasena) {
					devolver = true;
				} else {
					devolver = false;
				}
			}
		} catch (Exception e) {
			devolver = false;
		}
		return devolver;
	}
	
}
