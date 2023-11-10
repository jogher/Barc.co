package interfaz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1101, 572);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(407, 135, 267, 27);
		contentPane.add(txtCorreo);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setToolTipText("");
		btnIngresar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setBackground(new Color(192, 192, 192));
		btnIngresar.setBounds(492, 276, 89, 23);
		contentPane.add(btnIngresar);
		
		JLabel lblEmail = new JLabel("Correo Electronico");
		lblEmail.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblEmail.setBounds(407, 110, 119, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblContrasena.setBounds(407, 193, 89, 14);
		contentPane.add(lblContrasena);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 151));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(420, 340, 235, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("¿No estas registrado? Registrate ahora.");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
		lblNewLabel.setBounds(387, 368, 194, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setBounds(585, 368, 89, 14);
		contentPane.add(btnRegistrarse);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(407, 218, 267, 27);
		contentPane.add(passwordField);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\DaVinci\\ProgramacionAvanzada\\Barc.co\\LogoBarc_co1.png"));
		lblLogo.setBounds(10, 11, 120, 120);
		contentPane.add(lblLogo);
		
		
	}
}
