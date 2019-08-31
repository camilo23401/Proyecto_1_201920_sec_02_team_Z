package testEstructuras;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import data_structures.ListaEncadenada;

public class TestListaEncadenada {

	private ListaEncadenada<String> lista;

	@Before
	public void setUp1() {
		lista=new ListaEncadenada<String>();
	}


	@Test
	public void testAgregarElemento() {
		lista.agregarElemento("Nestor");	
		lista.agregarElemento("Camilo");
		lista.agregarElemento("Carlos");
		assertEquals(3, lista.darTamano());
	}

	@Test
	public void testBuscarElemento() {
		lista.agregarElemento("Nestor");	
		lista.agregarElemento("Camilo");
		lista.agregarElemento("Carlos");
		assertNotNull(lista.buscarElemento("Nestor"));
		assertEquals("Nestor",lista.buscarElemento("Nestor"));
		assertNotNull(lista.buscarElemento("Camilo"));
		assertEquals("Camilo",lista.buscarElemento("Camilo"));
		assertNotNull(lista.buscarElemento("Carlos"));
		assertEquals("Carlos",lista.buscarElemento("Carlos"));


	}
	@Test
	public void testBuscarElementoPorIndice() {
		lista.agregarElemento("Nestor");	
		lista.agregarElemento("Camilo");
		lista.agregarElemento("Carlos");
		assertEquals("Nestor",lista.darElemento(0));
		assertEquals("Camilo",lista.darElemento(1));
		assertEquals("Carlos",lista.darElemento(2));



	}
	@Test
	public void testEliminarElemento() {
		lista.agregarElemento("Nestor");	
		lista.agregarElemento("Camilo");
		lista.agregarElemento("Carlos");
		lista.eliminar("Nestor");
		assertEquals(2, lista.darTamano());
		assertNull(lista.buscarElemento("Nestor"));
	}


}
