package TestesModulos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

import Modulos.CountingBloomFilter;

public class TerceiroTesteCountingBloomFilter {
	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File fich1 = new File("cidadeserras.txt");  // MUDAR FICHEIRO AQUI
		File fich2 = new File("trabalhadoresdomar.txt");  // MUDAR FICHEIRO AQUI

		int n = 10000000;  // tamanho do bloom filter
		
		System.out.println("Numero de Hash Functions:");
		
		int k = sc.nextInt();
		
		Scanner lerFich1 = new Scanner(fich1);
		
		CountingBloomFilter cbf = new CountingBloomFilter(n,k);
		
		while(lerFich1.hasNext()) {
			String palavra = lerFich1.next();
			cbf.insert(palavra);
			//System.out.println(palavra);
		}
		lerFich1.close();
		
		Scanner lerFich2 = new Scanner(fich2);
		
		int palavras = 0;
		
		while(lerFich2.hasNext()) {
			String str = lerFich2.next();
			//System.out.println(str);
			if(cbf.membro(str)) {
				//System.out.printf("A palavra (%s) pertence ao (%s) e ao ficheiro (%s).\n",str, fich2,fich1 ); //para saber as palavras que pertencem aos 2 ficheiros.
			}else {
				palavras = palavras+ 1;
				System.out.printf("A palavra (%s) pertence ao ficheiro (%s) e não ao ficheiro (%s).\n",str,fich2,fich1);
			}
		}
		System.out.printf("O ficheiro (%s) tem %d palavras que não pertencem ao ficheiro (%s).\n",fich2,palavras,fich1);
		lerFich2.close();
	}
}
