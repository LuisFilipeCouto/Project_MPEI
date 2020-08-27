package TestesModulos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Modulos.ContadorEstoc;

public class SegundoTesteContadorEstoc {

	private static Scanner sc;

	@SuppressWarnings("resource")
	public static void main(String[] args) throws FileNotFoundException {
		sc = new Scanner(System.in);
		String nomefich = "u.data";  // ESCOLHER NESTA LINHA QUAL O FICHEIRO QUE DESEJA LER
		File fin = new File(nomefich);
		Scanner lerFich = new Scanner(fin);
		int palavrasreal = 0;
		int palavrascont = 0;
		
		double p;
		System.out.println("Introduza a probabilidade:");
		p =	sc.nextDouble();
		
		while(p>1 || p<0){
			System.out.println("ERRO: Insira uma probabilidade entre 0 e 1!");
			System.out.println("Introduza a probabilidade:");
			p =	sc.nextDouble();}
		
		if(p<=1 && p>=0){
			while(lerFich.hasNext()) {
				ContadorEstoc cont = new ContadorEstoc(p);
				int resultado = cont.count();
				lerFich.next();
				palavrasreal++;
				if(resultado == 1 ) {
					palavrascont++;
				}
				
			}
			double probobtida = palavrascont*100/palavrasreal;
			double probintroduzida = p;
			double dif = Math.abs(probobtida/100-probintroduzida);
			System.out.printf("O ficheiro tem %d palavras.\n",palavrasreal );
			System.out.printf("O contador contou %d palavras.\n", palavrascont);
			System.out.printf("%.3f%% das palavras foram contadas.\n", probobtida);
			System.out.printf("A diferença entre a probabilidade introduzida e a obtida foi de %.5f.",dif);
		}
		
	}
}