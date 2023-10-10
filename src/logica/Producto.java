package logica;

public class Producto {
	
	private int id;
	private String nombre;
	private double tamano;
	private double precio;
	private int stock;
	private  Proveedor proveedor;
	
	public Producto(int id, String nombre, double tamano, double precio, int stock, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
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
	public double getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	} 
	
	
}
