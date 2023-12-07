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

public class EditarBarco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private JTextField textIdBarco;
	private JTextField textNombre;
	private JTextField textCapacidad;
	private JTextField textDestino;
	/**
	 * Launch the application.
	 */

			public void run(int id_barco, String nombre, int capacidad, String destino) {
				try {
					EditarBarco frame = new EditarBarco(id_barco, nombre, capacidad, destino);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public EditarBarco(int id_barco, String nombre, int capacidad, String destino) {
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
		btnVolver.setBounds(876, 22, 111, 25);
		btnVolver.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnVolver);
		btnVolver.setVisible(true);
		
		btnVolver.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			});
		
		JLabel lblIdBarco = new JLabel("ID Barco");
		lblIdBarco.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblIdBarco.setBounds(378, 149, 134, 14);
		contentPane.add(lblIdBarco);
		
		textIdBarco = new JTextField();
		textIdBarco.setBounds(378, 174, 262, 25);
		contentPane.add(textIdBarco);
		textIdBarco.setColumns(10);
		textIdBarco.setText(Integer.toString(id_barco));
		
		JLabel lblNombre = new JLabel("nombre");
		lblNombre.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblNombre.setBounds(378, 224, 134, 14);
		contentPane.add(lblNombre);
		
		textNombre = new JTextField();
		textNombre.setColumns(10);
		textNombre.setBounds(378, 249, 262, 25);
		contentPane.add(textNombre);
		textNombre.setText(nombre);
		
		JLabel lblCapacidad = new JLabel("Capacidad");
		lblCapacidad.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblCapacidad.setBounds(378, 301, 134, 14);
		contentPane.add(lblCapacidad);
		
		textCapacidad = new JTextField();
		textCapacidad.setColumns(10);
		textCapacidad.setBounds(378, 326, 262, 25);
		contentPane.add(textCapacidad);
		textCapacidad.setText(Integer.toString(capacidad));
		
		JLabel lblDestino = new JLabel("Destino");
		lblDestino.setFont(new Font("Franklin Gothic Book", Font.BOLD, 14));
		lblDestino.setBounds(378, 381, 134, 14);
		contentPane.add(lblDestino);
		
		textDestino = new JTextField();
		textDestino.setColumns(10);
		textDestino.setBounds(378, 406, 262, 25);
		contentPane.add(textDestino);
		textDestino.setText(destino);
		
		
		JButton btnConfirmarActualizacion = new JButton("Confirmar Actualizacion");
		btnConfirmarActualizacion.setBounds(456, 471, 184, 25);
		btnConfirmarActualizacion.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		contentPane.add(btnConfirmarActualizacion);
		btnConfirmarActualizacion.setVisible(true);
		
		btnConfirmarActualizacion.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PantallaGerente interfaz = new PantallaGerente();
				int id_barco = Integer.parseInt(textIdBarco.getText());
				String nombre = textNombre.getText();
				int capacidad = Integer.parseInt(textCapacidad.getText());
				String destino = textDestino.getText();			
				interfaz.actualizarBarco(id_barco, nombre, capacidad, destino);
				
				dispose();
			}
			});
	}

}
