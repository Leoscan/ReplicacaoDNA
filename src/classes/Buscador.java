package classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Semaphore;

public class Buscador {
	public synchronized void lerArquivo(String nomeArquivo, Auxiliar aux) throws InterruptedException {
		File arquivo = new File(nomeArquivo);
		int i = 1;
		
        try {
        	Scanner scanner = new Scanner(arquivo);
            PrintWriter writer = new PrintWriter(new File(nomeArquivo+".output"));
            
			while (scanner.hasNextLine()) {
				
	            String linha = scanner.nextLine();
	          
	            if (Biologia.VerificaNucleotideos(linha)) {
	            	String linhaRNA = Biologia.TransformaRNA(linha);
	                writer.write(linhaRNA + "\n");
	                
	                aux.certas++;
	                aux.linhasTraduzidas.add(i);
	            } else {
	                writer.write("****FITA INVALIDA - " + linha + "\n");

	                aux.erradas++;
	                aux.linhasErradas.add(i);
	            }
	            
	            aux.total++;
	            i++;
	        }
	        scanner.close();
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	
}