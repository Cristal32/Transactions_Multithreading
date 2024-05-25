package TP2.exA;

public class ExA {

	public static void main(String[] args) {
		SanjiEtNamiJob job = new SanjiEtNamiJob(new CompteBanque(1005));
		
		Thread Sanji = new Thread(job, "sanji");
		Thread Nami = new Thread(job, "nami");
		
		Sanji.start();
		Nami.start();
	}

}
