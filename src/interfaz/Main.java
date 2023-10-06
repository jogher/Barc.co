package interfaz;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import logica.Producto;
import logica.Pedido;
import logica.Gerente;
import logica.Cliente;
import logica.Contenedor;

public class Main {

	public static void main(String[] args) {
		String[] Opciones =
				{
						"Pedidos",
						"Gerente",
						"Proveedor",
						"Salir"
				};
		int  op = 0;
		do {
			op = JOptionPane.showOptionDialog(null, "Menu principal", null, 0, 0, null, Opciones, Opciones[0]);

			switch (op) {
				case 0:
					PantallaPedidos interfazPedido = new PantallaPedidos();
					interfazPedido.Menu();
					
					break;
				case 1:
					
					PantallaGerente interfazGerente = new PantallaGerente ();
					
					Gerente gerente = new Gerente(1,30445876, "Carlos", "Ramiez");
					Contenedor contenedor1 = new Contenedor(1, 1000, "Azul");
					Contenedor contenedor2 = new Contenedor(2, 1500, "Amarillo");
					Contenedor contenedor3 = new Contenedor(3, 5000, "Verde");
				
				JOptionPane.showMessageDialog(null, "Gerente: " + gerente.getNombre());
				String[] opciContenedores = {
						"Contenedor 1 - Azul",
						"Contenedor 2 - Amarillo",
						"Contenedor 3 - Verde"
				};
				int seleccioCon = JOptionPane.showOptionDialog(
                        null,
                        "Seleccione un contenedor",
                        "Selección de Contenedor",
                        0,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        opciContenedores,
                        opciContenedores[0]
                    );
				
				Contenedor contenedorSele = null;
				switch (seleccioCon) {
					case 0:
						contenedorSele = contenedor1;
						break;
					case 1:
						contenedorSele = contenedor2;
						break;
					case 2:
						contenedorSele = contenedor3;
						break;
				}
				
				if(contenedorSele != null) {
					JOptionPane.showMessageDialog(null, contenedorSele);
					gerente.seleccionarContenedor(contenedorSele);
					
				}


					break;
				case 2:
					PantallaProveedor interfazProveedor = new PantallaProveedor();
					interfazProveedor.Menu();
					break;

				case 3:
					// código para salir
					break;

				default:
					break;
			}

		} while (op != 3);

	}

}
