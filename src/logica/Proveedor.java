package logica;

import java.util.ArrayList;

public class Proveedor {
	private int id;
	private String nombre; 
	private String rubro;
	private String ubicacion;
	private String telefono; 
	private String email;
	private Producto[] productos;
	public Proveedor(int id, String nombre, String rubro, String ubicacion, String telefono, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.rubro = rubro;
		this.ubicacion = ubicacion;
		this.telefono = telefono;
		this.email = email;
		
		
		this.productos = new Producto [0];
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRubro() {
		return rubro;
	}
	public void setRubro(String rubro) {
		this.rubro = rubro;
	}
	public String getUbicacion() {
		return ubicacion;
	}
	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
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
	public Producto[] getProductos() {
		return productos;
	}
	public void setProductos(Producto[] productos) {
		this.productos = productos;
	}
	
	public void agregarStock(int id, int stock, ArrayList <Producto> producto) {
		for (int i = 0; i < productos.length; i++) {
			Producto produ = productos[i];
			if (id==produ.getId()) {
				produ.setStock(stock);
			}
		}
	}
	
	
	
	
	

	

}
