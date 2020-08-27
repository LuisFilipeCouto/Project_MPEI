package TestesModulos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Modulos.MinHash;

public class TesteMinHash {
	
	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File fich1 = new File("contos.txt");  // MUDAR FICHEIRO AQUI
		
		File fich2 = new File("familiaingleza.txt"); // MUDAR FICHEIRO AQUI
		
		File fich3 = new File("amorperdicao.txt");     // MUDAR FICHEIRO AQUI
		
		File fich4 = new File("contos.txt");          // MUDAR FICHEIRO AQUI
		
		File[] fichArray = {fich1,fich2,fich3,fich4};
		
		int numFich = fichArray.length;
		
		int numFunc;
		
		numFunc = 100;
		
		MinHash minhash = new MinHash(fichArray, numFunc);
		
		double[][] arrayassinatura = minhash.arrayAssinatura();
		
		double[][] similaridade = minhash.similaridade();
		
		
		print2D(arrayassinatura); //linhas -> nFunc colunas-> nFich
		System.out.println("");
		print2D(similaridade);
		for(int i = 0; i<numFich; i++) {
			for(int j = 0; j<numFich; j++) {
				if(similaridade[i][j] > 0) {  // So imprime se houver alguma similaridade (se nao forem completamente diferentes)
				System.out.printf("O ficheiro %s e o ficheiro %s têm uma similaridade de %f\n",fichArray[i],fichArray[j],similaridade[i][j]);
				}
			}
		}
	}
    public static void print2D(double[][] mat){
        for (double[] row : mat) 
            System.out.println(Arrays.toString(row)); 
    }
}
