package interfaz;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import DLL.Conexion;

public class PantallaEdicionUsuario {
	public void Menu() { 
		
		String[] Opciones = {"Editar Nombre Usuario","Editar Contraseña","Salir"};
	
		int opcion = 0;
		do {
			opcion = JOptionPane.showOptionDialog(null, "Menu Usuario", null, 0, 0, null, Opciones, Opciones[0]);
			
			Conexion conexion = new Conexion(); 
			Connection con = conexion.conectar();
			PreparedStatement stmt;
			
			switch (opcion) {
			case 0:
				String sql = "UPDATE `"+rol+"` SET `email`=? WHERE id_"+rol+"='"+id+"'";
				try {
					stmt = con.prepareStatement(sql);
					stmt.setString(1, this.getUsuario());
					stmt.executeUpdate();
					return true;
				} catch (Exception e) {
					return false;
				}
				break;
			case 1:
				sql = "UPDATE `"+rol+"` SET `contrasenia`=? WHERE id_"+rol+"='"+id+"'";
				try {
					stmt = con.prepareStatement(sql);
					stmt.setString(1, this.getContrasena());
					stmt.executeUpdate();
					return true;
				} catch (Exception e) {
					return false;
				}
				break;
			case 2: 
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (opcion != 3);
	}
}
