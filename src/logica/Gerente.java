package logica;

import javax.swing.JOptionPane;

public class Gerente extends Persona {

	

	public Gerente(int id, int dni, String nombre, String apellido, String usuario, String contrasena) {
		super(id, dni, nombre, apellido, usuario, contrasena);
		
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
	
	

}
