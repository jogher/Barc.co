package logica;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ArrayList;


import javax.swing.JOptionPane;

import DLL.Conexion;

public class Gerente extends Persona {


	public Gerente(int id, int dni, String nombre, String apellido, String telefono, String email, String contrasena) {
		super(id, dni, nombre, apellido, telefono, email, contrasena);
		
	}
	
	public Gerente() {
		super();
		
	}
	
	public void crearPedido(Pedido pedido) {
		JOptionPane.showMessageDialog(null, "El Gerente " + getNombre() +  " ha hecho un pedido ");
	}
	
	public void seleccionarContenedor(Contenedor contenedor) {
		JOptionPane.showMessageDialog(null, "El Gerente " + getNombre() + "ha seleccionado el contenidor");
	}
	
	public Pedido crearPedido(int id, Contenedor contenedor, String estado, ArrayList<Producto> productos) {
		Pedido pedido = new Pedido (id, contenedor, estado);
		pedido.setProductos(productos);
		 JOptionPane.showMessageDialog(null, "El Gerente " + getNombre() + " ha creado un pedido en el contenedor " + contenedor);
	        return pedido;
	}
	
	public void agregarPedidoContenedor(Contenedor contenedor, Pedido pedido) {
		contenedor.setPedido(pedido);
		contenedor.agregarProductos(pedido.getProductos());
		 JOptionPane.showMessageDialog(null, "El Gerente " + getNombre() + " ha agregado el pedido al contenedor " + contenedor.getColor());
	}
	
	

	Conexion con = new Conexion();	
	Connection conexion = con.conectar();	
	PreparedStatement stmt;
	 public LinkedList<Gerente> Mostrar(String email, String contrasena){
			LinkedList<Gerente> gerentes = new LinkedList<Gerente>();
			String sql = "SELECT * FROM 'gerente' WHERE 'email'="+email+"AND 'contrasena'="+contrasena;
			String[] datos = new String[7];
			try {
				stmt = conexion.prepareStatement(sql);
				ResultSet resultados =	stmt.executeQuery();
				while(resultados.next()) {
					
					datos[0] = resultados.getString(1);
					datos[1] = resultados.getString(2);
					datos[2] = resultados.getString(3);
					datos[3] = resultados.getString(4);
					datos[4] = resultados.getString(5);
					datos[5] = resultados.getString(6);
					datos[6] = resultados.getString(7);
					gerentes.add(new Gerente(Integer.parseInt(datos[0]),Integer.parseInt(datos[1]),datos[2],datos[3],datos[4],datos[5],datos[6]));
				}
				if(gerentes.isEmpty()) {
					
					return null;
				}else {
					
					return gerentes;
				}
			} catch (Exception e) {
				System.out.println("Error");
				return null;
			}
	 }
}
