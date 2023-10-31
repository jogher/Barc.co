package logica;

import javax.swing.JOptionPane;

public class Usuario {
	
	
	    private String nombre;
	    private String email;
	    private String tipo;

	   
	    public Usuario(String nombre, String email, String tipo) {
	        this.nombre = nombre;
	        this.email = email;
	        this.tipo = tipo;
	    }

	   
	    public String getNombre() {
	        return nombre;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getTipo() {
	        return tipo;
	    }
	

	

}
