package data_structures;


import mundo.ViajeUber;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico implements IArregloDinamico {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private ViajeUber[] elementos;

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = new ViajeUber[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( ViajeUber dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			ViajeUber [ ] copia = elementos;
			elementos = new ViajeUber[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public void shellSort() 
	{ 
		int n = tamanoAct; 

		for (int gap = n/2; gap > 0; gap /= 2) 
		{ 
			for (int i = gap; i < n; i += 1) 
			{ 

				ViajeUber temp = elementos[i]; 
				int j; 
				for (j = i; j >= gap &&this.darElemento(j-gap).compareTo(temp)>0; j -= gap) {
					elementos[j] = elementos[j - gap]; 
				}

				elementos[j] = temp; 
			} 
		} 

	}
	public void mergeSort(ArregloDinamico a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		ArregloDinamico l = new ArregloDinamico(mid);
		ArregloDinamico r = new ArregloDinamico(n - mid);

		for (int i = 0; i < mid; i++) {
			l.agregar(a.darElemento(i));
		}
		for (int i = mid; i < n; i++) {
			r.agregar(a.darElemento(i));
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}
	public static void merge(ArregloDinamico a, ArregloDinamico l, ArregloDinamico r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l.darElemento(i).compareTo(r.darElemento(j))<=0) {
				a.darElementos()[k++] = l.darElementos()[i++];
			}
			else {
				a.darElementos()[k++] = r.darElementos()[j++];
			}
		}
		while (i < left) {
			a.darElementos()[k++] = l.darElementos()[i++];
		}
		while (j < right) {
			a.darElementos()[k++] = r.darElementos()[j++];
		}
	}

	public void quickSort(ArregloDinamico arr, int begin, int end) {
		if (begin < end) {
			int partitionIndex = partition(arr, begin, end);

			quickSort(arr, begin, partitionIndex-1);
			quickSort(arr, partitionIndex+1, end);
		}
	}
	private int partition(ArregloDinamico arr, int begin, int end) {
		ViajeUber pivot = arr.darElemento(end);
		int i = (begin-1);
		for (int j = begin; j < end; j++) {
			if (arr.darElemento(j).compareTo(pivot)<=0) {
				i++;
				ViajeUber swapTemp = arr.darElemento(i);
				arr.darElementos()[i] = arr.darElementos()[j];
				arr.darElementos()[j] = swapTemp;
			}
		}

		ViajeUber swapTemp = arr.darElemento(i+1);
		arr.darElementos()[i+1] = arr.darElementos()[end];
		arr.darElementos()[end] = swapTemp;

		return i+1;
	}
	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public ViajeUber darElemento(int i) {

		return elementos[i];
	}

	public ViajeUber buscar(ViajeUber dato) {
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		ViajeUber rta = null;
		int comparacion = 0;
		for(int i=0;i<elementos.length&&comparacion==0;i++)
		{
			comparacion = elementos[i].compareTo(dato);
			if(comparacion==1)
			{
				rta = elementos[i];
			}
		}
		return rta;
	}



	@Override
	public ViajeUber eliminar(String dato) {
		// TODO Auto-generated method stub
		return null;
	}
	public ViajeUber[]darElementos(){
		return elementos;
	}


}
