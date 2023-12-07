package logica;

public class Barco {
	private int id_barco;
	private String nombre;
	private int capacidad;
	private String destino;
	
	
	public int getId_barco() {
		return id_barco;
	}
	public void setId_barco(int id_barco) {
		this.id_barco = id_barco;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	
	public Barco(int id_barco, String nombre, int capacidad, String destino) {
		this.id_barco = id_barco;
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.destino = destino;
	}
	
}
