package threads;

import classes.Auxiliar;
import classes.Buscador;

public class ThreadBusca implements Runnable{
	private String nomeArquivo;
	private Auxiliar aux;
	
	
	public ThreadBusca(String nomeArquivo, Auxiliar aux) {
		this.nomeArquivo = nomeArquivo;
		this.aux = aux;
	}

	@Override
	public void run() {
		Buscador buscador = new Buscador();
		try {
			buscador.lerArquivo(nomeArquivo, aux);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} 
}
