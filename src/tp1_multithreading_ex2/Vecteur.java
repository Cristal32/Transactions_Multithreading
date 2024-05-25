package tp1_multithreading_ex2;

public class Vecteur {
	private int heure;
	private int minute;
	private int seconde;
	
	public Vecteur(int heure, int minute, int seconde) {
		this.heure = heure;
		this.minute = minute;
		this.seconde = seconde;
	}
	
	//getters
	public int getSec() {
		return this.seconde;
	}
	public int getMin() {
		return this.minute;
	}
	public int getHeure() {
		return this.heure;
	}
	
	//setters
	public void setSec(int sec) {
		this.seconde = sec;
	}
	public void setMin(int min) {
		this.minute = min;
	}
	public void setHeure(int heure) {
		this.heure = heure;
	}
	
	@Override
	public String toString() {
		return seconde + ":" + minute + ":" + heure;
	}
}
