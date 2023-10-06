package interfaz;

import logica.Gerente;

import javax.swing.JOptionPane;

import logica.Contenedor;
import logica.Pedido;

public class PantallaGerente {

	public static void main(String[] args) {
		
		Gerente gerente1 = new Gerente(1, 30445876, "Carlos", "Ramirez");
		 
		//Los contenedores disponibles 
		Contenedor cont1 = new Contenedor(1,1000,"Azul");
		Contenedor cont2 = new Contenedor(2,1500,"Amarillo");
		Contenedor cont3 = new Contenedor (3,2000,"Verde");
		
		// opciones de contenedores 
		
		String [] Opciones = {
				"Asignar contenedor",	
				"",
				"",
				"Salir"
		};
		int op = 0;
		do {
			// seleccion de contenedores
			op= JOptionPane.showOptionDialog(null, "Menu Contenedores", null, 0, 0, null, Opciones, Opciones[0]);
			
			switch (op) {
				case 0:
					String [] opcionContenedores = {
							"Contenedor 1 - Azul",
							"Contenedor 2 - Amarillo",
							"Contenedor 3 - Verde"
						};
					int opC = 0;
					do {
						opC= JOptionPane.showOptionDialog(null, "Menu Contenedores", null, 0, 0, null, opcionContenedores, opcionContenedores[0]);
					
						Contenedor contSeleccionado = null;
						switch (opC) {
							case 0:
								contSeleccionado = cont1;
								break;
							case 1: 
								contSeleccionado = cont2;
								break;
							case 2:
								contSeleccionado = cont3;
							break;
						}
						if (contSeleccionado != null) {
							// el gerente ha seleccioando el contenedor 
							JOptionPane.showMessageDialog(null,"El Gerente " + gerente1.getNombre() + " ha Seleccionado el :\n" +  contSeleccionado);    
						}
					} while (opC!=3);
					break;
				case 1: 
					
					break;
				case 2:
					
					break;
				case 3: 
					JOptionPane.showMessageDialog(null, "Salir");
					break;
				default:
				break;
					
			}
			
			
		} while (op !=3);
		
		
		
				

	}

}
