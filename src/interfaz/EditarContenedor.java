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
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;

public class EditarContenedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textIdContenedor;
	private JTextField textCapacidad;
	private JTextField textColor;
	private JTextField textIdBarco;

	/**
	 * Launch the application.
	 */

			public void run(int id_contenedor, int capacidad, String color, int id_barco) {
				try {
					EditarContenedor frame = new EditarContenedor(id_contenedor, capacidad, color, id_barco);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}


	/**
	 * Create the frame.
	 */
	public EditarContenedor(int id_contenedor, int capacidad, String color, int id_barco) {
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
		btnVolver.setBounds(918, 22, 69, 25);
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnVolver);
		btnVolver.setVisible(true);
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
		
		JLabel lblIdContenedor = new JLabel("ID Contenedor");
		lblIdContenedor.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdContenedor.setBounds(378, 149, 134, 14);
		contentPane.add(lblIdContenedor);
		
		textIdContenedor = new JTextField();
		textIdContenedor.setBounds(378, 174, 262, 25);
		contentPane.add(textIdContenedor);
		textIdContenedor.setColumns(10);
		textIdContenedor.setText(Integer.toString(id_contenedor));
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblCapacidad.setBounds(378, 224, 134, 14);
		contentPane.add(lblCapacidad);
		
		textCapacidad = new JTextField();
		textCapacidad.setColumns(10);
		textCapacidad.setBounds(378, 249, 262, 25);
		contentPane.add(textCapacidad);
		textCapacidad.setText(Integer.toString(capacidad));
		
		JLabel lblColor = new JLabel("Color");
		lblColor.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblColor.setBounds(378, 301, 134, 14);
		contentPane.add(lblColor);
		
		textColor = new JTextField();
		textColor.setColumns(10);
		textColor.setBounds(378, 326, 262, 25);
		contentPane.add(textColor);
		textColor.setText(color);
		
		JLabel lblIdBarco = new JLabel("ID Barco");
		lblIdBarco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdBarco.setBounds(378, 381, 134, 14);
		contentPane.add(lblIdBarco);
		
		textIdBarco = new JTextField();
		textIdBarco.setColumns(10);
		textIdBarco.setBounds(378, 406, 262, 25);
		contentPane.add(textIdBarco);
		textIdBarco.setText(Integer.toString(id_barco));
		
		JButton btnConfirmarActualizacion = new JButton("Confirmar Actualizacion");
		btnConfirmarActualizacion.setBounds(456, 471, 184, 25);
		btnConfirmarActualizacion.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnConfirmarActualizacion);
		btnConfirmarActualizacion.setVisible(true);
		
		btnConfirmarActualizacion.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGerente interfaz = new PantallaGerente();
				int id_contenedor = Integer.parseInt(textIdContenedor.getText());
				int capacidad = Integer.parseInt(textCapacidad.getText());
				String color = textColor.getText();
				int id_barco = Integer.parseInt(textIdBarco.getText());			
				interfaz.actualizarContenedor(id_contenedor, capacidad, color, id_barco);
				dispose();
			}
			});
		
	}
}
