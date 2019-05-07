package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import control.Estado;
import control.Poblacion;
import modelo.poblacion.Seres;

class EstadoTest {
	Estado estado = new Estado();
	Poblacion poblacion;

	@Test
	void testFallecimiento() {
		Seres ser = new Seres();
		if (ser.getEdad()>=ser.getEsperanzaVida()) {
			assertEquals(true, poblacion.isFallecido(ser));
		} else {
			assertEquals(false, poblacion.isFallecido(ser));
		}
	}

}
