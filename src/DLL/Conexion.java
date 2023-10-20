package DLL;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class Conexion {

	 Connection con ;
	
	public Connection conectar() {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/barco","root","");
			//JOptionPane.showMessageDialog(null, "se conecto");
		} catch (Exception e) {
	
			e.printStackTrace();
		}
		return con;
	}
}