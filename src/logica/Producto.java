package logica;

public class Producto {
	
	private int id;
	private String nombre;
	private double tamano;
	private double precio;
	private int stock;
	private  Proveedor proveedor;
	private String foto;
	
	public Producto(int id, String nombre, double tamano, double precio, int stock, Proveedor proveedor) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
	}
	
	 public Producto(int id, String nombre, double precio, int stock) {
	        this.id = id;
	        this.nombre = nombre;
	        this.precio = precio;
	        this.stock = stock;
	       
	    }
	 	
	
	public Producto(int id, String nombre, double tamano, double precio, int stock, Proveedor proveedor, String foto) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
		this.stock = stock;
		this.proveedor = proveedor;
		this.foto = foto;
	}
	
	public Producto(int id_producto, String nombre, double tamano, double precio, int stock) {
		super();
		this.id = id_producto;
		this.nombre = nombre;
		this.tamano = tamano;
		this.precio = precio;
		this.stock = stock;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
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
