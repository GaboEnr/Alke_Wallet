package menu;

import banco.Cuenta;

public class Main { 
	//Main principal donde se inician algunas clases para que se pueda ejecutar en dicho menu.
	public static void main(String[] args) {
		Menu menu = new Menu();
		Cuenta cuenta = new Cuenta();
		cuenta.depositar(0); 
		cuenta.retirar(0);
		menu.crearMenu(cuenta);

	}


}
