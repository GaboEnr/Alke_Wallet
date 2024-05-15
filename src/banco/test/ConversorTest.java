package banco.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import banco.Conversor;



class ConversorTest {

	@Test
	
	//Este bloque captura cualquier excepción que pueda ocurrir durante la ejecución del bloque try.
	//fail("No funciona");: 
	
	void test() {
		try {
			String result = Conversor.convertir(1000.0, "CLP" , "USD");
			assertEquals(result, "La conversion es : 935.00");
			assertNotEquals(result, "La conversion es : 1000.00"); //Verifica que el resultado no sea igual a 1000.00 USD
		} catch (Exception e) {
			fail("no funciona"); //Este bloque captura cualquier excepción que pueda ocurrir durante la ejecución del bloque try.
			e.printStackTrace(); //fail("No funciona");: 
			
		}
	}

}
