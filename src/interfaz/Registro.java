package interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DLL.Conexion;

import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;

public class Registro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textDni;
	private JTextField textTelefono;
	private JTextField textEmail;
	private JTextField textRubro;
	private JTextField textUbicacion;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	
			public void run() {
				try {
					Registro frame = new Registro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

	/**
	 * Create the frame.
	 */
	public Registro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\DaVinci\\ProgramacionAvanzada\\Barc.co\\LogoBarc_co1.png"));
		lblLogo.setBounds(10, 11, 120, 120);
		contentPane.add(lblLogo);
		
		
		textNombre = new JTextField();
		textNombre.setToolTipText("");
		textNombre.setColumns(10);
		textNombre.setBounds(370, 215, 267, 27);
		contentPane.add(textNombre);
		textNombre.setVisible(false);
		
		textApellido = new JTextField();
		textApellido.setToolTipText("");
		textApellido.setColumns(10);
		textApellido.setBounds(370, 268, 267, 27);
		contentPane.add(textApellido);
		textApellido.setVisible(false);
		
		textRubro = new JTextField();
		textRubro.setToolTipText("");
		textRubro.setColumns(10);
		textRubro.setBounds(370, 268, 267, 27);
		contentPane.add(textRubro);
		textRubro.setVisible(false);
		
		textDni = new JTextField();
		textDni.setToolTipText("");
		textDni.setColumns(10);
		textDni.setBounds(370, 321, 267, 27);
		contentPane.add(textDni);
		textDni.setVisible(false);
		
		textUbicacion = new JTextField();
		textUbicacion.setToolTipText("");
		textUbicacion.setColumns(10);
		textUbicacion.setBounds(370, 321, 267, 27);
		contentPane.add(textUbicacion);
		textUbicacion.setVisible(false);
		
		textTelefono = new JTextField();
		textTelefono.setToolTipText("");
		textTelefono.setColumns(10);
		textTelefono.setBounds(370, 375, 267, 27);
		contentPane.add(textTelefono);
		textTelefono.setVisible(false);
		
		textEmail = new JTextField();
		textEmail.setToolTipText("");
		textEmail.setColumns(10);
		textEmail.setBounds(370, 428, 267, 27);
		contentPane.add(textEmail);
		textEmail.setVisible(false);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(370, 482, 267, 27);
		contentPane.add(passwordField);
		passwordField.setVisible(false);
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblTelefono.setBounds(370, 359, 119, 14);
		contentPane.add(lblTelefono);
		lblTelefono.setVisible(false);
		
		JLabel lblDni = new JLabel("Dni");
		lblDni.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblDni.setBounds(370, 306, 119, 14);
		contentPane.add(lblDni);
		lblDni.setVisible(false);
		
		JLabel lblUbicacion = new JLabel("Ubicacion");
		lblUbicacion.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblUbicacion.setBounds(370, 306, 119, 14);
		contentPane.add(lblUbicacion);
		lblUbicacion.setVisible(false);
		
		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblApellido.setBounds(370, 253, 119, 14);
		contentPane.add(lblApellido);
		lblApellido.setVisible(false);
		
		JLabel lblRubro = new JLabel("Rubro");
		lblRubro .setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblRubro .setBounds(370, 253, 119, 14);
		contentPane.add(lblRubro );
		lblRubro .setVisible(false);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblNombre.setBounds(370, 199, 119, 14);
		contentPane.add(lblNombre);
		lblNombre.setVisible(false);
		
		JLabel lblEmail = new JLabel("Correo Electronico");
		lblEmail.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblEmail.setBounds(370, 413, 119, 14);
		contentPane.add(lblEmail);
		lblEmail.setVisible(false);
		
		JLabel lblContrasenia = new JLabel("Contraseña");
		lblContrasenia.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblContrasenia.setBounds(370, 466, 119, 14);
		contentPane.add(lblContrasenia);
		lblContrasenia.setVisible(false);
		
		JButton btnRegistrarse = new JButton("Registrarse");
		btnRegistrarse.setToolTipText("");
		btnRegistrarse.setForeground(Color.BLACK);
		btnRegistrarse.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 13));
		btnRegistrarse.setBackground(Color.LIGHT_GRAY);
		btnRegistrarse.setBounds(450, 544, 108, 23);
		contentPane.add(btnRegistrarse);
		btnRegistrarse.setVisible(false);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"","Gerente", "Cliente", "Proveedor"}));
		comboBox.setBounds(370, 147, 267, 27);
		contentPane.add(comboBox);
		
		JLabel lblMensaje = new JLabel("");
		lblMensaje.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblMensaje.setBounds(321, 595, 366, 14);
		contentPane.add(lblMensaje);
		
		JLabel lblRol = new JLabel("Seleccione el rol");
		lblRol.setFont(new Font("Franklin Gothic Book", Font.PLAIN, 14));
		lblRol.setBounds(370, 130, 188, 14);
		contentPane.add(lblRol);
		
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String seleccion = (String) comboBox.getSelectedItem();
				Conexion conexion = new Conexion();
		    	Connection con = conexion.conectar();
		    	
				switch (seleccion) {
					case "Gerente":
						textNombre.setVisible(true);
						textApellido.setVisible(true);
						textDni.setVisible(true);
						textTelefono.setVisible(true);
						textEmail.setVisible(true);
						passwordField.setVisible(true);
						lblTelefono.setVisible(true);
						lblDni.setVisible(true);
						lblApellido.setVisible(true);
						lblNombre.setVisible(true);
						lblEmail.setVisible(true);
						lblContrasenia.setVisible(true);
						btnRegistrarse.setVisible(true);
						
						
				    	
				    	btnRegistrarse.addActionListener(new ActionListener() {
				    		public void actionPerformed(ActionEvent e) {
				    			try {
				    				String nombre = textNombre.getText();
							    	String apellido = textApellido.getText();
							    	int dni = Integer.parseInt(textDni.getText());
							    	String telefono = textTelefono.getText();
							    	String correo = textEmail.getText();
							    	String contrasena = new String(passwordField.getPassword());
				    				
				    				String query = "INSERT INTO gerente (nombre, apellido, dni, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
					    			PreparedStatement stmt = con.prepareStatement(query);
					    			stmt.setString(1, nombre);
					                stmt.setString(2, apellido);
					                stmt.setInt(3, dni);
					                stmt.setString(4, telefono);
					                stmt.setString(5, correo);
					                stmt.setString(6, contrasena);
					                
					                int datosInsertados = stmt.executeUpdate();
					                if (datosInsertados > 0) {
					                	 lblMensaje.setText("Nuevo usuario registrado como GERENTE");
					                	 dispose();
					                } else {
					                	lblMensaje.setText("No se pudo registrar el usuario");
					                }
					                
					                
					                stmt.close();
					                con.close();
					    		} catch (SQLException ex) {
					    			lblMensaje.setText("Error de conexión o de base de datos: " + ex.getMessage());
					    			ex.printStackTrace();
					    		}
				    		}
				    	});
				    	
						
						
						break;
					case "Cliente":
						textNombre.setVisible(true);
						textApellido.setVisible(true);
						textDni.setVisible(true);
						textTelefono.setVisible(true);
						textEmail.setVisible(true);
						passwordField.setVisible(true);
						lblTelefono.setVisible(true);
						lblDni.setVisible(true);
						lblApellido.setVisible(true);
						lblNombre.setVisible(true);
						lblEmail.setVisible(true);
						lblContrasenia.setVisible(true);
						btnRegistrarse.setVisible(true);
						
						
						
				    	btnRegistrarse.addActionListener(new ActionListener() {
				    		public void actionPerformed(ActionEvent e) {
				    			try {
				    				String nombre = textNombre.getText();
				    				String apellido = textApellido.getText();
							    	int dni = Integer.parseInt(textDni.getText());				    	
							    	String telefono = textTelefono.getText();
							    	String correo = textEmail.getText();
							    	String contrasena = new String(passwordField.getPassword());
				    				
									String query = "INSERT INTO cliente (nombre, apellido, dni, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
					    			PreparedStatement stmt = con.prepareStatement(query);
					    			stmt.setString(1, nombre);
					                stmt.setString(2, apellido);
					                stmt.setInt(3, dni);
					                stmt.setString(4, telefono);
					                stmt.setString(5, correo);
					                stmt.setString(6, contrasena);
					                
					                int datosInsertados = stmt.executeUpdate();
					                if (datosInsertados > 0) {
					                	 lblMensaje.setText("Nuevo usuario registrado como GERENTE");
					                	 dispose();
					                } else {
					                	lblMensaje.setText("No se pudo registrar el usuario");
					                }
					                stmt.close();
					                con.close();
					    		} catch (SQLException ex) {
					    			lblMensaje.setText("Error de conexión o de base de datos: " + ex.getMessage());
					    			ex.printStackTrace();
					    		}						
								
				    		}
				    	});
						break;
					case "Proveedor":
						textNombre.setVisible(true);
						textRubro.setVisible(true);
						textUbicacion.setVisible(true);
						textTelefono.setVisible(true);
						textEmail.setVisible(true);
						passwordField.setVisible(true);
						lblTelefono.setVisible(true);
						lblUbicacion.setVisible(true);
						lblRubro.setVisible(true);
						lblNombre.setVisible(true);
						lblEmail.setVisible(true);
						lblContrasenia.setVisible(true);
						btnRegistrarse.setVisible(true);
						
						
						
				    	btnRegistrarse.addActionListener(new ActionListener() {
				    		public void actionPerformed(ActionEvent e) {
				    			try {
				    				String nombre = textNombre.getText();
							    	String rubro = textRubro.getText();
							    	String ubicacion = textUbicacion.getText();
							    	String telefono = textTelefono.getText();
							    	String correo = textEmail.getText();
							    	String contrasena = new String(passwordField.getPassword());
				    				
									String query = "INSERT INTO proveedor (nombre, rubro, ubicacion, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
					    			PreparedStatement stmt = con.prepareStatement(query);
					    			stmt.setString(1, nombre);
					                stmt.setString(2, rubro);
					                stmt.setString(3, ubicacion);
					                stmt.setString(4, telefono);
					                stmt.setString(5, correo);
					                stmt.setString(6, contrasena);
					                
					                int datosInsertados = stmt.executeUpdate();
					                if (datosInsertados > 0) {
					                	 lblMensaje.setText("Nuevo usuario registrado como GERENTE");
					                	 dispose();
					                } else {
					                	lblMensaje.setText("No se pudo registrar el usuario");
					                }
					                stmt.close();
					                con.close();
					    		} catch (SQLException ex) {
					    			lblMensaje.setText("Error de conexión o de base de datos: " + ex.getMessage());
					    			ex.printStackTrace();
					    		}	
				    		}
				    	});
				    	break;
				}
			}
		});
		
		
	}
}
