package logica;

public interface validador {
	
	public default boolean ValidarContrasena(String contrasena)	{
		for (int i = 0; i < contrasena.length(); i++) {
			if (!Character.isAlphabetic(contrasena.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public default boolean ValidarMail(String usuario) {
		
		if(usuario.contains("@") && usuario.contains(".com")) {
			return true;
		} else {
			return false;
		}
	}
	
	public default boolean ValidarNombre(String nombre) {
		
		if(nombre != null && !nombre.trim().isEmpty()) { // ultilizo para verificar que el nombre no sea nulo y 
			return true; // va ser un nombre valido        que no este vacio o contenga solo espacios
		} else {
			return false;
		}
		
	}
	
	
}
