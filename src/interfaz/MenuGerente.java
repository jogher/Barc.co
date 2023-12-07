package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logica.Barco;
import logica.Contenedor;
import logica.Pedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;

public class MenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tablePedidos;
    private JTextField textCapacidad;
    private JTextField textCapacidadB;
    private JTextField textColor;
    private JTextField textNombre;

    private PantallaGerente interfaz;
    private JTable tableContenedores;
    private JTable tableBarcos;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					MenuGerente frame = new MenuGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public MenuGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(14, 11, 120, 120);
		lblLogo.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/LogoBarc_co1.png")));
		contentPane.add(lblLogo);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setBounds(41, 158, 64, 85);
		lblUsuario.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/usuario-de-perfil.png")));
		contentPane.add(lblUsuario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(909, 11, 89, 23);
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnVolver);
		btnVolver.setVisible(true);
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion inicioSesion=  new InicioSesion();
				inicioSesion.run();
				dispose();
			}
			});
		
		JButton btnVolver1 = new JButton("Volver");
		btnVolver1.setBounds(909, 11, 89, 23);
		btnVolver1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnVolver1);
		btnVolver1.setVisible(true);
		
		btnVolver1.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuGerente menuGerente=  new MenuGerente();
				menuGerente.run();
				dispose();
			}
			});
		
		tablePedidos = new JTable();
		tablePedidos.setBounds(381, 128, 472, 316);
		tablePedidos.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tablePedidos);
		tablePedidos.setDefaultEditor(Object.class, null);
		tablePedidos.setVisible(true);
		
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Cantidad");
		modelo.addColumn("Estado");
		modelo.addColumn("Destino");
		modelo.addColumn("ID Contenedor");
		modelo.addColumn("ID Producto");
		modelo.addColumn("ID Cliente");
		tablePedidos.setModel(modelo);
		
		PantallaGerente interfaz = new PantallaGerente();
		for (Pedido pedido : interfaz.obtenerPedidos()) {
			modelo.addRow(new Object[] {pedido.getIdPedido(), pedido.getCant_productos(), pedido.getEstado(), pedido.getDestino(), pedido.getId_contenedor(),pedido.getId_producto(), pedido.getId_cliente()});
		}
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(858, 128, 17, 316);
		contentPane.add(scrollBar);
		scrollBar.setVisible(true);
		
		JLabel lblPedidos = new JLabel("Pedidos");
		lblPedidos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblPedidos.setBounds(381, 106, 120, 14);
		contentPane.add(lblPedidos);
		lblPedidos.setVisible(true);
		
		JButton btnAdminContenedores = new JButton("Admin Contenedores");
		btnAdminContenedores.setBounds(14, 347, 187, 23);
		btnAdminContenedores.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnAdminContenedores);
		btnAdminContenedores.setVisible(true);
		
		JButton btnAdminBarcos = new JButton("Admin Barcos");
		btnAdminBarcos.setBounds(14, 409, 187, 23);
		btnAdminBarcos.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnAdminBarcos);
		btnAdminBarcos.setVisible(true);
		
		JButton btnActualizarPedido = new JButton("Actualizar");
		btnActualizarPedido.setBounds(649, 464, 187, 23);
		btnActualizarPedido.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnActualizarPedido);
		btnActualizarPedido.setVisible(true);
			
		btnActualizarPedido.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int pedidoSeleccionada = tablePedidos.getSelectedRow(); 

		        if (pedidoSeleccionada >= 0) { 
		            int idPedido = (int) tablePedidos.getValueAt(pedidoSeleccionada, 0); 
		            int nuevaCantidad = (int) tablePedidos.getValueAt(pedidoSeleccionada, 1);
		            String nuevoEstado = (String) tablePedidos.getValueAt(pedidoSeleccionada, 2);
		            String nuevoDestino = (String) tablePedidos.getValueAt(pedidoSeleccionada, 3);
		            int nuevoIdContenedor = (int) tablePedidos.getValueAt(pedidoSeleccionada, 4);
		            int nuevoIdProducto = (int) tablePedidos.getValueAt(pedidoSeleccionada, 5);
		            int nuevoIdCliente = (int) tablePedidos.getValueAt(pedidoSeleccionada, 6);

		           
		            EditarPedido editarPedido = new EditarPedido(idPedido, nuevaCantidad, nuevoEstado, nuevoDestino, nuevoIdContenedor, nuevoIdProducto, nuevoIdCliente);
		            editarPedido.run(idPedido, nuevaCantidad, nuevoEstado, nuevoDestino, nuevoIdContenedor, nuevoIdProducto, nuevoIdCliente);
		            dispose();
		        } else { 
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido para actualizar.");
		        }
		    }
		});

		
		tableContenedores = new JTable();
		tableContenedores.setBounds(381, 86, 472, 213);
		tableContenedores.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tableContenedores);
		tableContenedores.setDefaultEditor(Object.class, null);
		tableContenedores.setVisible(false);
		
		DefaultTableModel  modeloContenedores = new DefaultTableModel();
		modeloContenedores.addColumn("ID Contenedor");
		modeloContenedores.addColumn("Capacidad");
		modeloContenedores.addColumn("Color");
		modeloContenedores.addColumn("ID Barco");

		tableContenedores.setModel(modeloContenedores);
		
		
		for (Contenedor contenedor : interfaz.obtenerContenedores()) {
			modeloContenedores.addRow(new Object[] {contenedor.getId(), contenedor.getCapacidad(), contenedor.getColor(), contenedor.getId_barco()});
		}
		
		JLabel lblContenedores = new JLabel("Contenedores");
		lblContenedores.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblContenedores.setBounds(381, 61, 99, 14);
		contentPane.add(lblContenedores);
		lblContenedores.setVisible(false);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setBounds(649, 319, 187, 23);
		btnEliminar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnEliminar);
		btnEliminar.setVisible(false);
		
		btnEliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int contenedorSeleccionado = tableContenedores.getSelectedRow();
            	
            	if (contenedorSeleccionado != -1) {
            		int id = (int) tableContenedores.getValueAt(contenedorSeleccionado, 0);
    				interfaz.eliminarContenedor(id);
    				
    				modeloContenedores.setRowCount(0);
    				for (Contenedor contenedor : interfaz.obtenerContenedores()) {
    					modeloContenedores.addRow(new Object[] {contenedor.getId(), contenedor.getCapacidad(), contenedor.getColor(), contenedor.getId_barco()});
    				}
            	}
		    }
		});
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.setBounds(405, 319, 187, 23);
		btnActualizar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnActualizar);
		btnActualizar.setVisible(false);
		
		btnActualizar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int contenedorSeleccionado = tableContenedores.getSelectedRow(); 

		        if (contenedorSeleccionado >= 0) { 
		            int id_contenedor = (int) tableContenedores.getValueAt(contenedorSeleccionado, 0);  
		            int capacidad = (int) tableContenedores.getValueAt(contenedorSeleccionado, 1);
		            String color = (String) tableContenedores.getValueAt(contenedorSeleccionado, 2);
		            int id_barco = (int) tableContenedores.getValueAt(contenedorSeleccionado, 3);
   
		            EditarContenedor editarContenedor = new EditarContenedor(id_contenedor, capacidad, color, id_barco);
		            editarContenedor.run(id_contenedor, capacidad, color, id_barco);
		        } else { 
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido para actualizar.");
		        }
		        modeloContenedores.setRowCount(0);
		        for (Contenedor contenedor : interfaz.obtenerContenedores()) {
					modeloContenedores.addRow(new Object[] {contenedor.getId(), contenedor.getCapacidad(), contenedor.getColor(), contenedor.getId_barco()});
				}
		    }
		});
		
		textCapacidad = new JTextField();
		textCapacidad.setColumns(10);
		textCapacidad.setBounds(472, 498, 120, 25);
		contentPane.add(textCapacidad);
		textCapacidad.setVisible(false);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(649, 498, 120, 25);
		contentPane.add(textColor);
		textColor.setVisible(false);
		
		JButton btnAgregarContenedor= new JButton("Agregar");
		btnAgregarContenedor.setBounds(537, 560, 187, 23);
		btnAgregarContenedor.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnAgregarContenedor);
		btnAgregarContenedor.setVisible(false);
		
		btnAgregarContenedor.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int capacidad = Integer.parseInt(textCapacidad.getText());
		    	String color = textColor.getText();
                interfaz.agregarContenedor(capacidad, color);
		    }
		});
		
		JLabel lblAgregarContenedor = new JLabel("Agregar Contenedor");
		lblAgregarContenedor.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblAgregarContenedor.setBounds(381, 455, 140, 14);
		contentPane.add(lblAgregarContenedor);
		lblAgregarContenedor.setVisible(false);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCapacidad.setBounds(497, 480, 77, 14);
		contentPane.add(lblCapacidad);
		lblCapacidad.setVisible(false);
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblColor.setBounds(685, 480, 77, 14);
		contentPane.add(lblColor);
		lblColor.setVisible(false);
		
	
		
		tableBarcos = new JTable();
		tableBarcos.setBounds(381, 86, 472, 213);
		tableBarcos.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPane.add(tableBarcos);
		tableBarcos.setDefaultEditor(Object.class, null);
		tableBarcos.setVisible(false);
		
		DefaultTableModel  modeloBarcos = new DefaultTableModel();
		modeloBarcos.addColumn("ID Barco");
		modeloBarcos.addColumn("Nombre");
		modeloBarcos.addColumn("Capacidad");
		modeloBarcos.addColumn("Destino");

		tableBarcos.setModel(modeloBarcos);
		
		
		for (Barco barco : interfaz.obtenerBarcos()) {
			modeloBarcos.addRow(new Object[] {barco.getId_barco(), barco.getNombre(), barco.getCapacidad(), barco.getDestino()});
		}
		
		JLabel lblBarcos = new JLabel("Barcos");
		lblBarcos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblBarcos.setBounds(381, 61, 99, 14);
		contentPane.add(lblBarcos);
		lblBarcos.setVisible(false);
		
		JButton btnEliminarBarco = new JButton("Eliminar");
		btnEliminarBarco.setBounds(649, 319, 187, 23);
		btnEliminarBarco.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnEliminarBarco);
		btnEliminarBarco.setVisible(false);
		
		btnEliminarBarco.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int barcoSeleccionado = tableBarcos.getSelectedRow();
            	
            	if (barcoSeleccionado != -1) {
            		int id = (int) tableBarcos.getValueAt(barcoSeleccionado, 0);
    				interfaz.eliminarBarco(id);
    				
    				modeloBarcos.setRowCount(0);
    				for (Barco barco : interfaz.obtenerBarcos()) {
    					modeloBarcos.addRow(new Object[] {barco.getId_barco(), barco.getNombre(), barco.getCapacidad(), barco.getDestino()});
    				}
            	}
		    }
		});
		
		JButton btnActualizarBarco = new JButton("Actualizar");
		btnActualizarBarco.setBounds(405, 319, 187, 23);
		btnActualizarBarco.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnActualizarBarco);
		btnActualizarBarco.setVisible(false);
		
		btnActualizarBarco.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	int barcoSeleccionado = tableBarcos.getSelectedRow(); 

		        if (barcoSeleccionado >= 0) { 
		            int id_barco = (int) tableBarcos.getValueAt(barcoSeleccionado, 0);  
		            String nombre = (String) tableBarcos.getValueAt(barcoSeleccionado, 1);
		            int capacidad = (int) tableBarcos.getValueAt(barcoSeleccionado, 2);
		            String destino = (String) tableBarcos.getValueAt(barcoSeleccionado, 3);
   
		            EditarBarco editarbarco = new EditarBarco(id_barco, nombre, capacidad, destino);
		            editarbarco.run(id_barco, nombre, capacidad, destino);
		        } else { 
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido para actualizar.");
		        }
		        modeloBarcos.setRowCount(0);
				for (Barco barco : interfaz.obtenerBarcos()) {
					modeloBarcos.addRow(new Object[] {barco.getId_barco(), barco.getNombre(), barco.getCapacidad(), barco.getDestino()});
				}
		    }
		});
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(472, 498, 120, 25);
		contentPane.add(textNombre);
		textNombre.setVisible(false);
		
		textCapacidadB = new JTextField();
		textCapacidadB.setColumns(10);
		textCapacidadB.setBounds(649, 498, 120, 25);
		contentPane.add(textCapacidadB);
		textCapacidadB.setVisible(false);
		
		JButton btnAgregarBarco= new JButton("Agregar");
		btnAgregarBarco.setBounds(537, 560, 187, 23);
		btnAgregarBarco.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnAgregarBarco);
		btnAgregarBarco.setVisible(false);
		
		btnAgregarBarco.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		    	String nombre = textNombre.getText();
		    	int capacidad = Integer.parseInt(textCapacidadB.getText());
                interfaz.agregarBarco(nombre, capacidad);
                
                modeloBarcos.setRowCount(0);
				for (Barco barco : interfaz.obtenerBarcos()) {
					modeloBarcos.addRow(new Object[] {barco.getId_barco(), barco.getNombre(), barco.getCapacidad(), barco.getDestino()});
				}
		    }
		});
		
		JLabel lblAgregarBarco = new JLabel("Agregar Barco");
		lblAgregarBarco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblAgregarBarco.setBounds(381, 455, 140, 14);
		contentPane.add(lblAgregarBarco);
		lblAgregarBarco.setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblNombre.setBounds(497, 480, 77, 14);
		contentPane.add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblCapacidadBarco = new JLabel("Capacidad");
		lblCapacidadBarco.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblCapacidadBarco.setBounds(685, 480, 77, 14);
		contentPane.add(lblCapacidadBarco);
		lblCapacidadBarco.setVisible(false);
		
		
		btnAdminContenedores.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver.setVisible(false);
				tablePedidos.setVisible(false);
				scrollBar.setVisible(false);
				lblPedidos.setVisible(false);
				btnActualizarPedido.setVisible(false);
				btnAdminContenedores.setVisible(false);
				btnAdminBarcos.setVisible(false);
				tableBarcos.setVisible(false);
				lblBarcos.setVisible(false);
				btnEliminarBarco.setVisible(false);
				btnActualizarBarco.setVisible(false);
				textCapacidadB.setVisible(false);
				textNombre.setVisible(false);
				btnAgregarBarco.setVisible(false);
				lblAgregarBarco.setVisible(false);
				lblNombre.setVisible(false);
				lblCapacidadBarco.setVisible(false);
				
				tableContenedores.setVisible(true);
				lblContenedores.setVisible(true);
				btnEliminar.setVisible(true);
				btnActualizar.setVisible(true);
				textCapacidad.setVisible(true);
				lblCapacidad.setVisible(true);
				textColor.setVisible(true);
				lblColor.setVisible(true);
				btnAgregarContenedor.setVisible(true);
			}
			});
		
		btnAdminBarcos.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnVolver.setVisible(false);
				tablePedidos.setVisible(false);
				scrollBar.setVisible(false);
				lblPedidos.setVisible(false);
				btnActualizarPedido.setVisible(false);
				btnAdminContenedores.setVisible(false);
				btnAdminBarcos.setVisible(false);
				tableContenedores.setVisible(false);
				lblContenedores.setVisible(false);
				btnEliminar.setVisible(false);
				btnActualizar.setVisible(false);
				textCapacidad.setVisible(false);
				lblCapacidad.setVisible(false);
				textColor.setVisible(false);
				lblColor.setVisible(false);
				btnAgregarContenedor.setVisible(false);
				
				tableBarcos.setVisible(true);
				lblBarcos.setVisible(true);
				btnEliminarBarco.setVisible(true);
				btnActualizarBarco.setVisible(true);
				textCapacidadB.setVisible(true);
				textNombre.setVisible(true);
				btnAgregarBarco.setVisible(true);
				lblAgregarBarco.setVisible(true);
				lblNombre.setVisible(true);
				lblCapacidadBarco.setVisible(true);
			}
			});
	}
}
