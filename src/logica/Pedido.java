package logica;

import java.util.ArrayList;

public class Pedido {
	private int id_pedido;
	private int cant_productos;
	private String estado;
	private String destino;
	private ArrayList<Producto> productos;
	private int id_contenedor;
	private Contenedor contenedor;
	private int id_producto;
	private int id_cliente;
	
	public Pedido(int id_pedido, int cant_productos, String estado, String destino, int id_contenedor,int id_producto) {
		super();
		this.id_pedido = id_pedido;
		this.cant_productos = cant_productos;
		this.estado = estado;
		this.destino = destino;
		this.id_contenedor = id_contenedor;
		this.id_producto = id_producto;
	}
	
	public Pedido() {
		
	}
	
	
	public Pedido(int id_pedido, int cant_productos, String estado, String destino, int id_contenedor, int id_producto, int id_cliente) {
		super();
		this.id_pedido = id_pedido;
		this.cant_productos = cant_productos;
		this.estado = estado;
		this.destino = destino;
		this.id_contenedor = id_contenedor;
		this.setId_producto(id_producto);
		this.id_cliente = id_cliente;
	}
	
	public Pedido(int id_pedido, Contenedor contenedor, String estado) {
		super();
		this.id_pedido = id_pedido;
		this.estado = estado;
		this.destino = destino;
		this.contenedor = contenedor;
		this.productos = new ArrayList<>();
	}

	public int getIdPedido() {
		return id_pedido;
	}
	public void setIdPedido(int id_pedido) {
		this.id_pedido = id_pedido;
	}
	public ArrayList<Producto> getProductos() {
		return productos;
	}
	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public double calcularPeso() {
		double pesoTotal = 0;
		for (Producto producto : productos) {
			pesoTotal += producto.getTamano();
		}
		return pesoTotal;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id_pedido + ", productos=" + productos + ", contenedor=" + id_contenedor + ", estado=" + estado
				+ "]";
	}
	public int getCant_productos() {
		return cant_productos;
	}
	public void setCant_productos(int cant_productos) {
		this.cant_productos = cant_productos;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}


	public int getId_cliente() {
		return id_cliente;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	public int getId_contenedor() {
		return id_contenedor;
	}

	public void setId_contenedor(int id_contenedor) {
		this.id_contenedor = id_contenedor;
	}

	public int getId_producto() {
		return id_producto;
	}

	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}


}
 
