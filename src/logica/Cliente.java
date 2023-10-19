package logica;

import java.util.ArrayList;

public class Cliente extends Persona{

	/*Constructores*/
	public Cliente(int id, int dni, String nombre, String apellido, String telefono, String email, String contrasena) {
		super(id, dni, nombre, apellido, telefono, email, contrasena);
	}
	/*Funciones*/
	public void hacerPedido(ArrayList<Producto> productos) {
		ArrayList<Producto> listaProductos = null;
		listaProductos.addAll(productos);
	}
	
	

}
