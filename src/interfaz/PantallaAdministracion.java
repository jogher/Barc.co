package interfaz;

import javax.swing.JOptionPane;

public class PantallaAdministracion {
	public void Menu() { 
	
		String[] Opciones=
			{
					"","","Salir"
			};
		int op=0;
		do {
			op= JOptionPane.showOptionDialog(null, "Menu Administracion", null, 0, 0, null, Opciones, Opciones[0]);
			switch (op) {
			case 0:
				
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
		} while (op!=3);
	}
}