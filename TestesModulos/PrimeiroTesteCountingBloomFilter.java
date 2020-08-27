package TestesModulos;
import java.util.*;
import Modulos.CountingBloomFilter;

public class PrimeiroTesteCountingBloomFilter {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = 100; // tamanho do bloom filter - como nas aulas práticas
	
		int k = 20; // numero de hash functions - como nas aulas práticas
		
		CountingBloomFilter cbf = new CountingBloomFilter(n,k); // inicializar um novo bloom filter
		
		String[] membros = {"Portugal","Portugal","EUA","China","China","China","Reino Unido","Cazaquistão","Espanha","Itália"}; // SE QUISER ALTERAR O CONTEUDO DO BLOOM FILTER
		
		String[] teste = {"Portugal","EUA","China","Russia","Polónia","França"}; // SE QUISER ALTERAR O CONTEUDO DO TESTE
		
		for(int i = 0; i < membros.length; i++ ) {
			cbf.insert(membros[i]);
		}
		
		for(int j = 0; j < teste.length; j++ ) {
			if(cbf.membro(teste[j])) {
				System.out.printf("%s está no BloomFilter %d vezes.\n",teste[j],cbf.count(teste[j]));
			}else {
				System.out.printf("%s não está no BloomFilter.\n",teste[j]);
			}
		}
	}

}
