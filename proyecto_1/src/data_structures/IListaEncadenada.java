package data_structures;

public interface IListaEncadenada <E>{
	/**
	 * Retornar el numero de elementos presentes en el arreglo
	 * @return
	 */
	int darTamano( );

	/**
	 * Retornar el elemento en la posicion i
	 * @param E posicion de consulta
	 * @return elemento de consulta. null si no hay elemento en posicion.
	 */
	E darElemento( int i);

	/**
	 * Buscar un elemento en el arreglo.
	 * @param E elemento buscado
	 * @return elemento encontrado en el arreglo (si existe). null si no se encontro el dato.
	 */
	E buscarElemento(E dato);

	/**
	 * Agregar un elemento al final de la lista
	 * @param E nuevo elemento
	 */
	public void agregarElemento( E dato );

	/**
	 * Eliminar un elemento del arreglo
	 * @param E elemento que se quiere eliminar
	 * @return elemento eliminado
	 */
	E eliminar( E dato );

	
}
