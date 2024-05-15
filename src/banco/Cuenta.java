package banco;

import java.util.Random;

public class Cuenta {
	// Atributos
	private int numCuenta;
	private double saldo;
	private Moneda moneda;

	//Constructor Solo
	public Cuenta() {
		super();
	}
	/**
	 * Metodo constructor 
	 */
	public Cuenta(int numCuenta, double saldo, Moneda moneda) {
		super();
		this.numCuenta = new Random().nextInt(1000000) + 1000000;

		this.saldo = saldo;
		this.moneda = moneda;
	}

	// metodos para depositar dinero
	public boolean depositar(double deposito) {
		saldo += deposito;
		return true;
	}

	/**
	 * 
	 * @param retiro
	 * @return true en caso posito de deposito
	 * @return false en case de no poder realizar deposito
	 */
	public boolean retirar(double retiro) {
		if (saldo >= retiro ) {
			saldo -= retiro;
			return true;
		} 
		return false;
	}

	public boolean seeDepositar(double deposito) {
		return false;
	}

	public boolean seeRetirar(double retiro) {
		return false;
	}

	@Override
	public String toString() {
		// **************************************************
		return String.format("**%15s%-10s%10s%12.2f  **\n", "Numero Cta:", Integer.toString(numCuenta), "Saldo:", saldo)
				+ String.format("**%15s%-10s%10s%12s  **\n", "Moneda:", moneda, "", "");
		
	}

	public int getNumCuenta() {
		return numCuenta;
	}

	public void setNumCuenta(int numCuenta) {
		this.numCuenta = numCuenta;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public Moneda getMoneda() {
		return moneda;
	}


}
