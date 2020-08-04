package ayp2.sorting;

import java.util.Random;

/**
 * Clase que permite generar arreglos de números enteros en forma aleatoria
 * los primeros m elementos del arreglo pueden estar ordenados
 *
 */
public class GeneradorDatos {
	
	private Integer[] arreglo; // arreglo de datos generados
	
	private int tamanio; //tamanio del arreglo
	private int ordenado;// cantidad de elementos ordenados dentro del arreglos.
	private int max;     // Si se generan Naturales, indica el máximo Natural a generar
	
	/***
	 * Genera un arreglo de Naturales entre 0 y un parámetro
	 * @param tamanio: tamaño de los datos a generar
	 * @param ordenado: cantidad de elementos ordenados al inicio de los datos
	 * @param max: Máximo natural a generar entre los elementos del arreglo
	 * @post el generador de datos ha generado la secuencia solicitada 
	 */
	public GeneradorDatos(int tamanio, int ordenado, int max) {
		super();
		if (tamanio <= 0) throw new RuntimeException("Tamaño inválido");
		if(ordenado < 0) ordenado = 0;
		if(ordenado > tamanio) ordenado = tamanio;
		
		
		this.tamanio = tamanio;
		this.ordenado = ordenado;
		this.max = max;
		this.arreglo = new Integer[tamanio];
		generarNaturales();
	}
	
	/***
	 * Genera un arreglo de Enteros entre Integer.MIN_VALUE e Integer.MAX_VALUE
	 * @param tamanio: tamaño de los datos a generar
	 * @param ordenado: cantidad de elementos ordenados al inicio de los datos
	 * @post el generador de datos ha generado la secuencia solicitada 
	 */
	
	public GeneradorDatos(int tamanio, int ordenado) {
		super();
		if (tamanio <= 0) throw new RuntimeException("Tamaño inválido");
		if(ordenado < 0) ordenado = 0;
		if(ordenado > tamanio) ordenado = tamanio;
		
		
		this.tamanio = tamanio;
		this.ordenado = ordenado;
		this.max = 0;
		this.arreglo = new Integer[tamanio];
		generarEnteros();
	}
	
	/***
	 * Método privado para generar la secuencia de naturales según parámetros del constructor 
	 */
	private void generarNaturales() {
		Random random = new Random();
		
		arreglo[0] = random.nextInt(max);
		int previo = arreglo[0];
		for(int i=1; i<ordenado; i++) {
			int randomOffset = random.nextInt(3);
            int currentElement = previo + randomOffset;
            if (currentElement >= max) currentElement = max-1;
            arreglo[i] = currentElement;
            previo = currentElement;
		}
         for(int i=ordenado; i<tamanio;i++) {
            arreglo[i] = random.nextInt(max);
         }
	}
	
	
	/***
	 * Método privado para generar la secuencia de enteros según parámetros del constructor 
	 */
	private void generarEnteros() {
		Random random = new Random();
		
		arreglo[0] = random.nextInt();
		int previo = arreglo[0];
		for(int i=1; i<ordenado; i++) {
			int randomOffset = random.nextInt(3);
            int currentElement = previo + randomOffset;
            arreglo[i] = currentElement;
            previo = currentElement;
		}
         for(int i=ordenado; i<tamanio;i++) {
            arreglo[i] = random.nextInt();
         }
	}
	
	/***
	 * Devuelve una copia del arreglo generado según parámetros del constructor
	 */
	public Integer[] get() {
		return arreglo.clone();
	}
	
}
