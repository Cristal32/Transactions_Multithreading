package TP1.ex3;

public class Animal implements Runnable {
	
	private static final int distanceTotale = 100;
	private int pas; //vitesse du coureur
	private static String vainqueur = "";
	
	//constructeur
	public Animal(int pas) {
		super();
		this.pas = pas;
	}

	public void run(){
		courir();
	}
	
	private void courir() {
		String threadName = Thread.currentThread().getName(); //nom du thread est nom du coureur
		int dejaEndormi = 0;
		for(int i = 0; i <= distanceTotale; i += pas ) {
			
			System.out.println("Distance parcourue par " + threadName + " : " + i + "m");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			//lievre
			if(threadName.equals("lievre") && i >= 50 && dejaEndormi == 0) {
				System.out.println("Lievre DORT !!!!");
				try {
					Thread.currentThread();
					Thread.sleep(10000); // 10 secondes
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dejaEndormi = 1;
			}
			
			if( i >= distanceTotale) {
				if(vainqueur.equals("")) {
					this.vainqueur = threadName;
					System.out.println(" le vainqueur est : " + vainqueur);
				}
			}
		}
	}
}
