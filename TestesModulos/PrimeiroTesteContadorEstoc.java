package TestesModulos;

import java.util.*;
import Modulos.ContadorEstoc;

public class PrimeiroTesteContadorEstoc {

	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Probabilidade de sucesso?");
		
		double p = sc.nextDouble();
		ContadorEstoc cont = new ContadorEstoc(p);
		
	    int resultado = cont.count();
	    
		while(p>1 || p<0){    // Tem de ser uma probabilidade válida, ou seja, entre 0 e 1
			System.out.println("ERRO: Insira uma probabilidade entre 0 e 1!");
			System.out.println("Introduza a probabilidade:");
			p =	sc.nextDouble();
			}
		
		if(resultado == 1) {
	    	System.out.printf("O contador contou");
	    }else 
	    	System.out.printf("O contador não contou");
		
		sc.close();
		
	}

}
