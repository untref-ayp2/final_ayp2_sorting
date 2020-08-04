package ayp2.sorting;

import java.util.ArrayList;
import java.util.List;

public class Sorter {
	boolean max;
	
	
	public Sorter() {
		super();
		max = false;
	}
	
	public Sorter(boolean max) {
		this.max = max;
	}
	
	private <T extends Comparable<? super T>> int comparar(T a, T b) {
		if (max) 
			return b.compareTo(a);
		else
			return a.compareTo(b);
		
	}
	
	/***
	 * Método para chequear si un arreglo está ordenado
	 * Orden: completar
	 * @param a: arreglo a chequear
	 * @return true si el arreglo a está ordenado, false en caso contrario 
	 */
	public <T extends Comparable<? super T>> boolean ordenado(T a[]) {
		for(int i=0; i<a.length-1; i++) {
			if(comparar(a[i],a[i+1]) > 0)
				return false;
		}
		return true;
		
	}
	
	/***
	 * Método para intercambiar dos objetos de un arreglo estático
	 * Orden: completar
	 * @param a: arreglo con los elementos a intercambiar
	 * @param i: una posición válida dentro del arreglo a
	 * @param j: una posición válida dentro del arreglo a
	 * @post intercambia los elementos que se encuentran en las posiciones i y j del arreglo 
	 */
	public <T extends Comparable<? super T>> void intercambiar(T[] a, int i, int j) {

		T aux = a[i];
		a[i] = a[j];
		a[j] = aux;

	}

	/***
	 * Ordena un arreglo estático de algún tipo T usando el algoritmo de inserción
	 * Orden: completar
	 * @param a: arreglo a ordenar. 
	 * @pre el arreglo a no es null
	 * @post el arreglo a  se encuentra ordenado de acuerdo al orden natural de sus elementos
	 */
	public <T extends Comparable<? super T>> void insercion( T[] a ) {	
		
		 for (int i = 1; i < a.length; i++) { 
		        T key = a[i]; 
		        int j = i - 1;
		        while (j >= 0 && comparar(a[j], key)>0) {
		            a[j + 1] = a[j];
		            j = j - 1;
		        }
		        a[j + 1] = key; 
		    }
		
    
	}

	/***
	 * Ordena un arreglo estático de algún tipo T usando el algoritmo de quicksort
	 * Orden: completar
	 * @param a: arreglo a ordenar. 
	 * @pre el arreglo a no es null
	 * @post el arreglo a  se encuentra ordenado de acuerdo al orden natural de sus elementos
	 */
	public <T extends Comparable<? super T>> void quicksort( T[] a ) {

		//TO-DO
	
	}
	
	/***
	 * Ordena un arreglo estático de algún tipo T usando el algoritmo de heapsort
	 * Orden: completar
	 * @param a: arreglo a ordenar. 
	 * @pre el arreglo a no es null
	 * @post el arreglo a  se encuentra ordenado de acuerdo al orden natural de sus elementos
	 */
	public <T extends Comparable<? super T>> void heapsort( T [ ] a )
    {
        for( int i = a.length / 2 - 1; i >= 0; i-- )  /* buildHeap */
            percDown( a, i, a.length );
        for( int i = a.length - 1; i > 0; i-- )
        {
            intercambiar( a, 0, i );            /* deleteMax */
            percDown( a, 0, i );
        }
    }

    /**
     * Internal method for heapsort.
     * @param i the index of an item in the heap.
     * @return the index of the left child.
     */
    private int leftChild( int i )
    {
        return 2 * i + 1;
    }

    /**
     * Internal method for heapsort that is used in
     * deleteMax and buildHeap.
     * @param a an array of Comparable items.
     * @index i the position from which to percolate down.
     * @int n the logical size of the binary heap.
     */
    private <T extends Comparable<? super T>> void percDown( T [ ] a, int i, int n )
    {
        int child;
        T tmp;

        for( tmp = a[ i ]; leftChild( i ) < n; i = child )
        {
            child = leftChild( i );
            if( child != n - 1 && comparar(a[child], a[child+1])  < 0 )
                child++;
            if(comparar(tmp, a[child]) < 0 )
                a[ i ] = a[ child ];
            else
                break;
        }
        a[ i ] = tmp;
    }

	
	/***
	 * Ordena un arreglo estático de algún tipo T usando el algoritmo de mergesort
	 * Orden: completar
	 * @param a: arreglo a ordenar. 
	 * @pre el arreglo a no es null
	 * @post el arreglo a  se encuentra ordenado de acuerdo al orden natural de sus elementos
	 */
	public <T extends Comparable<? super T>> void mergesort( T[] a ) {

		//TODO
		
		}
	
	/***
	 * Ordena un arreglo estático de Integer usando RadixSort
	 * Orden: completar
	 * @param a: arreglo a ordenar 
	 * (los elementos del arreglo deben ser números naturales hasta Integer.MAX_VALUE / 10). 
	 * @pre el arreglo a no es null
	 * @post el arreglo a  se encuentra ordenado de acuerdo al orden natural de sus elementos
	 */
	public void radixsort(Integer[] a) {

		final int RADIX = 10; 
		
		@SuppressWarnings("unchecked")
		List<Integer>[] bucket= new ArrayList[RADIX];
		
		for (int i = 0; i < bucket.length; i++) { 
			bucket[i] = new ArrayList<Integer>(); 
		}
		// sort
		boolean maxLength = false;
		int tmp = -1, placement = 1; 
		while (!maxLength) { 
			maxLength = true; 
			// split input between lists 
			for (Integer i : a) { 
				tmp = i / placement;
				bucket[tmp % RADIX].add(i); 
				if (maxLength && tmp > 0) { 
					maxLength = false; 
				} 
			} 
			// empty lists into input array 
			int x = 0; 
			for (int y = 0; y < RADIX; y++) { 
				for (Integer i : bucket[y]) { 
					a[x++] = i; 
				} bucket[y].clear(); 
			} // move to next digit
			placement *= RADIX; 
		} 
	}
}

