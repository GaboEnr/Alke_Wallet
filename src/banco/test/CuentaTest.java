package banco.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.Test;

import banco.Cuenta;
import banco.Moneda;

class CuentaTest {
	
	  @Test
	    public void testDepositar() {
	        Moneda moneda = new Moneda("Dólar", 1.0, "USD");
	        Cuenta cuenta = new Cuenta(123456, 100.0, moneda);
	        assertTrue(cuenta.depositar(50.0));
	        assertEquals(150.0, cuenta.getSaldo(), 0.001);
	    }

	    @Test
	    public void testRetirar() {
	        Moneda moneda = new Moneda("Dólar", 1.0, "USD");
	        Cuenta cuenta = new Cuenta(123456, 100.0, moneda);
	        assertTrue(cuenta.retirar(50.0));
	        assertEquals(50.0, cuenta.getSaldo(), 0.001);
	    }

	    @Test
	    public void testRetirarNoSuficienteSaldo() {
	        Moneda moneda = new Moneda("Dólar", 1.0, "USD");
	        Cuenta cuenta = new Cuenta(123456, 100.0, moneda);
	        assertFalse(cuenta.retirar(150.0));
	        assertEquals(100.0, cuenta.getSaldo(), 0.001);
	    }
	}
