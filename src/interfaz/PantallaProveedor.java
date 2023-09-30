package interfaz;

import javax.swing.JOptionPane;
import logica.Proveedor;

public class PantallaProveedor {
	
	public void Menu() {
		/*Opciones del menu*/
		String [] Opciones={"Agregar stock","Nuevo Producto", "Eliminar Producto","Salir"};
		int op = 0;
		do {
			/*Muestro por pantalla las opciones*/
			op = JOptionPane.showOptionDialog(null, "Menu", null, 0, 0, null, Opciones, Opciones[0]);
			/*Dependiendo de la opcion, pido el ingresop de datos y uso la funcion indicada*/
			switch (op) {
			case 0:
				int id;
				int stock;
				id = Integer.parseInt(JOptionPane.showInputDialog("Ingrese id del producto:"));
				stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese cantidad de productos que agrega al stock:"));
				
				/*Metodo de proveedor*/
				break;
			case 1:
				JOptionPane.showInputDialog("Ingrese el nuevo producto:");
				/*Metodo de proveedor*/
				break;
			case 2:
				JOptionPane.showInputDialog("Ingrese id del producto que desea eliminar: ");
				/*Metodo de proveedor*/
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (op != 3);
	}
}
