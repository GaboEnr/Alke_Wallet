package banco;

import java.util.LinkedList;
import java.util.List;

public class Cliente extends Cuenta {
	//Atributos para crear la clase Cuenta
	private String nombre; 
	private String apellido; 
	private String rut;
	private String password;
	List<Cuenta> cuentas; 
	
	//Metodo Constructor 
	public Cliente(String nombre, String apellido, String rut, String password) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.password = password;
		cuentas = new LinkedList<Cuenta>();     
		
	}

	
	//Metodo to String
	@Override 
	public String toString() {
		String result = new String(); 
        for(int i = 0; i < cuentas.size(); i++) {
        	result += cuentas.get(i);
        }
		
		return String.format("**%15s%-10s%10s%-11s**\n", "Nombre:", nombre, "Apellido:", apellido)+
				String.format("**%15s%-10s%10s%-11s**\n", "Password:", password, "RUT:", rut)+ 
				"**************************************************\n" +
				result+
				"**************************************************\n";

	}

}
