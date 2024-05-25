package TP1.ex2;

public class Afficher implements Runnable {
	
	private Vecteur vecteur;
	private HorlogeGraph hg;
	
	public Afficher(Vecteur vecteur) {
		super();
		this.vecteur = vecteur;
	}
	
	public Afficher(Vecteur vecteur, HorlogeGraph hg) {
		super();
		this.vecteur = vecteur;
		this.hg = hg;
	}
	
	//getters
	public Vecteur getVecteur() {
		return this.vecteur;
	}
	
	//setters
	public void setVecteur(Vecteur vect) {
		this.vecteur = vect;
	}
	
	@Override
	public void run() {
		while(true) {
			
			//secondes 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return;
			}
			vecteur.setSec(vecteur.getSec() + 1);
			
			//minutes
			if(vecteur.getSec() == 60) {
				vecteur.setSec(0);
				vecteur.setMin(vecteur.getMin() + 1);
			}
			
			//heures
			if(vecteur.getMin() == 60) {
				vecteur.setMin(0);
				vecteur.setHeure(vecteur.getHeure() + 1);
			}
			
			 // Met à jour l'horloge graphique
	        hg.updateHorloge(vecteur);
		}
		
		
	}
	
}
