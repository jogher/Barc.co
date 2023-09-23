package interfaz;

public class Producto {
	private int id;
	private String nombre;
	private int tamano;
	private double precio;
	private  Proveedor proveedor;
	public Producto(int id, String nombre, int tamano, double precio, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
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
	public int getTamano() {
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
	public Proveedor getProveedor() {
		return proveedor;
	}
	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	} 
	
	
}
