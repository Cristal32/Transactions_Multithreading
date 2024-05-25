package tp1_multithreading_ex1;

public class ThreadLettre extends Thread {
	private char premiere_lettre;
	private char derniere_lettre;
	
	public ThreadLettre(char premiere_lettre, char derniere_lettre) {
		this.premiere_lettre = premiere_lettre;
		this.derniere_lettre = derniere_lettre;
	}
	
	@Override
	public void run() {
		for(char lettre = premiere_lettre; lettre <= derniere_lettre; lettre++) {
			System.out.println(lettre);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
			
	}
}
