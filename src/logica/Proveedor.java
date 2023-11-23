package logica;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import DLL.Conexion;



public class Proveedor extends Persona{
	private String rubro;
	private String ubicacion;
	private ArrayList<Producto> productos;
	
	public Proveedor(int id, String nombre, String rubro, String ubicacion, String telefono, String email, String contrasena) {
		super(id,nombre,telefono,email,contrasena);
		this.rubro = rubro;
		this.ubicacion = ubicacion;
		this.productos = new ArrayList<Producto>();
	}
	
	

	public Proveedor() {
		super();
		
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
	
	
	
	 public ArrayList<Producto> getProductos() {
		    return productos; 
		  }
	 
	 public void addProducto(Producto producto) {
		    getProductos().add(producto);
		    producto.setProveedor(this); 
		  }
	 
	 
	Conexion con = new Conexion();	
	Connection conexion = con.conectar();	
	PreparedStatement stmt;
	 public LinkedList<Proveedor> Mostrar(String email, String contrasena){
			LinkedList<Proveedor> proveedores = new LinkedList<Proveedor>();
			String sql = "SELECT * FROM proveedor WHERE email=? AND contrasena=?";
			String[] datos = new String[7];
			try {
				stmt = conexion.prepareStatement(sql);
				stmt.setString(1, email);
				stmt.setString(2, contrasena);
				ResultSet resultados =	stmt.executeQuery();
				while(resultados.next()) {
					
					datos[0] = resultados.getString(1);
					datos[1] = resultados.getString(2);
					datos[2] = resultados.getString(3);
					datos[3] = resultados.getString(4);
					datos[4] = resultados.getString(5);
					datos[5] = resultados.getString(6);
					datos[6] = resultados.getString(7);
					proveedores.add(new Proveedor(Integer.parseInt(datos[0]),datos[1],datos[2],datos[3],datos[4],datos[5],datos[6]));
				}
				if(proveedores.isEmpty()) {
					
					return null;
				}else {
					
					return proveedores;
				}
			} catch (Exception e) {
				System.out.println("Error");
				return null;
			}
	 }

	@Override
	public String toString() {
		return "Proveedor [rubro=" + rubro + ", ubicacion=" + ubicacion + ", productos=" + productos + ", con=" + con
				+ ", conexion=" + conexion + ", stmt=" + stmt + "]";
	}
}
