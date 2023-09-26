package logica;

import javax.swing.JOptionPane;

public class Gerente extends Persona {

	

	public Gerente(int id, int dni, String nombre, String apellido) {
		super(id, dni, nombre, apellido);
		
	}
	
	public Gerente() {
		super();
		
	}
	
	public void hacerPedido() {
		JOptionPane.showMessageDialog(null, "El Gerente " + getNombre() +  " ha hecho un pedido ");
	}
	
	

}
