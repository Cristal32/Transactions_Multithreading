package TP2.exB;

public class Transfert implements Runnable{
	
	private Banque banque;
	private int de;
	//private double montant;
	
	public Transfert(Banque banque, int de) {
		this.banque = banque;
		this.de = de;
		//this.montant = montant;
	}

	public void run() {
		int k = 0;
		while(true) {
			 
			 int vers = (int) (Math.random() * banque.size());
			 double montant = Math.random() * 100; // Montant aléatoire entre 0 et 100, Math.random peut donner quelques erreurs
			 
			// Effectuer le transfert
            transfer(this.de, vers, montant);
            
            if(k == 5) {
				break;
			}
            
         // Attendre un court laps de temps
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            k++;
		}
		
	}
	
	public void transfer(int de, int vers, double montant) {
		if(this.banque.getCompte(de) >= montant) {
			try { Thread.sleep(500); } 
			catch (InterruptedException e) { e.printStackTrace(); }
			
			try {
				banque.transferer(de, vers, montant);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Transfert de " + montant + " de: compte " + de + " (" + banque.getCompte(de) + ") vers compte " + vers + "(" + banque.getCompte(vers) + ")" + " Solde total = " + this.banque.soldeTotal());
		}
		else {
			System.out.println("solde unsuffisant!");
		}
	}
}
