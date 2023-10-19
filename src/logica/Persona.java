package logica;

import javax.swing.JOptionPane;

public class Persona implements Validador {
	private int id;
	private int dni;
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String contrasena;
	



	public Persona(int id, int dni, String nombre, String apellido, String telefono, String email, String contrasena) {
		super();
		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
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
	public String getTelefono(){
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}



	public String getContrasena() {
		return contrasena;
	}



	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public boolean IniciarSesion() {
		if (this.ValidarMail(this.getEmail()) 
			&& 
			this.ValidarContrasena(this.getContrasena())) {
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "contrasena incorrecta");
			return false;
		}
			
	}
	
	public boolean IniciarSe() {
		if (this.ValidarNombre(this.getNombre()) 
			&& 
			this.ValidarContrasena(this.getContrasena())) {
			
			return true;
		}else {
			JOptionPane.showMessageDialog(null, "contrasena incorrecta");
			return false;
		}
			
	}
	
	
	
	

}
