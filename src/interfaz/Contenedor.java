package interfaz;

public class Contenedor {
	
	private int id;
	private int capacidad;
	private String color;
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
	
	
	

}
