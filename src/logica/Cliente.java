package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;

import DLL.Conexion;

public class Cliente extends Persona{

	
	public Cliente(int id, int dni, String nombre, String apellido, String telefono, String email, String contrasena) {
		super(id, dni, nombre, apellido, telefono, email, contrasena);
	}
	
	public Cliente() {
		
	}

	/*Funciones*/
	public void hacerPedido(ArrayList<Producto> productos) {
		ArrayList<Producto> listaProductos = null;
		listaProductos.addAll(productos);
	}
	
	
	Conexion con = new Conexion();	
	Connection conexion = con.conectar();	
	PreparedStatement stmt;
	 public LinkedList<Cliente> Mostrar(String email, String contrasena){
			LinkedList<Cliente> clientes = new LinkedList<Cliente>();
			String sql = "SELECT * FROM cliente WHERE email=? AND contrasena=?";
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
					clientes.add(new Cliente(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),datos[2],datos[3],datos[4],datos[5],datos[6]));
				}
				if(clientes.isEmpty()) {
					
					return null;
				}else {
					
					return clientes;
				}
			} catch (Exception e) {
				System.out.println("Error");
				return null;
			}
	 
	 }
}
