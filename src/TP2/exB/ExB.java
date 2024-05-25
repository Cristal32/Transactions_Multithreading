package TP2.exB;

public class ExB {

	public static void main(String[] args) {
		//Simulation
		Banque banque = new Banque(5, 1000);
		for (int de = 0; de < banque.size(); de ++) {
		Runnable r = new Transfert(banque,de);
		new Thread(r).start();
		}
		
//		Banque maBanque = new Banque(5, 1000.0);
//		maBanque.afficherInfoComptes();
//		
//		System.out.println(maBanque.soldeTotal());
//		System.out.println(maBanque.size());
	
	}
}
