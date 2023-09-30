package logica;

import java.util.ArrayList;

public class Pedido {
	private int id;
	private ArrayList<Producto> productos;
	private Contenedor contenedor;
	private String estado;
	public Pedido(int id, Contenedor contenedor, String estado) {
		super();
		this.id = id;
		this.contenedor = contenedor;
		this.estado = estado;

	this.productos = new ArrayList<>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}
	public Contenedor getContenedor() {
		return contenedor;
	}
	public void setContenedor(Contenedor contenedor) {
		this.contenedor = contenedor;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", productos=" + productos + ", contenedor=" + contenedor + ", estado=" + estado
				+ "]";
	}


}
 
