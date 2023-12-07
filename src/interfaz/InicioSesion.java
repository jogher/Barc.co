package interfaz;

import java.awt.EventQueue;

import javax.swing.JOptionPane;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

import 	DLL.Conexion;
import logica.Producto;
import logica.Proveedor;
import logica.Usuario;
import logica.MiValidador;
import logica.Validador;
import logica.Pedido;
import logica.Gerente;
import logica.Cliente;
import logica.Contenedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InicioSesion extends JFrame {

	private static final long serialVersionUID = 1L;
	static String email;
	private JPanel contentPane;
	private JTextField txtCorreo;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */

			public void run() {
				try {
					InicioSesion frame = new InicioSesion();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public InicioSesion() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(192, 192, 192));
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCorreo = new JTextField();
		txtCorreo.setToolTipText("");
		txtCorreo.setColumns(10);
		txtCorreo.setBounds(377, 211, 267, 27);
		contentPane.add(txtCorreo);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.setToolTipText("");
		btnIngresar.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnIngresar.setForeground(new Color(0, 0, 0));
		btnIngresar.setBackground(new Color(192, 192, 192));
		btnIngresar.setBounds(462, 352, 89, 23);
		contentPane.add(btnIngresar);
		
		btnIngresar.addActionListener(e -> { 
			Validador validador = new MiValidador();
						
			
			String correo = txtCorreo.getText();
			String contrasena = new String(passwordField.getPassword());
			
			Conexion conexion = new Conexion();
			Connection con = conexion.conectar();
			
			 if (con != null) {
			        // Utilizar la conexión para autenticar al usuario
			     if (validador.IniciarSesion(correo, contrasena, "gerente")) {
			         Gerente verificador = new Gerente();
			         verificador.Mostrar(correo, contrasena);
			         MenuGerente menuGerente = new MenuGerente();
			         InicioSesion.email = correo;
			         menuGerente.run();
			         dispose(); 
			        } else if (validador.IniciarSesion(correo, contrasena, "cliente")) {
			         Cliente verificador = new Cliente();
			         verificador.Mostrar(correo, contrasena);
			         MenuCliente menucliente = new MenuCliente();
			         InicioSesion.email = correo;
			         menucliente.run();
			         dispose(); 
			        } else if (validador.IniciarSesion(correo, contrasena, "proveedor")) {
			          Proveedor verificador = new Proveedor();
			          verificador.Mostrar(correo, contrasena);
			          PantallaProveedor pantallaProveedor = new PantallaProveedor();
			          InicioSesion.email = correo;
			          pantallaProveedor.Menu();
				      //MenuProveedor menuproveedor = new MenuProveedor();
				      
				      //menuproveedor.run();
				      dispose(); 
			        } else {
			        	JLabel mensajeError = new JLabel("Email o Contrasena incorrecto. No se pudo iniciar sesion");
			        	mensajeError.setForeground(Color.RED);	
			        	mensajeError.setBounds(407,320,400,20);
			        	contentPane.add(mensajeError);
			        	
			        	
			            /*JOptionPane.showMessageDialog(null, "Email o Contraseña incorrecto \nNo se pudo iniciar la sesión");*/
			        }
			    } else {
			    	 JLabel mensajeErrorConexion = new JLabel("Error de conexión a la base de datos");
			         mensajeErrorConexion.setForeground(Color.RED);
			         mensajeErrorConexion.setBounds(407, 320, 400, 20);
			         contentPane.add(mensajeErrorConexion);
			       /* JOptionPane.showMessageDialog(null, "Error de conexión a la base de datos");*/
			    }
			
			
		});
		
		JLabel lblEmail = new JLabel("Correo Electronico");
		lblEmail.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblEmail.setBounds(377, 186, 119, 14);
		contentPane.add(lblEmail);
		
		JLabel lblContrasena = new JLabel("Contraseña");
		lblContrasena.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblContrasena.setBounds(377, 269, 89, 14);
		contentPane.add(lblContrasena);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 151));
		separator.setBackground(new Color(255, 255, 255));
		separator.setBounds(390, 416, 235, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel = new JLabel("¿No estas registrado? Registrate ahora.");
		lblNewLabel.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 11));
		lblNewLabel.setBounds(357, 444, 194, 14);
		contentPane.add(lblNewLabel);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Registro registro = new Registro();
				registro.run();
				dispose();
				
			}
		});
		btnRegistrarse.setBounds(555, 444, 89, 14);
		contentPane.add(btnRegistrarse);
		
		
		passwordField = new JPasswordField();
		passwordField.setBounds(377, 294, 267, 27);
		contentPane.add(passwordField);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon(InicioSesion.class.getResource("/img/LogoBarc_co1.png")));
		lblLogo.setBounds(10, 11, 120, 120);
		contentPane.add(lblLogo);
		
		
	}

}