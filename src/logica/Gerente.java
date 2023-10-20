package logica;

import java.util.ArrayList;
import java.util.ArrayList;


import javax.swing.JOptionPane;

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
	
	

}
