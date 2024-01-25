package tp2_multithreading_exA;

public class SanjiEtNamiJob implements Runnable {
	
	private CompteBanque compte;
	
	public SanjiEtNamiJob(CompteBanque compte) {
		super();
		this.compte = compte;
	}
	
	@Override
	public void run() {
		while(true) {
			demandeRetrait(200);
			
			//tell the thread to sleep for just 1 milisecond because otherwise only one thread does all their wanted operations and then the other does 
			try { Thread.sleep(1); } 
			catch (InterruptedException e1) { e1.printStackTrace(); }
			
			if(this.compte.getSolde() < 100) {
				System.out.println("\n- " + Thread.currentThread().getName() + " : J'ai termine !");
				break;
			}
		}
	}
	
	private synchronized void demandeRetrait(double montant) {
		String threadName = Thread.currentThread().getName();
		if(this.compte.getSolde() < montant) {
			System.out.println("\n- " + threadName + " : pas assez d'argent pour retirer 100.0 (" + this.compte.getSolde() + ")");
		}
		else { //si solde >= montant a retirer
			System.out.println("\n- " + threadName + " : est sur le point de retirer (" + this.compte.getSolde() + ")");
			
			//endormir le thread
			try { Thread.sleep(500); } 
			catch (InterruptedException e) { e.printStackTrace(); }
			
			System.out.println("\n- " + threadName + " : je suis reveille.");
			compte.retirer(montant);
			System.out.println("\n- " + threadName + " : a complete le retrait (" + this.compte.getSolde() + ")");
		}
		
		
		
	}
}
