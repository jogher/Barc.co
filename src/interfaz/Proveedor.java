package interfaz;

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
	
	
	
	

	

}
