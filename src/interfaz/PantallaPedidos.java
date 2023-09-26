package interfaz;

import javax.swing.JOptionPane;

import logica.Pedido;

public class PantallaPedidos {

	public void Menu(Pedido pedido) {
		
		String[] Opciones=
			{
					"Realizar pedido","Seguimiento de pedidos","Cancelar pedido","Salir"
			};
		int op=0;
		do {
			op= JOptionPane.showOptionDialog(null, "Menu Pedidos", null, 0, 0, null, Opciones, Opciones[0]);
			switch (op) {
			case 0:
				JOptionPane.showMessageDialog(null, "Realizar pedido \n"
						+ "Se debe ingresar(Productos)");
				break;
			case 1:
				JOptionPane.showMessageDialog(null, "Seguimiento de Pedidos \n"
						+ "Seleccione un pedido");
				break;
			case 2:
				JOptionPane.showMessageDialog(null, "Cancelar Pedido \n"
						+ "Seleccione pedido");
				break;
			case 3:
				JOptionPane.showMessageDialog(null, "Salir");
				break;
			default:
				break;
			}
		} while (op!=3);
	}

}
