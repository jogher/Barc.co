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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class EditarPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdPedido;
	private JTextField textCantProductos;
	private JTextField textEstado;
	private JTextField textDestino;
	private JTextField textIdContenedor;
	private JTextField textIdProducto;
	private JTextField textIdCliente;
	/**
	 * Launch the application.
	 */
	
			public void run(int idPedido, int nuevaCantidad, String nuevoEstado, String nuevoDestino, int nuevoIdContenedor, int nuevoIdProducto, int nuevoIdCliente) {
				try {
					EditarPedido frame = new EditarPedido(idPedido, nuevaCantidad, nuevoEstado, nuevoDestino, nuevoIdContenedor, nuevoIdProducto, nuevoIdCliente);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public EditarPedido(int idPedido, int nuevaCantidad, String nuevoEstado, String nuevoDestino, int nuevoIdContenedor, int nuevoIdProducto, int nuevoIdCliente) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(10, 11, 120, 120);
		lblLogo.setIcon(new ImageIcon(MenuCliente.class.getResource("/img/LogoBarc_co1.png")));
		contentPane.add(lblLogo);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(899, 22, 88, 25);
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnVolver);
		btnVolver.setVisible(true);
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
		
		JLabel lblIdPedido = new JLabel("ID Pedido");
		lblIdPedido.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdPedido.setBounds(377, 62, 134, 14);
		contentPane.add(lblIdPedido);
		
		textIdPedido = new JTextField();
		textIdPedido.setBounds(377, 87, 262, 25);
		contentPane.add(textIdPedido);
		textIdPedido.setColumns(10);
		textIdPedido.setText(Integer.toString(idPedido));
		
		JLabel lblCantidadDeProductos = new JLabel("Cantidad de Productos");
		lblCantidadDeProductos.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblCantidadDeProductos.setBounds(377, 135, 200, 14);
		contentPane.add(lblCantidadDeProductos);
		
		textCantProductos = new JTextField();
		textCantProductos.setText((String) null);
		textCantProductos.setColumns(10);
		textCantProductos.setBounds(377, 160, 262, 25);
		contentPane.add(textCantProductos);
		textCantProductos.setText(Integer.toString(nuevaCantidad));
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblEstado.setBounds(377, 206, 134, 14);
		contentPane.add(lblEstado);
		
		textEstado = new JTextField();
		textEstado.setText((String) null);
		textEstado.setColumns(10);
		textEstado.setBounds(377, 231, 262, 25);
		contentPane.add(textEstado);
		textEstado.setText(nuevoEstado);
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblDestino.setBounds(377, 279, 134, 14);
		contentPane.add(lblDestino);
		
		textDestino = new JTextField();
		textDestino.setText((String) null);
		textDestino.setColumns(10);
		textDestino.setBounds(377, 304, 262, 25);
		contentPane.add(textDestino);
		textDestino.setText(nuevoDestino);
		
		JLabel lblIdContenedor = new JLabel("ID Contenedor");
		lblIdContenedor.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdContenedor.setBounds(377, 351, 134, 14);
		contentPane.add(lblIdContenedor);
		
		textIdContenedor = new JTextField();
		textIdContenedor.setText((String) null);
		textIdContenedor.setColumns(10);
		textIdContenedor.setBounds(377, 376, 262, 25);
		contentPane.add(textIdContenedor);
		textIdContenedor.setText(Integer.toString(nuevoIdContenedor));
		
		JLabel lblIdProducto = new JLabel("ID Producto");
		lblIdProducto.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdProducto.setBounds(377, 423, 134, 14);
		contentPane.add(lblIdProducto);
		
		textIdProducto = new JTextField();
		textIdProducto.setText((String) null);
		textIdProducto.setColumns(10);
		textIdProducto.setBounds(377, 448, 262, 25);
		contentPane.add(textIdProducto);
		textIdProducto.setText(Integer.toString(nuevoIdProducto));
		
		JLabel lblIdCliente = new JLabel("ID Cliente");
		lblIdCliente.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdCliente.setBounds(377, 501, 134, 14);
		contentPane.add(lblIdCliente);
		
		textIdCliente = new JTextField();
		textIdCliente.setText((String) null);
		textIdCliente.setColumns(10);
		textIdCliente.setBounds(377, 526, 262, 25);
		contentPane.add(textIdCliente);
		textIdCliente.setText(Integer.toString(nuevoIdCliente));
		
		JButton btnConfirmarActualizacion = new JButton("Confirmar Actualizacion");
		btnConfirmarActualizacion.setBounds(456, 562, 184, 25);
		btnConfirmarActualizacion.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnConfirmarActualizacion);
		btnConfirmarActualizacion.setVisible(true);
		
		btnConfirmarActualizacion.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGerente interfaz = new PantallaGerente();
				int id_pedido = Integer.parseInt(textIdPedido.getText());
				int cantidad = Integer.parseInt(textCantProductos.getText());
				String estado = textEstado.getText();
				String destino = textDestino.getText();
				int id_contenedor = Integer.parseInt(textIdContenedor.getText());
				int id_producto = Integer.parseInt(textIdProducto.getText());
				int id_cliente = Integer.parseInt(textIdCliente.getText());
				interfaz.actualizarPedido(id_pedido,cantidad,estado,destino,id_contenedor,id_producto,id_cliente);
				dispose();
			}
			});
	}

}
