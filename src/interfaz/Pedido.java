package interfaz;

public class Pedido {
	private int id;
	private Producto[] productos;
	private Contenedor contenedor;
	private String estado;
	public Pedido(int id, Contenedor contenedor, String estado) {
		super();
		this.id = id;
		this.contenedor = contenedor;
		this.estado = estado;
		
		this.productos = new Producto [0];
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Producto[] getProductos() {
		return productos;
	}
	public void setProductos(Producto[] productos) {
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
	
	
	
	

}
