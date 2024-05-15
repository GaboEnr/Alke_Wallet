package banco;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Conversor extends Moneda { 

	public Conversor(String nombre, double tasa, String codigo) {
		super(nombre, tasa, codigo);
		
	}

	public static String convertir(double monto, String base, String destino) throws Exception {
		
		//
		Moneda peso = new Moneda("Peso Chileno", 1, "CLP");
		Moneda dolar = new Moneda("Dolar Americano", 0.935, "USD");
		Moneda euro = new Moneda("Euro ", 0.00100, "EUR");
		Moneda yen = new Moneda("Yen Japones", 0.1637, "JPY");
		
		List<Moneda> monedas = new LinkedList<>();
		
		//Creando las monedas para que sea recorrida por la Lista de monedas
		monedas.add(dolar); 
		monedas.add(peso);
		monedas.add(yen);
		monedas.add(euro);

		// esta línea busca la primera moneda en la lista monedas cuyo código sea igual a base o destino(convertido a mayúsculas)
		//y la almacena en un Optional llamado monedaBase, lo mismo con monedaDestino. 
			
		Optional<Moneda> monedaBase = monedas.stream().filter(item -> item.getCodigo().equals(base.toUpperCase())).findFirst();
		Optional<Moneda> monedaDestino = monedas.stream().filter(item -> item.getCodigo().equals(destino.toUpperCase())).findFirst();
		
		//Esta operacion detecta en caso de que no ingrese una moneda
		if(monedaBase.isEmpty() || monedaDestino.isEmpty()) {
			throw new Exception("Ingrese una moneda valida");
		}

		return String.format("La conversion es : %.2f", (monto * monedaDestino.get().getTasa() / monedaBase.get().getTasa()));
			
	}

}
