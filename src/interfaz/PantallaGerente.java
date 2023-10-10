package interfaz;

import logica.Gerente;
import logica.Producto;
import java.util.ArrayList;
import logica.Proveedor;
import logica.Contenedor;

import javax.swing.JOptionPane;


import logica.Pedido;

public class PantallaGerente {


	public static void main(String[] args) {
		


		Gerente gerente1 = new Gerente(1, 30445876, "Carlos", "Ramirez", null, null);
		 

	
		    
		    // Resto de tu lógica para la pantalla del gerente...
	
			 
		//Los contenedores disponibles 
		Contenedor cont1 = new Contenedor(1,1000,"Azul");
		Contenedor cont2 = new Contenedor(2,1500,"Amarillo");
		Contenedor cont3 = new Contenedor (3,2000,"Verde");
		
		// opciones de contenedores 
		
		String [] Opciones = {
				"Asignar contenedor",
				"Salir"
		};
		
		ArrayList<Producto> productosPedido = obtenerProductosParaPedido();
		
		Pedido pedidoNuevo = gerente1.crearPedido(1, null, "En proceso", productosPedido);
			
		int op = 0;
		do {
			// seleccion de contenedores
			op= JOptionPane.showOptionDialog(null, "Menu Contenedores", null, 0, 0, null, Opciones, Opciones[0]);
			
			switch (op) {
				case 0:
					String [] opcionContenedores = {
							"Contenedor 1 - Azul" + " Capacidad: " + cont1.getCapacidad(),
							"Contenedor 2 - Amarillo" + " Capacidad: " + cont2.getCapacidad(),
							"Contenedor 3 - Verde" + " Capacidad: " + cont3.getCapacidad(),
							"Salir"
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
							case 3:
								
							break;
							
						}
						
						if (contSeleccionado != null) {
							// el gerente ha seleccioando el contenedor 
							 gerente1.agregarPedidoContenedor(contSeleccionado, pedidoNuevo);
							JOptionPane.showMessageDialog(null,"El Gerente " + gerente1.getNombre() + " ha Seleccionado el :\n" +  contSeleccionado);    
						} else {
							JOptionPane.showMessageDialog(null, "El Gerente " + gerente1.getNombre() + " no ha seleccionado ningún contenedor. El pedido no se ha agregado.");
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
	 private static ArrayList<Producto> obtenerProductosParaPedido() {
	        ArrayList<Producto> productos = new ArrayList<>();
	        // Lógica para obtener productos
	        // Ejemplo:
	        int id = 1; // 
	        String nombre = "leche"; 
	        double tamano = 10.5; 
	        double precio = 25.99; 
	        int stock = 100; 
	        Proveedor proveedor = new Proveedor(1, "Jorge", "Alimentos", "Islas Malvinas", "1157302364", "jorgenew.@gmail.com"); 
	        productos.add(new Producto(id, nombre, tamano, precio, stock, proveedor));
	        return productos;
	    }
	 
	 private static Contenedor obtenerContenedor(int opcion, Contenedor cont1, Contenedor cont2, Contenedor cont3) {
	        switch (opcion) {
	            case 0:
	                return cont1;
	            case 1:
	                return cont2;
	            case 2:
	                return cont3;
	            default:
	                return null;
	        }
	        
	    }

} 
