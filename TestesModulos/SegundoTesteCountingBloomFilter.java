package TestesModulos;
import java.util.*;
import Modulos.CountingBloomFilter;

public class SegundoTesteCountingBloomFilter {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = 8000; // tamanho do bloom filter
		System.out.println("Número de hash functions:");
		int k = sc.nextInt();
		
		CountingBloomFilter cbf = new CountingBloomFilter(n,k);
		
		String[] membros = new String[1000]; // cria um array de tamanho 1000
		
		String[] teste = new String[10000];  // cria um array de tamanho 10000
		
		for(int i = 0; i < membros.length; i++ ) {
			String str = CountingBloomFilter.generateString(40); // gera strings aleatorias com 40 caracteres
			//System.out.println("Bloom ->" + str);
			cbf.insert(str); // insere as strings no bloom filter
		}
		
		for(int k1 = 0; k1 < teste.length; k1++ ) {
			String str = CountingBloomFilter.generateString(40); 
			teste[k1] = str; 
			//System.out.println("Teste ->" + str);
		}
		
		int falsospositivos = 0;
		
		for(int j = 0; j < teste.length; j++ ) {
			if(cbf.membro(teste[j])) {
				falsospositivos++;
				System.out.printf("O elemento %s pertence ao BloomFilter.\n",teste[j]);
			}else{
				System.out.printf("O elemento %s não pertence ao BloomFilter.\n",teste[j]);
			}
		}
		
		System.out.printf("Existem %d falsos positivos.", falsospositivos);
	}
}
