package classes;

public class Biologia {
	public static boolean VerificaNucleotideos(String linha) {
		for (char nucleotideo : linha.toCharArray()) {
		    if (nucleotideo != 'A' && nucleotideo != 'C' && nucleotideo != 'G' && nucleotideo != 'T') {
		    	return false;
		    }		    
		}
		return true;
	}
	
	public static String TransformaRNA(String linha) {
		String linhaRNA = "";
		
		for (char nucleotideo : linha.toUpperCase().toCharArray()) {
		    switch (nucleotideo){
		    case 'A' :
		    	linhaRNA += 'U' ;
		    	break;
		    case 'C' :
		    	linhaRNA += 'G' ;
		    	break;
		    case 'G' :
		    	linhaRNA += 'C' ;
		    	break;
		    case 'T' :
		    	linhaRNA += 'A' ;
		    	break;
		    }
		 }
		
		return linhaRNA;
	}
}
