package tp1_multithreading_ex1;

public class ThreadNombre implements Runnable {
	
	public void run() {
		for(int i = 0; i <= 10; i++) {
			if(i%2 == 0) {
				System.out.println(i);
			}
		
		}
	}

}
