package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import DLL.Conexion;

import logica.Pedido;
import logica.Producto;
import javax.swing.JTextField;

public class MenuCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableProductos;
	private JTable tableCarrito;
	private JTextField textCantidad;
	private JTextField textDestino;
	private JTable tableSeguimiento;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					MenuCliente frame = new MenuCliente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public MenuCliente() {
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
		
		JLabel lblNombreUsuario = new JLabel("tomaaas");
		lblNombreUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombreUsuario.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNombreUsuario.setBounds(0, 238, 145, 14);
		contentPane.add(lblNombreUsuario);
		
		JButton btnSeguimiento = new JButton("Seguimiento/Cancelacion");
		btnSeguimiento.setToolTipText("");
		btnSeguimiento.setForeground(Color.BLACK);
		btnSeguimiento.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnSeguimiento.setBackground(Color.LIGHT_GRAY);
		btnSeguimiento.setBounds(18, 331, 206, 23);
		contentPane.add(btnSeguimiento);
		
		tableProductos = new JTable();
		tableProductos.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableProductos.setBounds(381, 55, 472, 218);
		contentPane.add(tableProductos);
		tableProductos.setVisible(true);
		
		tableCarrito = new JTable();
		tableCarrito.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableCarrito.setBounds(381, 368, 472, 218);
		contentPane.add(tableCarrito);
		tableCarrito.setVisible(true);
		
		DefaultTableModel  modelo = new DefaultTableModel();
		modelo.addColumn("ID");
		modelo.addColumn("Nombre");
		modelo.addColumn("Precio");
		modelo.addColumn("Stock");
		tableProductos.setModel(modelo);
	
		
		DefaultTableModel  modeloCarrito = new DefaultTableModel();
		modeloCarrito.addColumn("ID");
		modeloCarrito.addColumn("Nombre");
		modeloCarrito.addColumn("Precio");
		modeloCarrito.addColumn("Stock");
		tableCarrito.setModel(modeloCarrito);
		
		JLabel lblProductos = new JLabel("Productos");
		lblProductos.setHorizontalAlignment(SwingConstants.LEFT);
		lblProductos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblProductos.setBounds(384, 31, 111, 23);
		contentPane.add(lblProductos);
		lblProductos.setVisible(true);
		
		JLabel lblCarrito = new JLabel("Carrito");
		lblCarrito.setHorizontalAlignment(SwingConstants.LEFT);
		lblCarrito.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblCarrito.setBounds(384, 343, 111, 23);
		contentPane.add(lblCarrito);
		lblCarrito.setVisible(true);
		
		textCantidad = new JTextField();
		textCantidad.setBounds(458, 284, 111, 20);
		contentPane.add(textCantidad);
		textCantidad.setColumns(10);
		textCantidad.setVisible(true);
		
		JLabel lblNewLabel = new JLabel("Cantidad");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		lblNewLabel.setBounds(391, 287, 70, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(true);
		
		JButton btnAgregarCarrito = new JButton("Agregar a Carrito");
		btnAgregarCarrito.setToolTipText("");
		btnAgregarCarrito.setForeground(Color.BLACK);
		btnAgregarCarrito.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnAgregarCarrito.setBackground(Color.LIGHT_GRAY);
		btnAgregarCarrito.setBounds(626, 283, 145, 23);
		contentPane.add(btnAgregarCarrito);
		btnAgregarCarrito.setVisible(true);
		
		textDestino = new JTextField();
		textDestino.setColumns(10);
		textDestino.setBounds(458, 598, 111, 20);
		contentPane.add(textDestino);
		textDestino.setVisible(true);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 16));
		lblDestino.setBounds(391, 601, 70, 14);
		contentPane.add(lblDestino);
		lblDestino.setVisible(true);
		
		JButton btnRealizarPedido = new JButton("Realizar Pedido");
		btnRealizarPedido.setToolTipText("");
		btnRealizarPedido.setForeground(Color.BLACK);
		btnRealizarPedido.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnRealizarPedido.setBackground(Color.LIGHT_GRAY);
		btnRealizarPedido.setBounds(626, 597, 145, 23);
		contentPane.add(btnRealizarPedido);
		btnRealizarPedido.setVisible(true);
		
		tableSeguimiento = new JTable();
		tableSeguimiento.setBorder(new LineBorder(new Color(0, 0, 0)));
		tableSeguimiento.setBounds(381, 212, 472, 218);
		contentPane.add(tableSeguimiento);
		tableSeguimiento.setVisible(false);
		
		DefaultTableModel  modeloSeguimiento = new DefaultTableModel();
		modeloSeguimiento.addColumn("ID Pedido");
		modeloSeguimiento.addColumn("Cantidad");
		modeloSeguimiento.addColumn("Estado");
		modeloSeguimiento.addColumn("Destino");
		modeloSeguimiento.addColumn("ID Contenedor");
		modeloSeguimiento.addColumn("ID Producto");
		tableSeguimiento.setModel(modeloSeguimiento);
		
		JLabel lblSeguimiento = new JLabel("Pedidos");
		lblSeguimiento.setHorizontalAlignment(SwingConstants.LEFT);
		lblSeguimiento.setFont(new Font("Franklin Gothic Book", Font.BOLD, 20));
		lblSeguimiento.setBounds(384, 178, 111, 23);
		contentPane.add(lblSeguimiento);
		lblSeguimiento.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar Pedido");
		btnCancelar.setToolTipText("");
		btnCancelar.setForeground(Color.BLACK);
		btnCancelar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnCancelar.setBackground(Color.LIGHT_GRAY);
		btnCancelar.setBounds(626, 439, 145, 23);
		contentPane.add(btnCancelar);
		btnCancelar.setVisible(false);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		btnVolver.setBounds(909, 11, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.setVisible(true);
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicioSesion inicioSesion=  new InicioSesion();
				inicioSesion.run();
				dispose();
			}
			});
		
		JButton btnVolver_1 = new JButton("Volver");
		btnVolver_1.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		btnVolver_1.setBounds(909, 11, 89, 23);
		contentPane.add(btnVolver_1);
		btnVolver_1.setVisible(false);
		
		btnVolver_1.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuCliente menuCliente=  new MenuCliente();
				menuCliente.run();
				dispose();
			}
			});
		
		PantallaCliente interfaz = new PantallaCliente();
		for (Producto producto : interfaz.obtenerProductos()) {
			modelo.addRow(new Object[] {producto.getId(),producto.getNombre(),producto.getPrecio(),producto.getStock()});
		}
		tableProductos.setDefaultEditor(Object.class, null);
		
		btnAgregarCarrito.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int productoSeleccionado = tableProductos.getSelectedRow();
				int id = (int) modelo.getValueAt(productoSeleccionado, 0);
				if(productoSeleccionado>=0) {
					int cantidad = Integer.parseInt(textCantidad.getText());
					interfaz.agregarProductosCarrito(interfaz.obtenerProductos(), id, cantidad);
					
					modeloCarrito.setRowCount(0);
					for (Producto producto : interfaz.carrito) {
		                modeloCarrito.addRow(new Object[] {producto.getId(), producto.getNombre(),
		                    producto.getPrecio(), producto.getStock()});
		            }
				}
			}
			
		});
		
		
		for (Producto producto : interfaz.carrito) {
			modeloCarrito.addRow(new Object[] {producto.getId(),producto.getNombre(),producto.getPrecio(),producto.getStock()});
		}
		tableProductos.setDefaultEditor(Object.class, null);
		
		
		btnRealizarPedido.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String destino = textDestino.getText();
                interfaz.realizarPedido(destino);
                modeloCarrito.setRowCount(0);
                
            }
        });
		
		
		
		
		
		
		btnSeguimiento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableProductos.setVisible(false);
				tableCarrito.setVisible(false);
				lblProductos.setVisible(false);
				lblCarrito.setVisible(false);
				textCantidad.setVisible(false);
				lblNewLabel.setVisible(false);
				btnAgregarCarrito.setVisible(false);
				textDestino.setVisible(false);
				lblDestino.setVisible(false);
				btnRealizarPedido.setVisible(false);
				btnVolver.setVisible(false);
				
				tableSeguimiento.setVisible(true);
				lblSeguimiento.setVisible(true);
				btnCancelar.setVisible(true);
				btnVolver_1.setVisible(true);
				
				
				 try{
			   			Conexion conexion = new Conexion(); 
			 			Connection con = (Connection) conexion.conectar();
						    String query = "SELECT * FROM pedido WHERE id_cliente = ?";
						    PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
						    stmt.setInt(1, interfaz.getClientId());
						    ResultSet rs = stmt.executeQuery();
						    
						    while(rs.next()){
						      int idPedido = rs.getInt("id_pedido");
						      int cantidad = rs.getInt("cant_producto");
						      String estado = rs.getString("estado");
						      String destino = rs.getString("destino");
						      int idContenedor = rs.getInt("id_contenedor");
						      int idProducto = rs.getInt("id_producto"); 
						      
						      double precio = interfaz.obtenerPrecioProducto(idProducto);
						      double total = cantidad * precio;
						      
						      modeloSeguimiento.addRow(new Object[] {idPedido,cantidad,estado,destino,idContenedor,total});			    
						    } 
						    tableSeguimiento.setDefaultEditor(Object.class, null);
					  } catch(SQLException a){
							JOptionPane.showMessageDialog(null, "Database error: " + a.getMessage());
							a.printStackTrace(); 
					  }
			}
		});
		
		btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int pedidoSeleccionado = tableSeguimiento.getSelectedRow();
            	
            	if (pedidoSeleccionado != -1) {
            		int id = (int) tableSeguimiento.getValueAt(pedidoSeleccionado, 0);
    				interfaz.cancelarPedido(id);
    				
    				modeloSeguimiento.setRowCount(0);
    				try{
    		   			Conexion conexion = new Conexion(); 
    		 			Connection con = (Connection) conexion.conectar();
    					    String query = "SELECT * FROM pedido WHERE id_cliente = ?";
    					    PreparedStatement stmt = (PreparedStatement) con.prepareStatement(query);
    					    stmt.setInt(1, interfaz.getClientId());
    					    ResultSet rs = stmt.executeQuery();
    					    
    					    while(rs.next()){
    					      int idPedido = rs.getInt("id_pedido");
    					      int cantidad = rs.getInt("cant_producto");
    					      String estado = rs.getString("estado");
    					      String destino = rs.getString("destino");
    					      int idContenedor = rs.getInt("id_contenedor");
    					      int idProducto = rs.getInt("id_producto"); 
    					      
    					      double precio = interfaz.obtenerPrecioProducto(idProducto);
    					      double total = cantidad * precio;
    					      
    					      modeloSeguimiento.addRow(new Object[] {idPedido,cantidad,estado,destino,idContenedor,total});			    
    					    } 
    					    tableSeguimiento.setDefaultEditor(Object.class, null);
    				  } catch(SQLException a){
    						JOptionPane.showMessageDialog(null, "Database error: " + a.getMessage());
    						a.printStackTrace(); 
    				  }
            		
            	} else {
                    JOptionPane.showMessageDialog(null, "Por favor, seleccione un pedido para cancelar.");
            	}
            	
            }
        });
	}
}
