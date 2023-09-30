package logica;

public class Contenedor {
	
	private int id;
	private int capacidad;
	private String color;
	private Pedido pedido; // esto para almacenar el pedido en el contenedor 	
	
	public Contenedor(int id, int capacidad, String color) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.color = color;
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
	
	
	
	

}
