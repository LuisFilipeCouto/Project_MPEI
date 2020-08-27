package TestesModulos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import Modulos.CountingBloomFilter;

public class QuartoTesteCountingBloomFilter {
	
	static final Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) throws FileNotFoundException {
		
		File fich1 = new File("primobasilio.txt");  // ESCOLHER QUAL FICHEIRO DESEJA LER
		int count = 0;
		int n = 100000000;
		
		System.out.println("Numero de Hash Functions:");
		int k = sc.nextInt();
		
		
		Scanner lerFich1 = new Scanner(fich1);
		
		CountingBloomFilter cbf = new CountingBloomFilter(n,k);
		
		while(lerFich1.hasNext()) {
			String palavra = lerFich1.next();
			cbf.insert(palavra);
			// System.out.println(palavra);
		}
		lerFich1.close();
		System.out.println("Qual é a palavra?");
		String str = sc.next();
		count = cbf.count(str);
		System.out.printf("A palavra %s aparece no ficheiro %d vezes.",str,count);
		
	}
}
