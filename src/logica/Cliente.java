package logica;

import java.util.ArrayList;

public class Cliente extends Persona{
	/*Propiedades*/
	private String telefono;
	private String email;
	/*Constructores*/
	public Cliente(int id, int dni, String nombre, String apellido, String telefono, String email) {
		super(id, dni, nombre, apellido);
		this.telefono = telefono;
		this.email = email;
	}
	/*Getters and Setters*/
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
	/*Funciones*/
	public void hacerPedido(ArrayList<Producto> productos) {
		ArrayList<Producto> listaProductos = null;
		listaProductos.addAll(productos);
	}
	
	

}
