/** 
 * Proyecto: Juego de la vida.
 * @since: prototipo1.2
 * @source: NifTest.java 
 * @version: 2.1 - 2017.05.05
 * @author: Fran
 * @author: Grupo 3
 */
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class NifTest {
	private Nif nif1; 
	private Nif nif2;

	/**
	 * Método que se ejecuta antes de cada @Test para preparar datos de prueba.
	 */
	@Before
	public void crearDatosPrueba() throws ModeloException{
		// Objetos para la prueba.
		nif1 = new Nif(); 
		nif2 = new Nif("00000001R");
	}

	/**
	 * Método que se ejecuta después de cada @Test para limpiar datos de prueba.
	 */
	@After	
	public void borrarDatosPrueba() throws ModeloException {
		nif1 = null;
	}

	// Test CON DATOS VALIDOS
	@Test
	public void testNifConvencional() throws ModeloException {
		assertNotNull(nif2);
		assertEquals(nif2.getTexto(), "00000001R");
	}

	@Test
	public void testNifDefecto() throws ModeloException {
		assertTrue(nif1 != null);
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testNifCopia() throws ModeloException {
		nif1 = new Nif(nif2);
		assertNotSame(nif1, nif2);
	}

	@Test
	public void testGetTexto() throws ModeloException {
		assertEquals(nif2.getTexto(), "00000001R");
	}

	@Test
	public void testSetTexto() throws ModeloException {
		nif1.setTexto("00000001R");
		assertEquals(nif1.getTexto(), "00000001R");
	}

	@Test
	public void testToString() throws ModeloException {
		assertEquals(nif2.toString(), "00000001R");
	}

	@Test
	public void testEqualsObject() throws ModeloException {
		nif1 = new Nif("00000001R");
		assertTrue(nif1.equals(nif2));
	}

	@Test
	public void testClone() throws ModeloException {
		nif1 = (Nif) nif2.clone();
		assertNotSame(nif1, nif2);
	}

	@Test
	public void testHashCode() throws ModeloException {
		assertEquals(nif1.hashCode(), -2032408461);
	}

	// Test CON DATOS NO VALIDOS
	@Test
	public void testNifConvencionalNull() throws ModeloException {
		try {
			String texto = null;
			nif1 = new Nif(texto);
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testNifConvencionalFormato() throws ModeloException {
		try {
			nif1 = new Nif("00000000-T");
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testNifConvencionalLetra() throws ModeloException{
		try {
			nif1 = new Nif("00000000F");
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testSetTextoNull() throws ModeloException {
		try {
			nif1.setTexto(null);
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testSetTextoMalFormato() throws ModeloException {
		try {
			nif1.setTexto("00000000-T");
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

	@Test
	public void testSetTextoLetraIncorrecta() throws ModeloException {
		try {
			nif1.setTexto("00000000F");
			throw new ModeloException("No debe llegar aquí...");
		} catch (AssertionError e) { }

		// Si funciona bien no debe cambiar el valor por defecto.
		assertEquals(nif1.getTexto(), "00000000T");
	}

} //class
