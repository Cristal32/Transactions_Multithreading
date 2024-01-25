package tp2_multithreading_exB;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banque {
	
	private final double[] comptes;
	
	// ------------------- pour les locks et conditions -------------------
	//private Lock bankLock = new ReentrantLock(); 
	//private Condition soldeSuffisant = bankLock.newCondition();
	// --------------------------------------------------------------------
	
	//constructeur
	public Banque(int nbrComptes, double soldeInitiale) {
		this.comptes = new double[nbrComptes];
        // Initialize all accounts with the initial value
        for (int i = 0; i < comptes.length; i++) {
            comptes[i] = soldeInitiale;
        }
	}
	
	// ------------------- original -------------------
//	public double soldeTotal() {
//		double solde = 0;
//		 for (int i = 0; i < comptes.length; i++) {
//	            solde += comptes[i];
//	        }
//		 return solde;
//	}
	
	// ------------------- with locks and conditions -------------------
//	public double soldeTotal() {
//		bankLock.lock();
//		try{
//			double somme=0;
//			for (double c : comptes) { somme += c; }
//			return somme;
//		} finally{ bankLock.unlock(); }
//	}
	
	// ------------------- with synchronized -------------------
	public synchronized double soldeTotal() {
		double solde = 0;
		 for (int i = 0; i < comptes.length; i++) {
	            solde += comptes[i];
	        }
		 return solde;
	}
	
	// ------------------- original -------------------
//	public void transferer(int de, int vers, double montant) {
//		comptes[de] -= montant;
//		comptes[vers] += montant;
//	}
	
	// ------------------- with locks and conditions -------------------
//	public void transferer(int de, int vers, double montant) throws InterruptedException {
//			bankLock.lock();
//			try{ 
//				while(comptes[de] < montant) {
//					soldeSuffisant.await();
//					//attendre la condition
//					comptes[de] -= montant;
//					comptes[vers] += montant;
//					soldeSuffisant.signalAll();
//					//débloquer les threads attendant la condition
//				}
//			} finally{
//			bankLock.unlock();
//			}
//	}
	
	// ------------------- with synchronized -------------------
	public synchronized void transferer(int de,int vers, double montant) throws InterruptedException {
		while(comptes[de] < montant) {
			System.out.printf(" Solde insuffisant\n");
			wait(); //attendre
		} 
		comptes[de] -= montant;
		comptes[vers] += montant;
		notifyAll(); //notifier les threads en attente
	}

	public int size() {
		return comptes.length;
	}
	
	//getter
	public double[] getComptes() {
		return comptes;
	}
	
	public double getCompte(int i) {
		return comptes[i];
	}
	
	//setter
	public void setCompte(int i, double solde) {
		comptes[i] = solde;
	}
	
	// Method to print account information - [not used]
    public void afficherInfoComptes() {
        System.out.println("Nombre de comptes : " + comptes.length);
        for (int i = 0; i < comptes.length; i++) {
            System.out.println("Compte " + i + ": Solde = " + comptes[i]);
        }
    }
}
