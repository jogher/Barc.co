package logica;

import javax.swing.JOptionPane;

public class Persona implements validador {
	private int id;
	private int dni;
	private String nombre;
	private String apellido;
	
	private String usuario;
	private String contrasena;
	



	public Persona(int id, int dni, String nombre, String apellido, String usuario, String contrasena) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.contrasena = contrasena;
	}



	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDni() {
		return dni;
	}



	public void setDni(int dni) {
		this.dni = dni;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getUsuario() {
		return usuario;
	}



	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean IniciarSesion() {
		if (this.ValidarMail(this.getUsuario()) 
			&& 
			this.ValidarContrasena(this.getContrasena())) {
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "contrasena incorrecta");
			return false;
		}
			
	}
	
	
	
	
	

}
