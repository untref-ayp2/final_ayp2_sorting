package ayp2.sorting;

/**
 * Clase que permite registrar tiempos de ejecución
 */
public class Timer {
	private long ini;
	private long fin;
	private long elapsed;
	boolean valid=true;
	
	public Timer() {
		super();
		clear();
	}
	
	public void start() {
		ini=System.nanoTime();
		valid=false;
	}
	
	public void stop() {
		fin=System.nanoTime();
		elapsed=fin-ini;
		valid = true;
	}
	
	public double getElapsedTimeNanoSec() {
		if (!valid) throw new RuntimeException("Timer inválido");
		return elapsed;
	}
	
	public double getElapsedTimeSec() {
		if (!valid) throw new RuntimeException("Timer inválido");
		return elapsed*1e-9;
	}
	
	public double getElapsedTimeMiliSec() {
		if (!valid) throw new RuntimeException("Timer inválido");
		return elapsed*1e-6;
	}
	public void clear() {
		this.ini = 0;
		this.fin = 0;
		this.elapsed = 0;
	}
}