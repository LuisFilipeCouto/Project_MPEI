package DemonstracaoConjunta;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Modulos.ContadorEstoc;
import Modulos.CountingBloomFilter;
import Modulos.MinHash;

public class Main {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws FileNotFoundException {
		
		File fich1 = new File("maias.txt");    // ESCOLHER FICHEIRO AQUI
		Scanner lerFich1 = new Scanner(fich1);    
		
		File fich2 = new File("contos.txt");  // ESCOLHER FICHEIRO AQUI
		Scanner lerFich2 = new Scanner(fich2);
		
		
		
		int palavrasfich1 = 0;
		int palavrasfich2 = 0;
		int palavrascont = 0;
		
		System.out.println("Introduza a probabilidade:");
		double p =	sc.nextDouble();
		
		System.out.println("Numero de Hash Functions?");
		int nh = sc.nextInt(); 	//numero de hashfunctions
		
		while(p>1 || p<0){
			System.out.println("ERRO: Insira uma probabilidade entre 0 e 1!");
			System.out.println("Introduza a probabilidade:");
			p =	sc.nextDouble();}
		
		CountingBloomFilter cbf = new CountingBloomFilter(100000000,nh);
		if(p<=1 && p>=0){
			while(lerFich1.hasNext()) {
				ContadorEstoc cont = new ContadorEstoc(p);
				int resultado = cont.count();
				String elemento = lerFich1.next();
				palavrasfich1++;
				if(resultado == 1 ) {
					palavrascont++;
					cbf.insert(elemento);
					//System.out.println(elemento);
				}
			}
		int palavrasiguais = 0;	
		while(lerFich2.hasNext()){
			String str = lerFich2.next();
			palavrasfich2++;
			if(cbf.membro(str)) {
				palavrasiguais++;
			}
		}
		
		File[] fichArray = {fich1,fich2};
		int numFich = fichArray.length;
		int numFunc;
		
		numFunc = 100;
		
		MinHash minhash = new MinHash(fichArray, numFunc);
		
		double[][] arrayassinatura = minhash.arrayAssinatura();
		
		double[][] similaridade = minhash.similaridade();
		
		double similaridadeFich = 0;

		System.out.printf("Foi criado um BloomFilter com tamanho %d e %d HashFunctions.\n",palavrascont,nh);
		double probobtida = palavrascont*100/palavrasfich1;
		double probintroduzida = p;
		double dif = Math.abs(probobtida/100-probintroduzida);
        
		System.out.printf("%.3f%% das palavras foram contadas.\n", probobtida);
		System.out.printf("A diferença entre a probabilidade introduzida e a obtida foi de %.5f.\n",dif);
		
		for(int i = 0; i<numFich; i++) {
			for(int j = 0; j<numFich; j++) {
				if(similaridade[i][j] !=0) {
					similaridadeFich = similaridade[i][j];
				    System.out.printf("O ficheiro %s e o ficheiro %s têm uma similaridade de %f.\n",fichArray[i],fichArray[j],similaridadeFich);
				}
			}
		}
		System.out.printf("O ficheiro %s tem %d palavras,o contador contou %d palavras.\n",fich1,palavrasfich1,palavrascont);
		System.out.printf("O ficheiro %s tem %d palavras das quais %d pertencem a ambos os ficheiros.\n",fich2,palavrasfich2,palavrasiguais);
		System.out.println("\nQual o limiar para ser considerado plágio?");
		
		double limiar = sc.nextDouble();
		
		while(limiar>1 || p<0){    
			System.out.println("ERRO: Insira um limiar entre 0 e 1!");
			System.out.println("Qual o limiar para ser considerado plágio?");
			limiar =	sc.nextDouble();
			}
		
		if(similaridadeFich >= limiar) {
			System.out.println("A similaridade é igual ou maior que o limiar: EXISTE PLÁGIO!");
		}else {System.out.printf("A similaridade não ultrapassa o limiar: NÃO EXISTE PLÁGIO!");}
		}
	}
}
