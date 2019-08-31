package data_structures;

public class ListaEncadenada<E> implements IListaEncadenada<E> {


	private  NodoListaEncadenada<E> primerNodo;
	private  NodoListaEncadenada<E> ultimoAgregado;

	private int tamanio;

	public ListaEncadenada() {
		primerNodo=null;
		tamanio=0;
	}
	public int darTamano() {
		return tamanio;
	}

	@Override
	public E darElemento(int i) {
		E buscado=null;
		if(i==0){
			buscado=primerNodo.darElemento();
		}
		else{
			NodoListaEncadenada<E>actual=primerNodo;
			int pos=0;
			boolean encontrado=false;
			while(actual.darSiguiente()!=null&&!encontrado){
				if(pos+1==i){
					buscado=actual.darSiguiente().darElemento();
					encontrado=true;
				}
				else{
					actual=actual.darSiguiente();
					pos++;
				}
			}
		}
		return buscado;

	}

	@Override
	public E buscarElemento(E dato) {
		E buscado=null;
		if(primerNodo.darElemento().equals(dato)){
			buscado=primerNodo.darElemento();
		}
		else{
			NodoListaEncadenada<E>actual=primerNodo;
			boolean encontrado=false;
			while(actual.darSiguiente()!=null&&!encontrado){
				if(actual.darSiguiente().darElemento().equals(dato)){
					buscado=actual.darSiguiente().darElemento();
					encontrado=true;
				}
				else
				{
					actual=actual.darSiguiente();
				}
			}

		}
		return buscado;
	}

	public E eliminar(E dato) {
		NodoListaEncadenada<E>actual=primerNodo;
		NodoListaEncadenada<E>buscado=null;
		E eliminado=null;

		if(primerNodo.darElemento().equals(dato)){
			primerNodo=primerNodo.darSiguiente();
			tamanio--;
		}
		else{
			while(actual!=null&&!actual.darElemento().equals(dato)){
				buscado=actual;
				actual=actual.darSiguiente();

			}
			eliminado=actual.darElemento();
			buscado.cambiarSiguiente(actual.darSiguiente());
			tamanio--;

		}
		return eliminado;
	}

	@Override
	public void agregarElemento(E dato) {
		if(primerNodo==null){
			primerNodo=new NodoListaEncadenada<E>(dato);
			ultimoAgregado = primerNodo;
			tamanio++;
		}
		else{
			if(ultimoAgregado.darSiguiente()==null)
			{
				NodoListaEncadenada<E> nuevo = new NodoListaEncadenada<E>(dato);
				ultimoAgregado.cambiarSiguiente(nuevo);
				ultimoAgregado = nuevo;
				tamanio++;	
			}
		}


	}
	public NodoListaEncadenada<E> darNodoActual()
	{
		return primerNodo;
	}
	public NodoListaEncadenada<E> darSiguienteNodo()
	{
		return primerNodo.darSiguiente();
	}


}
