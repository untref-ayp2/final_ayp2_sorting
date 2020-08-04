package ayp2.sorting;

public class Main {
	
	public static void prueba1() {
		int N = 10000000;
		int max = 100;
		
		
		Integer [] datos;
		GeneradorDatos aleatorio = new GeneradorDatos(N,0,max);
		
		Timer temporizador = new Timer();
		Sorter algoritmos = new Sorter();
		double tiempo_HS, tiempo_RS;		
		
		System.out.println("Caso de Prueba 1: Datos Aleatorios");
		System.out.println("Comparación Heapsort y RadixSort");
		System.out.println("Naturales entre 0 y "+ max);
		System.out.println("N = "+N);
		datos = aleatorio.get();
		//System.out.println(Arrays.deepToString(datos));
		temporizador.start();
		algoritmos.heapsort(datos);
		temporizador.stop();
		tiempo_HS = temporizador.getElapsedTimeSec();
		
		//System.out.println(Arrays.deepToString(datos));
		System.out.println("Heapsort: "+ tiempo_HS);
		
		datos = aleatorio.get();
		temporizador.start();
		algoritmos.radixsort(datos);
		temporizador.stop();
		tiempo_RS = temporizador.getElapsedTimeSec();
		
		//System.out.println(Arrays.deepToString(datos));
		System.out.println("RadixSort: "+ tiempo_RS);
	}
	
	public static void prueba2() {
		int N = 10000000;
		int M = (int) (N*0.999999);		
		
		Integer [] datos;
		GeneradorDatos parcialmenteOrdenado = new GeneradorDatos(N,M);
		
		Timer temporizador = new Timer();
		Sorter algoritmos = new Sorter();
		double tiempo_HS, tiempo_IS;		
		
		System.out.println("Caso de Prueba 2: Datos Parcialmente Ordenados");
		System.out.println("Comparación Heapsort e Inserción");
		System.out.println("N = "+N);
		System.out.println("Los primeros "+M+" elementos están ordenados");
		datos = parcialmenteOrdenado.get();
		//System.out.println(Arrays.deepToString(datos));
		temporizador.start();
		algoritmos.heapsort(datos);
		temporizador.stop();
		tiempo_HS = temporizador.getElapsedTimeSec();
		
		//System.out.println(Arrays.deepToString(datos));
		System.out.println("Heapsort: "+ tiempo_HS);
		
		datos = parcialmenteOrdenado.get();
		temporizador.start();
		algoritmos.insercion(datos);
		temporizador.stop();
		tiempo_IS = temporizador.getElapsedTimeSec();
		
		//System.out.println(Arrays.deepToString(datos));
		System.out.println("Insercion: "+ tiempo_IS);
		
	}

	public static void main(String args[]) {
		
		prueba1();
		System.out.println("");
		prueba2();
	
		
		
		}
}
