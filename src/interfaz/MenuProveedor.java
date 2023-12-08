package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import logica.Producto;

import javax.swing.JSeparator;

public class MenuProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProductos;
	private JTextField textStock;
	private JTextField textField;
	private JTextField textTamanio;
	private JTextField textPrecio;
	private JTextField textStock_1;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					MenuProveedor frame = new MenuProveedor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public MenuProveedor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/LogoBarc_co1.png")));
		lblLogo.setBounds(14, 11, 120, 120);
		contentPane.add(lblLogo);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/usuario-de-perfil.png")));
		lblUsuario.setBounds(41, 158, 64, 85);
		contentPane.add(lblUsuario);
		
		JLabel lblNombreUsuario = new JLabel("");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNombreUsuario.setBounds(0, 238, 145, 14);
		contentPane.add(lblNombreUsuario);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		btnVolver.setBounds(909, 11, 89, 23);
		contentPane.add(btnVolver);
		
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion inicioSesion=  new InicioSesion();
				inicioSesion.run();
				dispose();
			}
			});
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblProductos.setBounds(302, 49, 111, 23);
		contentPane.add(lblProductos);
		
		tableProductos = new JTable();
		tableProductos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableProductos.setBounds(291, 83, 472, 285);
		contentPane.add(tableProductos);
		
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Tamaño");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		tableProductos.setModel(modelo);
		
		PantallaProveedor interfaz = new PantallaProveedor();
		for (Producto producto : interfaz.obtenerProductosProv()) {
			modelo.addRow(new Object[] {producto.getId(),producto.getNombre(),producto.getTamano(),producto.getPrecio(),producto.getStock()});
		}
		tableProductos.setDefaultEditor(Object.class, null);
		
		textStock = new JTextField();
		textStock.setBounds(317, 404, 111, 20);
		contentPane.add(textStock);
		textStock.setColumns(10);
		
		
		JLabel lblStock = new JLabel("Stock");
		lblStock.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		lblStock.setBounds(337, 379, 70, 14);
		contentPane.add(lblStock);
		
		
		JButton btnAgregarStock = new JButton("Agregar Stock");
		btnAgregarStock.setToolTipText("");
		btnAgregarStock.setForeground(Color.BLACK);
		btnAgregarStock.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnAgregarStock.setBackground(Color.LIGHT_GRAY);
		btnAgregarStock.setBounds(300, 435, 145, 23);
		contentPane.add(btnAgregarStock);
		
		btnAgregarStock.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int productoSeleccionado = tableProductos.getSelectedRow();
		        if (productoSeleccionado != -1 && !textStock.getText().isEmpty()) {
		            int id_producto = (int) modelo.getValueAt(productoSeleccionado, 0);
		            int stockAgregado = Integer.parseInt(textStock.getText());
		            interfaz.agregarStock(id_producto, stockAgregado);

		            modelo.setRowCount(0);
		            for (Producto producto : interfaz.obtenerProductosProv()) {
		                modelo.addRow(new Object[] { producto.getId(), producto.getNombre(), producto.getTamano(),
		                        producto.getPrecio(), producto.getStock() });
		            }
		            tableProductos.setDefaultEditor(Object.class, null);
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto y agregue la cantidad de stock.");
		        }
		    }
		});

		
		JSeparator separator = new JSeparator();
		separator.setBounds(306, 502, 443, 2);
		contentPane.add(separator);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.setToolTipText("");
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnEliminar.setBackground(Color.LIGHT_GRAY);
		btnEliminar.setBounds(603, 414, 145, 23);
		contentPane.add(btnEliminar);
		
		btnEliminar.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        int productoSeleccionado = tableProductos.getSelectedRow();
		        if (productoSeleccionado != -1) {
		            int id_producto = (int) modelo.getValueAt(productoSeleccionado, 0);
		            interfaz.eliminarProducto(id_producto);

		            modelo.setRowCount(0);
		            for (Producto producto : interfaz.obtenerProductosProv()) {
		                modelo.addRow(new Object[] { producto.getId(), producto.getNombre(), producto.getTamano(),
		                        producto.getPrecio(), producto.getStock() });
		            }
		            tableProductos.setDefaultEditor(Object.class, null);
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, seleccione un producto para eliminar.");
		        }
		    }
		});

		
		JLabel lblNuevoProducto = new JLabel("Nuevo Producto");
		lblNuevoProducto.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoProducto.setFont(new Font("Franklin Gothic Book", Font.BOLD, 16));
		lblNuevoProducto.setBounds(467, 515, 120, 14);
		contentPane.add(lblNuevoProducto);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblNombre.setBounds(311, 540, 70, 14);
		contentPane.add(lblNombre);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(291, 565, 111, 20);
		contentPane.add(textField);
		
		JLabel lblTamao = new JLabel("Tamaño");
		lblTamao.setHorizontalAlignment(SwingConstants.CENTER);
		lblTamao.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblTamao.setBounds(432, 540, 70, 14);
		contentPane.add(lblTamao);
		
		textTamanio = new JTextField();
		textTamanio.setColumns(10);
		textTamanio.setBounds(412, 565, 111, 20);
		contentPane.add(textTamanio);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrecio.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblPrecio.setBounds(558, 540, 70, 14);
		contentPane.add(lblPrecio);
		
		textPrecio = new JTextField();
		textPrecio.setColumns(10);
		textPrecio.setBounds(538, 565, 111, 20);
		contentPane.add(textPrecio);
		
		JLabel lblStock_1 = new JLabel("Stock");
		lblStock_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStock_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblStock_1.setBounds(679, 540, 70, 14);
		contentPane.add(lblStock_1);
		
		textStock_1 = new JTextField();
		textStock_1.setColumns(10);
		textStock_1.setBounds(659, 565, 111, 20);
		contentPane.add(textStock_1);
		
		JButton btnAgregarProducto = new JButton("Agregar Producto");
		btnAgregarProducto.setToolTipText("");
		btnAgregarProducto.setForeground(Color.BLACK);
		btnAgregarProducto.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnAgregarProducto.setBackground(Color.LIGHT_GRAY);
		btnAgregarProducto.setBounds(461, 609, 145, 23);
		contentPane.add(btnAgregarProducto);
		
		btnAgregarProducto.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        if (!textField.getText().isEmpty() && !textTamanio.getText().isEmpty() && !textPrecio.getText().isEmpty()
		                && !textStock_1.getText().isEmpty()) {
		            String nombre = textField.getText();
		            double tamanio = Double.parseDouble(textTamanio.getText());
		            double precio = Double.parseDouble(textPrecio.getText());
		            int stock = Integer.parseInt(textStock_1.getText());

		            interfaz.agregarProducto(nombre, tamanio, precio, stock);
		            modelo.setRowCount(0);
		            for (Producto producto : interfaz.obtenerProductosProv()) {
		                modelo.addRow(new Object[] { producto.getId(), producto.getNombre(), producto.getTamano(),
		                        producto.getPrecio(), producto.getStock() });
		            }
		            tableProductos.setDefaultEditor(Object.class, null);
		        } else {
		            JOptionPane.showMessageDialog(null, "Por favor, complete todos los campos para agregar un producto.");
		        }
		    }
		});
	}
}
