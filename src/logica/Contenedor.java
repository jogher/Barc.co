package logica;

import java.util.ArrayList;

public class Contenedor {
	
	private int id;
	private int capacidad;
	private String color;
	private int id_barco;
	private Pedido pedido; // esto para almacenar el pedido en el contenedor 	
	
	public Contenedor(int id, int capacidad, String color, int id_barco) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.color = color;
		this.id_barco = id_barco;
	}
	public Contenedor() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	// el metodo para agregar el pedido al contenedor 
	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}
	@Override
	public String toString() {
		return "Contenedor [id=" + id + ", capacidad=" + capacidad + ", color=" + color + "]";
	}
	public Object getPedido() {
		
		return pedido;
	}
	public void agregarProductos(ArrayList<Producto> productos) {
		for (Producto producto : productos) {
	       
	        System.out.println("Producto agregado al contenedor con ID: " + producto.getId() + producto.getNombre());
	    }
		
		
	}
	public int getId_barco() {
		return id_barco;
	}
	public void setId_barco(int id_barco) {
		this.id_barco = id_barco;
	}
	
	
	
	
	
	

}
