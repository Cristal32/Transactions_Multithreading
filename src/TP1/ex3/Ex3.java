package TP1.ex3;

public class Ex3 {
	
	public static void main(String[] args) {
		
		Thread tortue = new Thread(new Animal(10), "tortue");
		
		Thread lievre = new Thread(new Animal(20), "lievre");
		
		tortue.start();
		lievre.start();
		
	}

}
