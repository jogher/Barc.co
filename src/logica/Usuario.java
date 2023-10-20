package logica;

import javax.swing.JOptionPane;

public class Usuario extends Persona{
	
	public Usuario(int id, int dni, String nombre, String apellido, String telefono, String email, String contrasena) {
		super(id, dni, nombre, apellido, telefono, email, contrasena);
		// TODO Auto-generated constructor stub
	}

	public Usuario() {
		super();
		
	}
	
	public boolean IniciarSesion() {
		if(this.ValidarNombre(this.getNombre()) && this.ValidarContrasena(this.getContrasena())) {
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Contrasena incorrecta");
			return false;
		}		
		
	}
	

}
