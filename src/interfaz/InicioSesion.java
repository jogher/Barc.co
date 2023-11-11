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
	private static String email;
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
			         PantallaGerente interfazGerente = new PantallaGerente();
			         InicioSesion.email = correo;
			         interfazGerente.Menu();
			        } else if (validador.IniciarSesion(correo, contrasena, "cliente")) {
			         Cliente verificador = new Cliente();
			         verificador.Mostrar(correo, contrasena);
			         PantallaCliente interfazCliente = new PantallaCliente();
			         InicioSesion.email = correo;
			         interfazCliente.Menu();
			        } else if (validador.IniciarSesion(correo, contrasena, "proveedor")) {
			          Proveedor verificador = new Proveedor();
			          verificador.Mostrar(correo, contrasena);
			          PantallaProveedor interfazProveedor = new PantallaProveedor();
			          InicioSesion.email = correo;
			          interfazProveedor.Menu();
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
		
		btnRegistrarse.addActionListener (e ->{
			
			VentanaRegistro ventanaRegistro = new VentanaRegistro();
			ventanaRegistro.setVisible(true);
		});
		
		passwordField = new JPasswordField();
		passwordField.setBounds(407, 218, 267, 27);
		contentPane.add(passwordField);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setIcon(new ImageIcon("D:\\DaVinci\\ProgramacionAvanzada\\Barc.co\\LogoBarc_co1.png"));
		lblLogo.setBounds(10, 11, 120, 120);
		contentPane.add(lblLogo);
		
		
	}
}

class VentanaRegistro extends JFrame{
	 private JTextField txtNombre;
	    private JTextField txtApellido;
	    private JTextField txtDni;
	    private JTextField txtTelefono;
	    private JTextField txtCorreoRegistro;
	    private JPasswordField passwordFieldRegistro;
	    private JLabel lblMensajeRegistro;
	    
	    private JComboBox<String> comboTipoUsuario;
	    	
	    
	    public VentanaRegistro() {
	    	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        setBounds(100, 100, 400, 300);
	        getContentPane().setLayout(null);
	        
	        JLabel lblNombre = new JLabel("Nombre:");
	        lblNombre.setBounds(20, 30, 100, 20);
	        getContentPane().add(lblNombre);
	        
	        txtNombre = new JTextField();
	        txtNombre.setBounds(120, 30, 200, 20);
	        getContentPane().add(txtNombre);
	        
	        JLabel lblApellido = new JLabel("Apellido:");
	        lblApellido.setBounds(20, 60, 100, 20);
	        getContentPane().add(lblApellido);
	        
	        txtApellido = new JTextField();
	        txtApellido.setBounds(120, 60, 200, 20);
	        getContentPane().add(txtApellido);
	        
	        JLabel lblDni = new JLabel("DNI:");
	        lblDni.setBounds(20, 90, 100, 20);
	        getContentPane().add(lblDni);
	        
	        txtDni = new JTextField();
	        txtDni.setBounds(120, 90, 200, 20);
	        getContentPane().add(txtDni);

	        JLabel lblTelefono = new JLabel("Teléfono:");
	        lblTelefono.setBounds(20, 120, 100, 20);
	        getContentPane().add(lblTelefono);
	        
	        txtTelefono = new JTextField();
	        txtTelefono.setBounds(120, 120, 200, 20);
	        getContentPane().add(txtTelefono);
	        
	        JLabel lblCorreo = new JLabel("Correo");
	        lblCorreo.setBounds(20, 150, 100, 20);
	        getContentPane().add(lblCorreo);
	        
	        txtCorreoRegistro = new JTextField();
	        txtCorreoRegistro.setBounds(120, 150, 200, 20);
	        getContentPane().add(txtCorreoRegistro);
	        
	        JLabel lblContrasenaRegistro = new JLabel("Contraseña:");
	        lblContrasenaRegistro.setBounds(20, 180, 100, 20);
	        getContentPane().add(lblContrasenaRegistro);
	        
	       
	        
	        passwordFieldRegistro = new JPasswordField();
	        passwordFieldRegistro.setBounds(120, 180, 200, 20);
	        getContentPane().add(passwordFieldRegistro);
	        
	        lblMensajeRegistro = new JLabel("");
	        lblMensajeRegistro.setForeground(Color.RED);
	        lblMensajeRegistro.setBounds(20, 230, 300, 20);
	        getContentPane().add(lblMensajeRegistro);
	        
	        JLabel lblTipoUsuario = new JLabel("Tipo de Usuario:");
	        lblTipoUsuario.setBounds(20, 210, 100, 20);
	        getContentPane().add(lblTipoUsuario);

	        // Agregar opciones al JComboBox para el registro de usuarios
	        String[] opcionesTipoUsuario = {"Cliente", "Proveedor", "Gerente"};
	        comboTipoUsuario = new JComboBox<>(opcionesTipoUsuario);
	        comboTipoUsuario.setBounds(120, 210, 200, 20);
	        getContentPane().add(comboTipoUsuario);


	        
	        JButton btnRegistrar = new JButton("Registrar");
	        btnRegistrar.setBounds(150, 240, 220, 30);
	        getContentPane().add(btnRegistrar);
	        
	      btnRegistrar.addActionListener(e ->{
	    	  registrarUsuario();
	      });

	    }
	    
	    private void registrarUsuario() {
	    	String nombre = txtNombre.getText();
	    	String apellido = txtApellido.getText();
	    	String dni = txtDni.getText();
	    	String telefono = txtTelefono.getText();
	    	String correo = txtCorreoRegistro.getText();
	    	String contrasena = new String(passwordFieldRegistro.getPassword());
	    	String tipoUsuario = (String) comboTipoUsuario.getSelectedItem();
	    	
	    // logica  para registrar el usuario en la base de datos 
	    	
	    	Conexion conexion = new Conexion();
	    	Connection con = conexion.conectar();
	    	
	    	if (con != null) {
	    		
	    		try {
	    			String query; 
	    			
	    	         if ("Cliente".equals(tipoUsuario)) {
	    	        	 query = "INSERT INTO cliente (nombre, apellido, dni, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
	    	         } else if ("Proveedor".equals(tipoUsuario)) {
	    	             query = "INSERT INTO proveedor (nombre, apellido, dni, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
	    	         } else { // "Gerente"
	    	             query = "INSERT INTO gerente (nombre, apellido, dni, telefono, email, contrasena) VALUES (?, ?, ?, ?, ?, ?)";
	    	        }
	    	        
	    			PreparedStatement stmt = con.prepareStatement(query);
	    			stmt.setString(1, nombre);
	                stmt.setString(2, apellido);
	                stmt.setString(3, dni);
	                stmt.setString(4, telefono);
	                stmt.setString(5, correo);
	                stmt.setString(6, contrasena);
	                
	                int datosInsertados = stmt.executeUpdate();
	                if (datosInsertados > 0) {
	                	 lblMensajeRegistro.setText("Nuevo usuario registrado como " + tipoUsuario);
	                	 dispose();
	                } else {
	                	lblMensajeRegistro.setText("No se pudo registrar el usuario");
	                }
	                
	                
	                stmt.close();
	                con.close();
	    		} catch (SQLException ex) {
	    			lblMensajeRegistro.setText("Error de conexión o de base de datos: " + ex.getMessage());
	    			ex.printStackTrace();
	    		}
	    	} else {
	    		 lblMensajeRegistro.setText("Error de conexión a la base de datos");
	        }
	    		
	  }

}

