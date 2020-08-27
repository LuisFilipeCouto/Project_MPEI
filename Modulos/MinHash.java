package Modulos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MinHash {
	
	int numFunc;
	int numFich;
	
	ArrayList<String>[] palavras;	
	
	@SuppressWarnings("unchecked")
	public MinHash(File[] fich, int numFunc) throws FileNotFoundException {
		this.numFunc=numFunc;
		this.numFich=fich.length;
		Scanner[] scanArray = new Scanner[numFich];
		this.palavras=new ArrayList[numFich];
		
		for(int i=0; i < fich.length; i++) {
			scanArray[i] = new Scanner(fich[i]);
			palavras[i]=new ArrayList<String>();
			while(scanArray[i].hasNextLine()) {
				palavras[i].add(scanArray[i].nextLine());
			}
			scanArray[i].close();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public MinHash(String[][] arrayPalavras, int numFunc) throws FileNotFoundException {
		this.palavras=new ArrayList[numFich];
		this.numFunc=numFunc;
		this.numFich=arrayPalavras.length;
		
		for(int i=0; i < numFich; i++) {
			for(int j=0; j < arrayPalavras[i].length; j++) {
				palavras[i].add(arrayPalavras[i][j]);
			}
		}
	}
	
	public void printPalavras() {		// prints every line of every file
		int linha, i;
		for(int file=0; file < this.numFich; file++) {
			System.out.println("FICHEIRO " + (file+1));
			linha=1;
			for(i = 0;i<palavras[file].size();i++) {
				System.out.println("Linha " + linha + "->" + palavras[file].get(i));
				linha++;
			}
		}
	}
			
	public double[][] arrayAssinatura() {
		int hash, minHash;
		double[][] assinatura=new double[numFunc][numFich];
		for(int ficheiro = 0; ficheiro < this.numFich; ficheiro++) {
			for(int i = 0;i<numFunc;i++) {
				minHash=1000000000;	//resetting the minhash
				for(int j = 0; j < palavras[ficheiro].size(); j++) {
					String elemento = palavras[ficheiro].get(j);
					String key = elemento;
					key=key+(i*Math.pow(2, 32)%1234567);	// trying to get sparser minHashes
					hash = Math.abs(key.hashCode());
					if(hash < minHash) {
						minHash=hash;
					}else if(hash > 1000000000) {
						hash=Math.floorDiv(hash,2);
						if(hash < minHash) {
							minHash=hash;
						}
					}
				}
				assinatura[i][ficheiro]=minHash;
			}
		}
		return assinatura;
	}
	
	
	
	public double[][] similaridade() {	
		
		double[][] similaridade = new double[numFich][numFich];
		double[][] assinatura = this.arrayAssinatura();
		
		for(int fich1=0; fich1 < numFich; fich1++) {
			
			for (int fich2 = fich1+1; fich2 < numFich; fich2++) {

				int count = 0;
				
				for(int j = 0; j < this.numFunc; j++) {
					if (assinatura[j][fich1] == assinatura[j][fich2]) {
						count++;
					}
				}
				
			similaridade[fich1][fich2] = (double)count/(double)numFunc;
			}
		}
		return similaridade;
	}
}
	

