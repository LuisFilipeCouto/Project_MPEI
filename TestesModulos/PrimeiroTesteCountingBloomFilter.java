package TestesModulos;
import java.util.*;
import Modulos.CountingBloomFilter;

public class PrimeiroTesteCountingBloomFilter {
	static final Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		int n = 100; // tamanho do bloom filter - como nas aulas pr�ticas
	
		int k = 20; // numero de hash functions - como nas aulas pr�ticas
		
		CountingBloomFilter cbf = new CountingBloomFilter(n,k); // inicializar um novo bloom filter
		
		String[] membros = {"Portugal","Portugal","EUA","China","China","China","Reino Unido","Cazaquist�o","Espanha","It�lia"}; // SE QUISER ALTERAR O CONTEUDO DO BLOOM FILTER
		
		String[] teste = {"Portugal","EUA","China","Russia","Pol�nia","Fran�a"}; // SE QUISER ALTERAR O CONTEUDO DO TESTE
		
		for(int i = 0; i < membros.length; i++ ) {
			cbf.insert(membros[i]);
		}
		
		for(int j = 0; j < teste.length; j++ ) {
			if(cbf.membro(teste[j])) {
				System.out.printf("%s est� no BloomFilter %d vezes.\n",teste[j],cbf.count(teste[j]));
			}else {
				System.out.printf("%s n�o est� no BloomFilter.\n",teste[j]);
			}
		}
	}

}
