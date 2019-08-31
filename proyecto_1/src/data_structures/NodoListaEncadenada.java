package data_structures;

public class NodoListaEncadenada<E> {

	protected E elemento;


	protected NodoListaEncadenada<E>siguiente;

	public NodoListaEncadenada(E elemento)
	{
		this.elemento=elemento;

	}

	/**
	 * Método que cambia el siguiente nodo.
	 * <b>post: </b> Se ha cambiado el siguiente nodo
	 * @param siguiente El nuevo siguiente nodo
	 */
	public void cambiarSiguiente(NodoListaEncadenada<E> siguiente)
	{
		this.siguiente=siguiente;

	}

	/**
	 * Método que retorna el elemento almacenado en el nodo.
	 * @return El elemento almacenado en el nodo.
	 */
	public E darElemento()
	{
		return elemento;
	}

	/**
	 * Cambia el elemento almacenado en el nodo.
	 * @param elemento El nuevo elemento que se almacenará en el nodo.
	 */
	public void cambiarElemento(E elemento)
	{
		this.elemento = elemento;
	}


	/**
	 * Método que retorna el siguiente nodo.
	 * @return Siguiente nodo
	 */
	public NodoListaEncadenada<E> darSiguiente()
	{
		return siguiente;
	}

}
