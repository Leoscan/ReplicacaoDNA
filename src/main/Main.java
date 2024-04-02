package main;

import java.util.Iterator;
import java.util.concurrent.*;

import classes.Auxiliar;
import threads.ThreadBusca;

public class Main {
	public static void main(String[] args) {
		ExecutorService executorService = Executors.newCachedThreadPool();
		Auxiliar aux = new Auxiliar(); 
		
		for (int i = 0; i < 10; i++) {
			Thread busca = new Thread(new ThreadBusca("arquivosDNA/dna-"+i+".txt", aux));
			executorService.execute(busca);
		}
		
		executorService.shutdown();

		try {
		    if (!executorService.awaitTermination(60, TimeUnit.SECONDS)) {
		        System.out.println("Algumas tarefas não foram concluídas dentro do tempo limite");
		    } else {
		        System.out.println("O total de Fita: " + aux.total);
		        System.out.println("O total de Fitas Válidas: " + aux.certas);
		        System.out.println("O total de Fitas Inválidas: " + aux.erradas);

		        System.out.println("As linhas inválidas são:");
		        for(int i = 0; i < aux.linhasErradas.size(); i++) {   					
		        	int x = (int) aux.linhasErradas.get(i);
		        	System.out.println(x);
		        }
		    }
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}

		
	}
}
