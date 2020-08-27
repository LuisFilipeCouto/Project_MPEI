package Modulos;

public class ContadorEstoc {
	
	private int count;
	private double prob;
	
	public ContadorEstoc(double prob) {
		this.count = 0;
		this.prob = prob;
	}
	
	public int count() {
		double r = Math.random();
		if (r < this.prob){
			this.count++;
			return this.count;
		}
		else
			return -1;
	}
	
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public double getProb() {
		return prob;
	}
	public void setProb(double prob) {
		this.prob = prob;
	}
	@Override
	public String toString() {
		return "Contador_Est [count=" + count + ", prob=" + prob + "]";
	}
	
	public void clear() {
		this.count=0;
	}
	
	
	
	

}
