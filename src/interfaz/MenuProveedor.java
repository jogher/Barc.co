package interfaz;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

import DLL.Conexion;
import logica.Barco;
import logica.Contenedor;
import logica.Pedido;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JSeparator;


public class MenuProveedor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTable tableProducto;
    private JTextField textCapacidad;
    private JTextField textCapacidadB;
    private JTextField textColor;
    private JTextField textNombre;
    private int idProveedor;
    private JTextField textFieldID;  
    private PantallaProveedor interfaz;
    private JTextField textFieldEliminarID;
    private DefaultTableModel modeloTabla;
   // private JTable table;
   // private JTable table;
    
    
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
		
		interfaz = new PantallaProveedor();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		 tableProducto = new JTable();
		 tableProducto.setBounds(214, 40, 766, 500);
		 
		 modeloTabla = new DefaultTableModel();
		 modeloTabla.addColumn("ID");
		 modeloTabla.addColumn("Nombre");
		 modeloTabla.addColumn("Tamaño");
		 modeloTabla.addColumn("Precio");
		 modeloTabla.addColumn("Stock");
		 tableProducto.setModel(modeloTabla);
		 
		
		 contentPane.add(tableProducto);
		 tableProducto.setModel(modeloTabla);


		
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
				MenuProveedor menuProveedor=  new MenuProveedor();
				menuProveedor.run();
				dispose();
			}
			});
		 
	       

	       	JButton btnAgregarStock = new JButton("Agregar Stock");
	        btnAgregarStock.setBounds(14, 347, 187, 23);
	        contentPane.add(btnAgregarStock);
	        
	        

	        JButton btnNuevoProducto = new JButton("Nuevo Producto");
	        btnNuevoProducto.setBounds(14, 409, 187, 23);
	        contentPane.add(btnNuevoProducto);

	        JButton btnEliminarProducto = new JButton("Eliminar Producto");
	        btnEliminarProducto.setBounds(14, 464, 187, 23);
	        contentPane.add(btnEliminarProducto);

	        JButton btnVerProductos = new JButton("Ver Productos");
	        btnVerProductos.setBounds(14, 519, 187, 23);
	        contentPane.add(btnVerProductos);

	       

	        btnAgregarStock.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	  
	            }
	        });
	        
	    	

	        btnNuevoProducto.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Lógica para "Nuevo Producto"
	                // Puedes agregar aquí la interacción con la clase PantallaProveedor
	            }
	       
	        });

	        btnEliminarProducto.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	eliminarProducto();
	            	
	            }
	        
	        });
	        
	      
	        

	        btnVerProductos.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	            	idProveedor = 0;
	            	  Conexion conexion = new Conexion();
	            	  Connection con = conexion.conectar();
	            	  try {
	  			        String selectQuery = "SELECT * FROM producto WHERE id_proveedor ="+idProveedor;
	  			        PreparedStatement selectStmt = con.prepareStatement(selectQuery);
	  			        ResultSet rs = selectStmt.executeQuery();
	  			        
	  			        modeloTabla.setRowCount(0);

	  			      
	  			        try {
	  			        while(rs.next()){
	  			        	modeloTabla.addRow(new Object[]{
	  	                        rs.getInt("id_producto"),
	  	                        rs.getString("nombre"),
	  	                        rs.getDouble("tamano"),
	  	                        rs.getDouble("precio"),
	  	                        rs.getInt("stock")
	  	                });
	  			        }
	  			    } catch(SQLException u) {
	  			        JOptionPane.showMessageDialog(null, "Database error: " + u.getMessage());
	  			    }
	         }catch (SQLException ex) {
	        	 ex.printStackTrace();
	         }	      

       }
	 });
	        
	}       
	
	       
	        
	  private void eliminarProducto() {
          Conexion conexion = new Conexion();
          Connection con = conexion.conectar();
          
          String idEliminarStr = textFieldEliminarID.getText();
          if (idEliminarStr.isEmpty()) {
              JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
              return;
          }
          
          int id_erase;
          
          try {
              id_erase = Integer.parseInt(idEliminarStr);
          } catch (NumberFormatException ex) {
              JOptionPane.showMessageDialog(null, "Ingrese un ID válido.");
              return;
          }           
          

          try {
              String deleteQuery = "DELETE FROM producto WHERE id_producto = ?";
              PreparedStatement deleteStmt = con.prepareStatement(deleteQuery);
              deleteStmt.setInt(1, id_erase);
              int rowsDeleted = deleteStmt.executeUpdate();

              if (rowsDeleted > 0) {
                  JOptionPane.showMessageDialog(null, "Id de producto eliminado: " + id_erase);
              } else {
                  JOptionPane.showMessageDialog(null, "Ningún registro de producto fue encontrado con la id: " + id_erase);
              }
          } catch (SQLException ex) {
              JOptionPane.showMessageDialog(null, "Error al eliminar producto: " + ex.getMessage());
          }
      }
	

	    public static void main(String[] args) {
	        MenuProveedor frame = new MenuProveedor();
	        frame.setVisible(true);
	        
	        
	    }
	    
	    
	    
	}