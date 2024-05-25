package TP2.exA;

public class CompteBanque {
	double solde;
	
	//constructeur
	public CompteBanque(double solde) {
		super();
		this.solde = solde;
	}
	
	//getter
	public double getSolde() {
		return solde;
	}
	
	//setter
	public void setSolde(int solde) {
		this.solde = solde;
	}
	
	public void retirer(double montant) {
		this.solde -= montant;
	}
	

}
