package Modulos;

import java.util.Random;

public class CountingBloomFilter {

	private int tamanho; 
	private int numfunc;
	private int[] array;
	
	public CountingBloomFilter(int tamanho, int numfunc) {
		this.tamanho=tamanho;
		this.array= new int[tamanho];
		this.numfunc=numfunc;
		
		for(int i = 0; i < tamanho; i++) {
			array[i]=0;
		}
	}
	
	public void insert(String elemento) {
		String key = elemento;
		for(int i = 0; i < numfunc; i++) {
			key=key+i;
			int hash = Math.abs(key.hashCode());
			int index = hash%tamanho;
			array[index]++;
		}
	}
	
	public void delete(String elemento) {
		if(this.membro(elemento)) {
			String key = elemento;
			for(int i = 0; i < numfunc; i++) {
				key=key+i;
				int hash = Math.abs(key.hashCode());
				int index = hash%tamanho;
				array[index]--;
			}
		}else {
			System.out.printf("O elemento %s nao pertence ao Bloom Filter./n",elemento);
		}
	}
	
	public int count(String elemento) {
		int returnThis=0;
		String key = elemento;
		for(int i = 0; i < numfunc; i++) {
			key=key+i;
			int hash = Math.abs(key.hashCode());
			int index = hash%tamanho;
			if(array[index]<returnThis || i==0) {
				returnThis=array[index];
			}
		}
		return returnThis;
	}
	
	public boolean membro(String elemento) {
		String key = elemento;
		for(int i = 0; i < numfunc; i++) {
			key=key+i;
			int hash = Math.abs(key.hashCode());
			int index = hash%tamanho;
			if(array[index]==0) {
				return false;
			}
		}
		return true;
	}
	private static final String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	
	public static String generateString(int length) {
	    Random random = new Random();
	    StringBuilder builder = new StringBuilder(length);

	    for (int i = 0; i < length; i++) {
	        builder.append(alfabeto.charAt(random.nextInt(alfabeto.length())));
	    }

	    return builder.toString();
	}
}
