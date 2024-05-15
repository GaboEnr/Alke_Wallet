package menu;

import java.util.InputMismatchException;
import java.util.Scanner;

import banco.Cliente;
import banco.Conversor;
import banco.Cuenta;

public class Menu {
	// Llamando metodos y funciona a utilizar dentro del menu
	Scanner sc = new Scanner(System.in);
	Cliente cliente = new Cliente("Gabriel", "Atencio", "289******", "xxxxxxx");
	Cliente menuCliente = new Cliente("Gabriel", "Atencio", " ", " ");

	public void crearMenu(Cuenta cuenta) {

		String menu = """
				**************************************************
				**     Bienvenido al Alket Wallet               **
				**************************************************
				** 1- Ver Saldo                                 **
				** 2- Depositar                                 **
				** 3- Retirar                                   **
				** 4- Convertir Monedas                         **
				** 5- Salir                                     **
				**************************************************""";

		System.out.println(menu);
		System.out.println(menuCliente);

		// Solicita al usuario que ingrese un comando que este contenido en el menu
		int comando = 0; 
		// Try Catch para que el usuario no ingrese letras como comando que recibe
		// enteros, para el caso del menu.
		try {

			System.out.println("Ingrese un comando                              **");
			comando = sc.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Error: Debes ingresar un numero. ");
			sc.next();
			crearMenu(cuenta);

		}
		execMenu(comando, cuenta);

	}

	public void execMenu(int comando, Cuenta cuenta) {
		switch (comando) {
		case 1:
			System.out.println("Haz seleccionado :                    Ver Saldo **");
			System.out.println("El saldo es :                          " + cuenta.getSaldo());

			this.crearMenu(cuenta);

			break;

		case 2:
			System.out.println("Haz seleccionado :                    Depositar **");
			System.out.println("Saldo actual: " + cuenta.getSaldo());
			double saldo = numeroValido("Seleccione monto a Depositar ");
			cuenta.depositar(saldo);
			System.out.println("Haz depositado                        **" + saldo);
			System.out.println("Saldo Actual :                        **" + cuenta.getSaldo());

			this.crearMenu(cuenta);
			break;

		case 3:

			System.out.println("Saldo Actual " + cuenta.getSaldo());
 
			double retiro = numeroValido("Ingrese el monto a Retirar");

			boolean resultado = cuenta.retirar(retiro);
			if (resultado) {
				System.out.println("Transaccion exitosa");
			} else {
				System.out.println("No se pudo realizar el retiro");
			}
			System.out.println();

			this.crearMenu(cuenta);

			break;
		case 4:
			Scanner sc = new Scanner(System.in);

			System.out.print("Ingrea Monto: ");
			double monto = numeroValido("");

			System.out.println("Ingrese la moneda Base de la siguiente lista : \n **      EUR, USD, CLP y JPY      **");
			String base = sc.next();

			System.out.println("Ingresa la moneda a la que deseas convertir: ");
			String destino = sc.next();

			String result;
			try {
				result = Conversor.convertir(monto, base, destino);
				System.out.println(result);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			this.crearMenu(cuenta);

			break;
		case 5:
			System.out.println("Haz seleccionado Salir                         ** \n Nos Vemos Pronto   ");

			break;

		default:
			System.out.println("Haz seleccionado el comando Incorrecto ");

		}

	}
	//Esta clase me permite crear una ecepcion para que no se ingresen letras donde solo deben ir numeros, y me permite limpiar la funcion escaner 
	private double numeroValido(String mensaje) {
		double numero = 0;
		boolean valido = false;
		do {
			try {
				System.out.println(mensaje);
				String entrada = sc.nextLine();
				if(!entrada.startsWith("-")) { 
				numero = sc.nextDouble();
				valido = true;
				}else {
					System.out.println("Error : Debes ingresar un numero positivo ");
				}
				
			}catch (InputMismatchException e) {
					System.out.println("Error: Debes ingresar un numero valido");
					sc.next();
				}
		} while(!valido);
		return numero;
	}
	

}
