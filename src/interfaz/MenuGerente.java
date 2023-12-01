package interfaz;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MenuGerente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private JTextField textIdContenedor;
    private JTextField textCapacidad; 
    private JTextField textColor;
    private JComboBox comboIdBarco;
    
    private JButton btnCrearContenedor;

    private PantallaGerente interfaz;

	/**
	 * Launch the application.
	 */
			public void run() {
				try {
					MenuGerente frame = new MenuGerente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
	/**
	 * Create the frame.
	 */
	public MenuGerente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textIdContenedor = new JTextField();
	    textIdContenedor.setBounds(10, 10, 100, 25);
	    contentPane.add(textIdContenedor);

	    textCapacidad = new JTextField();
	    textCapacidad.setBounds(120, 10, 100, 25);
	    contentPane.add(textCapacidad);
	    
	    comboIdBarco = new JComboBox();
	    comboIdBarco.setBounds(230, 10, 100, 25);
	    contentPane.add(comboIdBarco);

	    btnCrearContenedor = new JButton("Crear"); 
	    btnCrearContenedor.setBounds(340, 10, 100, 25);
	    contentPane.add(btnCrearContenedor);
		PantallaGerente interfaz = new PantallaGerente();
	    btnCrearContenedor.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            
	            int idContenedor = Integer.parseInt(textIdContenedor.getText());
	            int capacidad = Integer.parseInt(textCapacidad.getText());
	            String color = textColor.getText();  
	            int idBarco = (int) comboIdBarco.getSelectedItem(); 

	            interfaz.crearNuevoContenedor(idContenedor, capacidad, color, idBarco);
	            
	        }



	    });

	}

}
