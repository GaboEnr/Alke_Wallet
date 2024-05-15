
package banco.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

import banco.Moneda;

class MonedaTest {



	    @Test
	    public void testSetTasa() {
	        Moneda moneda = new Moneda("Euro",  0.00100, "EUR");
	        moneda.setTasa(0.00100);
	        assertEquals(0.00100, moneda.getTasa(), 0.0001);
	    }

	    @Test
	    public void testSetCodigo() {
	        Moneda moneda = new Moneda("Peso Chileno", 1, "CLP");
	        moneda.setCodigo("CLP");
	        assertEquals("CLP", moneda.getCodigo());
	    }
	}

