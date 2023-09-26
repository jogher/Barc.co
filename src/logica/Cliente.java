package logica;

public class Cliente extends Persona{
	
	private String telefono;
	private String email;
	
	public Cliente(int id, int dni, String nombre, String apellido, String telefono, String email) {
		super(id, dni, nombre, apellido);
		this.telefono = telefono;
		this.email = email;
	}

	public String getTelefono() {
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
	
	
	
	

}
