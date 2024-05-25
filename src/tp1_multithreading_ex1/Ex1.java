package tp1_multithreading_ex1;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread threadLettre1 = new ThreadLettre('a','e');
		Thread threadLettre2 = new ThreadLettre('A','E');
		
		ThreadNombre threadNombre = new ThreadNombre();
		Thread threadNombre2 = new Thread(threadNombre);
		
		threadLettre1.start();
		threadLettre2.start();
		threadNombre2.start();
		
		
		
	}

}
