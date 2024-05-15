package banco;

public class Moneda {
	/**
	 * Atributos de la clase Moneda
	 * @String nombre, codigo
	 * @double tasa
	 * 
	 */
	 
	private String nombre;
	private double tasa;
	private String codigo;
	/**
	 * Metodo constructor
	 * @param nombre
	 * @param tasa
	 * @param codigo
	 */
	public Moneda(String nombre, double tasa, String codigo) {
		super();
		this.nombre = nombre;
		this.tasa = tasa;
		this.codigo = codigo;
	}
	// metodos getter y setters
	public double getTasa() {
		return tasa;
	}

	public void setTasa(double tasa) {
		this.tasa = tasa; 
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "Moneda [nombre=" + nombre + ", tasa=" + tasa + ", codigo=" + codigo + "]";
	}

}
